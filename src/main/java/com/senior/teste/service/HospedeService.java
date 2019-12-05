package com.senior.teste.service;

import com.senior.teste.DTO.HospedeDTO;
import com.senior.teste.Exception.HospedeNaoEncontradoException;
import com.senior.teste.model.Hospede;
import com.senior.teste.repository.HospedagemRepository;
import com.senior.teste.repository.HospedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HospedeService {

    @Autowired
    private HospedeRepository hospedeRepository;

    @Autowired
    private HospedagemRepository hospedagemRepository;

    public HospedeService(){
    }

    public List<Hospede> getAll(){
        return hospedeRepository.findAll();
    }

    public Hospede getById(Long id){
        return hospedeRepository.findById(id).orElseThrow(() -> new HospedeNaoEncontradoException(id));
    }

    public Hospede getByInfo(Hospede hospede){
        return hospedeRepository.findByNomeOrCpfOrTelefone(hospede.getNome(), hospede.getCpf(), hospede.getTelefone());
    }

    public List<HospedeDTO> getCheckin(){
        TreeMap<Hospede,Double> result = new TreeMap<>();
        hospedagemRepository.findAll().stream().filter(x -> x.isCheckin() && !x.isCheckout()).map(hospedagem -> {
                    if(result.containsKey(hospedagem.getHospede())){
                        double total = result.get(hospedagem.getHospede()) + hospedagem.getValor();
                        result.put(hospedagem.getHospede(),total);
                    }else{
                        result.put(hospedagem.getHospede(),hospedagem.getValor());
                    }
                    return hospedagem;
                });

        List<HospedeDTO> resultList = new ArrayList<HospedeDTO>();
        result.forEach((hospede, aDouble) -> {
            resultList.add(
                    new HospedeDTO(hospede.getId(),hospede.getNome(),hospede.getCpf(),hospede.getTelefone(),aDouble)
            );
        });

        return resultList;
    }

    public List<HospedeDTO> getCheckout(){
        TreeMap<Hospede,Double> result = new TreeMap<>();
        hospedagemRepository.findAll().stream().filter(x -> x.isCheckout()).map(hospedagem -> {
            if(result.containsKey(hospedagem.getHospede())){
                double total = result.get(hospedagem.getHospede()) + hospedagem.getValor();
                result.put(hospedagem.getHospede(),total);
            }else{
                result.put(hospedagem.getHospede(),hospedagem.getValor());
            }
            return hospedagem;
        });

        List<HospedeDTO> resultList = new ArrayList<HospedeDTO>();
        result.forEach((hospede, aDouble) -> {
            resultList.add(
                    new HospedeDTO(hospede.getId(),hospede.getNome(),hospede.getCpf(),hospede.getTelefone(),aDouble)
            );
        });

        return resultList;
    }

    public Hospede add(Hospede hospede){
        return hospedeRepository.save(hospede);
    }

    public Hospede update(Hospede novoHospede, Long id){
        return hospedeRepository.findById(id).map(hospede -> {
            hospede.setNome(novoHospede.getNome());
            hospede.setCpf(novoHospede.getCpf());
            hospede.setTelefone(novoHospede.getTelefone());
            return hospedeRepository.save(hospede);
        }).orElseThrow(() -> new HospedeNaoEncontradoException(id));
    }

    public void delete(Long id){
        hospedeRepository.deleteById(id);
    }

}
