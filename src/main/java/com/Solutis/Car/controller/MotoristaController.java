package com.solutis.car.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.solutis.car.model.dto.MotoristaDTO;

import com.solutis.car.service.MotoristaService;

@RestController
@RequestMapping("/clientes")
public class MotoristaController {

    private final MotoristaService motoristaService;
   
    @Autowired
    public MotoristaController(MotoristaService motoristaService) {
        this.motoristaService = motoristaService;
    }

    //Criar motorista
    @PostMapping
    public ResponseEntity<MotoristaDTO> criarMotorista(@RequestBody MotoristaDTO motoristaDTO) {
        MotoristaDTO novoMotoristaDTO = motoristaService.criarMotorista(motoristaDTO);
        return new ResponseEntity<>(novoMotoristaDTO, HttpStatus.CREATED);
    }

  


}
