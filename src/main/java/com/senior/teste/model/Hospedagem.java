package com.senior.teste.model;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Hospedagem {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Hospede hospede;
    private Date dataCheckin;
    private Date dataCheckout;
    private boolean checkin;
    private boolean addicionalVeiculo;
    private Double valor;

}
