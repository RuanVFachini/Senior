package com.senior.teste.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HospedeDTO {

    private Long id;
    private String nome;
    private String cpf;
    private String telefone;
    private Double totalGasto;
}
