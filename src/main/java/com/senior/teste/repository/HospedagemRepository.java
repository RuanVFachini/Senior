package com.senior.teste.repository;

import com.senior.teste.model.Hospedagem;
import com.senior.teste.model.Hospede;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospedagemRepository extends JpaRepository<Hospedagem, Long> {

    public Hospedagem findByHospede(Hospede hospede);
}
