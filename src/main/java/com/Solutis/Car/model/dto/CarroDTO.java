package com.solutis.car.model.dto;

import java.math.BigDecimal;
import java.util.List;

import com.solutis.car.model.entities.Acessorio;
import com.fasterxml.jackson.annotation.JsonIgnore;


// import com.solutis.car.model.entities.ModeloCarro;

import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarroDTO {

    private Long id;

    @NotBlank(message = "A placa é obrigatória")
    @Size(min = 7, max = 7, message = "A placa deve ter 7 caracteres")
    private String placa;

    @NotBlank(message = "O chassi é obrigatório")
    @Size(min = 17, max = 17, message = "O chassi deve ter 17 caracteres")
    private String chassi;

    @NotBlank(message = "A cor é obrigatória")
    @Size(min = 3, max = 200, message = "A cor deve ter entre 3 e 200 caracteres")
    private String cor;

    @NotNull(message = "O valor da diária é obrigatório")
    private BigDecimal valorDiaria;

    @NotBlank(message = "A imagem é obrigatória")
    @Size(min = 3, max = 200, message = "A imagem deve ter entre 3 e 200 caracteres")
    private String imageUrl;

    @JsonIgnore
    @OneToMany(mappedBy = "carro")
    private List<Acessorio> acessorios;

    private Boolean alugado = false;

    private ModeloCarroDTO modeloCarro;
    
    private FabricanteDTO fabricante;

//    public CarroDTO(Carro entity) {
//        this.id = entity.getId();
//        this.placa = entity.getPlaca();
//        this.chassi = entity.getChassi();
//        this.cor = entity.getCor();
//        this.valorDiaria = entity.getValorDiaria();
//        this.alugado = entity.getAluguel() != null && !entity.getAluguel().isEmpty();
//        this.imageUrl = entity.getImageUrl();
//        this.acessorios = entity.getAcessorios();
//    }
}