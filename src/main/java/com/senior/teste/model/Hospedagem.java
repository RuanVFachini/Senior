package com.senior.teste.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "hospedagem")
public class Hospedagem implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_hospede")
    private Hospede hospede;
    @Column(name = "dt_checkin")
    private Date dataCheckin;
    @Column(name = "dt_checkout")
    private Date dataCheckout;
    @Column(name = "checkin")
    private boolean checkin;
    @Column(name = "checkout")
    private boolean checkout;
    @Column(name = "veiculoAdicional")
    private boolean adicionalVeiculo;
    @Column(name = "valor")
    private Double valor;

}
