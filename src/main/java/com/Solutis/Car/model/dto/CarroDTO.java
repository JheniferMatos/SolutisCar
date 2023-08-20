package com.solutis.car.model.dto;

import java.math.BigDecimal;

import com.solutis.car.model.entities.Carro;

// import com.solutis.car.model.entities.Carro;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
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

    private Long modeloCarroId;

    private Long[] acessoriosId;

    private Boolean alugado = false;

    private ModeloCarroDTO modeloCarro;
    private FabricanteDTO fabricante;

    public CarroDTO(Carro entity) {
        this.id = entity.getId();
        this.placa = entity.getPlaca();
        this.chassi = entity.getChassi();
        this.cor = entity.getCor();
        this.valorDiaria = entity.getValorDiaria();
        this.modeloCarroId = entity.getModeloCarro().getId();
        // this.acessoriosId = getAcessoriosId(entity);
        this.alugado = entity.getAluguel() != null && !entity.getAluguel().isEmpty();
    }
    
    // private Long[] getAcessoriosId(Carro entity) {
    //     return entity.getAcessorio().stream()
    //             .map(acessorio -> acessorio.getId())
    //             .toArray(Long[]::new);
    // }

}
