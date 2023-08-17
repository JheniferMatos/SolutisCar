package com.solutis.car.model.entities;

import java.util.Date;

import org.hibernate.validator.constraints.br.CPF;

import com.solutis.car.model.entities.enums.Sexo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SuperBuilder
public abstract class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 3, max = 200, message = "O nome deve ter entre 3 e 200 caracteres")
    @Column(nullable = false)
    private String nome;

    @NotNull(message = "A data de nascimento é obrigatória")
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    @NotBlank(message = "O CPF é obrigatório")
    @CPF(message = "O CPF é inválido")
    @Size(min = 11, max = 11, message = "O CPF deve ter 11 digitos")
    @Column(nullable = false, unique = true)
    private String cpf;

    @NotNull(message = "O sexo é obrigatório")
    @Enumerated(EnumType.STRING)
    @Column(name= "sexo", nullable = false)
    private Sexo sexo;
}
