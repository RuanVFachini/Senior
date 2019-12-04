package com.senior.teste.service;

import com.senior.teste.Exception.HospedeNaoEncontradoException;
import com.senior.teste.model.Hospede;
import com.senior.teste.repository.HospedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospedeService {

    @Autowired
    private HospedeRepository repository;

    public HospedeService(){

    }

    public Hospede update(Hospede novoHospede, Long id){
        return repository.findById(id).map(hospede -> {
            hospede.setNome(novoHospede.getNome());
            return repository.save(hospede);
        }).orElseThrow(() -> new HospedeNaoEncontradoException(id));
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Hospede add(Hospede hospede){
        return repository.save(hospede);
    }

    public Hospede get(Long id){
        return repository.findById(id).orElseThrow(() -> new HospedeNaoEncontradoException(id));
    }

    public List<Hospede> getAll(){
        return repository.findAll();
    }

    public List<Hospede> getAntigos(){
        return repository.findAll();
    }
}
