package com.solutis.car.model.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nomeCliente;

    private BigDecimal preco;

    private List<ItemCarrinho> list = new ArrayList<>();

    public String toString(List<Carro> carros) {
        List<Carro> carrosReservados = new ArrayList<>();
        for (ItemCarrinho itemCarrinho : list) {
            for (Carro carro : carros) {
                if (Objects.equals(carro.getId(), itemCarrinho.getCarroId())) {
                    carrosReservados.add(carro);
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Reserva:");
        stringBuilder.append("\n  Cliente: ").append(nomeCliente);
        stringBuilder.append("\n  Preco: R$ ").append(preco);
        stringBuilder.append("\n  Carros Selecionados: ");
        for (Carro veiculoReservado : carrosReservados) {
            for (ItemCarrinho itemCarrinho : list) {
                if (Objects.equals(itemCarrinho.getCarroId(), veiculoReservado.getId())) {
                    stringBuilder.append("\n    ")
                            .append(veiculoReservado.getModeloCarro().getDescricao())
                            .append(" ")
                            .append(veiculoReservado.getCor())
                            .append(" Alugado por: R$ ")
                            .append(itemCarrinho.getPreco())
                            .append(" Durante: ")
                            .append(Period.between(itemCarrinho.getDataInicial(), itemCarrinho.getDataFinal()).getDays())
                            .append(" dias");
                }
            }
        }
        return stringBuilder.toString();
    }
}