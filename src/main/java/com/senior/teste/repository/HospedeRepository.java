package com.senior.teste.repository;

import com.senior.teste.model.Hospede;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospedeRepository extends JpaRepository<Hospede, Long> {

    Hospede findByNomeOrCpfOrTelefone(String nome, String cpf, String telefone);
}
