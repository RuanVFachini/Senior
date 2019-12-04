package com.senior.teste.endpoint;

import com.senior.teste.model.Hospedagem;
import com.senior.teste.model.Hospede;
import com.senior.teste.service.HospedagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HospedagemController {

    @Autowired
    private HospedagemService service;

    @PostMapping("/hospedagem")
    public Hospedagem add(@RequestBody Hospedagem hospedagem){
        return service.add(hospedagem);
    }

    @PostMapping("/hospedagem/checkin")
    public void Checkin(@RequestBody Hospede hospede){
        service.checkin(hospede);
    }
}
