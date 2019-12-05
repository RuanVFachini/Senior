package com.senior.teste.service;

import com.senior.teste.Exception.HospedagemNaoEncontradaException;
import com.senior.teste.model.Hospedagem;
import com.senior.teste.repository.HospedagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class HospedagemService {

    @Autowired
    private HospedagemRepository hospedagemRepository;

    public HospedagemService(){
    }

    public List<Hospedagem> getAll(){
        return hospedagemRepository.findAll();
    }

    public Hospedagem getById(Long id){
        return hospedagemRepository.findById(id).orElseThrow(() -> new HospedagemNaoEncontradaException(id));
    }

    public Hospedagem add(Hospedagem hospedagem){
        int[] dias = new int[2];
        Utils utils = new Utils();
        dias = utils.getDiasUtilsFds(hospedagem.getDataCheckin(),hospedagem.getDataCheckout());

        Double valor = dias[0]*120.00 + dias[1]*150.00;

        if(hospedagem.isAdicionalVeiculo()){
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
        return hospedagemRepository.save(hospedagem);
    }

    public Hospedagem update(Hospedagem novaHospedagem, Long id){
        return hospedagemRepository.findById(id).map(hospedagem -> {
            hospedagem.setValor(novaHospedagem.getValor());
            hospedagem.setAdicionalVeiculo(novaHospedagem.isAdicionalVeiculo());
            hospedagem.setCheckin(novaHospedagem.isCheckin());
            hospedagem.setCheckout(novaHospedagem.isCheckout());
            hospedagem.setDataCheckin(novaHospedagem.getDataCheckin());
            hospedagem.setDataCheckout(novaHospedagem.getDataCheckout());
            hospedagem.setHospede(novaHospedagem.getHospede());
            return hospedagemRepository.save(hospedagem);
        }).orElseThrow(() -> new HospedagemNaoEncontradaException(id));
    }

    public void delete(Long id){
        hospedagemRepository.deleteById(id);
    }

    public Hospedagem checkin(Long id){
        return hospedagemRepository.findById(id).map(hospedagem -> {
            hospedagem.setCheckin(true);
            return hospedagemRepository.save(hospedagem);
        }).orElseThrow(() -> new HospedagemNaoEncontradaException(id));
    }

    public Hospedagem checkout(Long id){
        return hospedagemRepository.findById(id).map(hospedagem -> {
            hospedagem.setCheckout(true);
            return hospedagemRepository.save(hospedagem);
        }).orElseThrow(() -> new HospedagemNaoEncontradaException(id));
    }
}
