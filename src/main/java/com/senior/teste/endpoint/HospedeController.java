package com.senior.teste.endpoint;

import com.senior.teste.Exception.HospedeNaoEncontradoException;
import com.senior.teste.model.Hospede;
import com.senior.teste.service.HospedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HospedeController {

    @Autowired
    private HospedeService service;

    @RequestMapping("/hospede/antigos")
    public List<Hospede> getAntigos(){
        return service.getAntigos();
    }

    @RequestMapping("/hospede")
    public List<Hospede> getAll(){
        return service.getAll();
    }

    @RequestMapping("/hospede/{id}")
    public Hospede get(@PathVariable Long id) {
        return service.get(id);
    }

    @PostMapping("/hospede")
    public Hospede save(@RequestBody Hospede hospede){
        return service.add(hospede);
    }

    @PutMapping("/hospede/{id}")
    public Hospede update(@RequestBody Hospede hospede, @PathVariable Long id) throws Exception {
        return service.update(hospede, id);
    }

    @DeleteMapping("hospede/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
