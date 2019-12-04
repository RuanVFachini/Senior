package com.senior.teste.service;

import com.senior.teste.model.Hospedagem;
import com.senior.teste.model.Hospede;
import com.senior.teste.repository.HospedagemRepository;
import com.senior.teste.repository.HospedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Service
public class HospedagemService {

    @Autowired
    private HospedagemRepository repository;

    public HospedagemService(){
    }

    public Hospedagem add(Hospedagem hospedagem){
        int[] dias = new int[2];
        Utils utils = new Utils();
        dias = utils.getDiasUtilsFds(hospedagem.getDataCheckin(),hospedagem.getDataCheckout());

        Double valor = dias[0]*120.00 + dias[1]*150.00;

        if(hospedagem.isAddicionalVeiculo()){
            valor += dias[0]*15.00 + dias[1]*20.00;
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(hospedagem.getDataCheckout());
        if(cal.get(Calendar.HOUR_OF_DAY) > 16 && cal.get(Calendar.MINUTE) > 30){
            if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || cal.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY){
                valor += 150.00;
            }else{
                valor += 120.00;
            }
        }

        hospedagem.setValor(valor);
        return repository.save(hospedagem);
    }

    public void checkin(Hospede hospede){

    }
}
