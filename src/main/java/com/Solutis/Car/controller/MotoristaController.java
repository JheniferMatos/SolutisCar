package com.solutis.car.controller;

import com.solutis.car.model.dto.MotoristaDTO;
import com.solutis.car.service.MotoristaService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class MotoristaController {

    @Autowired
    private MotoristaService motoristaService;

    @PostMapping
    public ResponseEntity<String> cadastrarMotorista(@RequestBody MotoristaDTO motoristaDTO) {
        motoristaService.add(motoristaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Motorista cadastrado com sucesso!");
    }

    @GetMapping
    public ResponseEntity<List<MotoristaDTO>> listarMotoristas() {
        List<MotoristaDTO> motoristas = motoristaService.findAll();
        return ResponseEntity.ok(motoristas);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMotorista(@PathVariable Long id) {
        motoristaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<MotoristaDTO> atualizarMotorista(
            @PathVariable Long id,
            @RequestBody MotoristaDTO motoristaDTO) {
        MotoristaDTO updatedMotorista = motoristaService.update(id, motoristaDTO);
        return ResponseEntity.ok(updatedMotorista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MotoristaDTO> buscarMotoristaPorId(@PathVariable Long id) {
        MotoristaDTO motorista = motoristaService.findById(id);
        return ResponseEntity.ok(motorista);
    }

}
