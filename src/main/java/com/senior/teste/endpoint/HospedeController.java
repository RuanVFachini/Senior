package com.senior.teste.endpoint;

import com.senior.teste.DTO.HospedeDTO;
import com.senior.teste.model.Hospede;
import com.senior.teste.service.HospedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HospedeController {

    @Autowired
    private HospedeService service;

    @GetMapping("/hospede")
    public List<Hospede> getAll(){
        return service.getAll();
    }

    @GetMapping("/hospede/{id}")
    public Hospede getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/hospede/search")
    public Hospede getById(@RequestBody Hospede hospede) {
        return service.getByInfo(hospede);
    }

//    @GetMapping("hospede/list/checkin")
//    public List<HospedeDTO> emCheckin(){
//        return service.getCheckin();
//    }
//
//    @GetMapping("hospede/list/checkout")
//    public List<HospedeDTO> emCheckout(){
//        return service.getCheckout();
//    }

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
