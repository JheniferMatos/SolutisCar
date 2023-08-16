package com.solutis.car.model.entities;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Entity
public class Aluguel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "A data do pedido é obrigatória")
    @Column(name = "data_pedido" ,nullable = false)
	private Calendar dataPedido;

    @NotBlank(message = "A data de entrega é obrigatória")
    @Column(name = "data_entrega",nullable = false)
    private Date dataEntrega;

    @NotBlank(message = "A data de devolução é obrigatória")
    @Column(name = "data_devolucao",nullable = false)
    private Date dataDevolucao;

    @NotBlank(message = "O valor total é obrigatório")
    @Column(name = "valor_total",nullable = false)
    private BigDecimal valorTotal;

    @JsonIgnoreProperties("aluguel")
    @OneToOne(optional = false)
    @JoinColumn(name = "carro_id", nullable = false)
    private Carro carro;

    @JsonIgnoreProperties("aluguel")
    @ManyToOne
    @JoinColumn(name = "motorista_id", nullable = false)
    private Motorista motorista;

    @JsonIgnoreProperties("aluguel")
    @OneToOne(optional = false)
    @JoinColumn(name = "apolice_seguro_id", nullable = false)
    private ApoliceSeguro apoliceSeguro;


}
