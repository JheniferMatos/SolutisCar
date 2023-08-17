package com.solutis.car.model.dto;

import com.solutis.car.model.entities.enums.Categoria;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModeloCarroDTO {
    @NotBlank(message = "A descrição é obrigatória")
    @Size(min = 3, max = 200, message = "A descrição deve ter entre 3 e 200 caracteres")
    private String descricao;

    @NotNull(message = "O fabricante é obrigatório")
    private Long fabricanteId;

    @NotNull(message = "A categoria é obrigatória")
    private Categoria categoria;
}
