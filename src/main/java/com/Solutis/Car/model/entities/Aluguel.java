package com.solutis.car.model.entities;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.*;

@Data
@Entity
public class Aluguel {

	private Calendar dataPedido;
    private Date dataEntrega;
    private Date dataDevolucao;
    private BigDecimal valorTotal;

    @OneToOne
    private Carro carro;

    @OneToOne
    private Motorista motorista;

    @OneToOne
    private ApoliceSeguro apoliceSeguro;


}
