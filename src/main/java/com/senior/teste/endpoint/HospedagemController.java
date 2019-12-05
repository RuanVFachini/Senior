package com.senior.teste.endpoint;

import com.senior.teste.model.Hospedagem;
import com.senior.teste.service.HospedagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HospedagemController {

    @Autowired
    private HospedagemService service;

    @GetMapping("/hospedagem/")
    public List<Hospedagem> getAll(){
        return service.getAll();
    }

    @GetMapping("/hospedagem/{id}")
    public Hospedagem getById(@PathVariable Long id){
        return service.getById(id);
    }

    @PostMapping("/hospedagem/")
    public Hospedagem add(@RequestBody Hospedagem hospedagem){
        return service.add(hospedagem);
    }

    @PutMapping("/hospedagem/{id}")
    public Hospedagem update(@RequestBody Hospedagem hospedagem, @PathVariable Long id){
        return service.update(hospedagem, id);
    }

    @DeleteMapping("/hospedagem/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

    @PostMapping("/hospedagem/checkin/{id}")
    public Hospedagem checkin(@PathVariable Long id){
        return service.checkin(id);
    }

    @PostMapping("/hospedagem/checkout/{id}")
    public Hospedagem checkout(@PathVariable Long id){
        return service.checkout(id);
    }
}
