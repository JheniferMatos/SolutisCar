package com.solutis.car.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.solutis.car.model.dto.MotoristaDTO;
import java.util.List;
import com.solutis.car.service.MotoristaService;

@RestController
@RequestMapping("/clientes")
public class MotoristaController {

    private final MotoristaService motoristaService;

    public MotoristaController(MotoristaService motoristaService) {
        this.motoristaService = motoristaService;
    }

    // Criar motorista
    @PostMapping
    public ResponseEntity<MotoristaDTO> criarMotorista(@RequestBody MotoristaDTO motoristaDTO) {
        MotoristaDTO novoMotoristaDTO = motoristaService.criarMotorista(motoristaDTO);
        return new ResponseEntity<>(novoMotoristaDTO, HttpStatus.CREATED);
    }

    // Obter motorista por id
    @GetMapping("/{id}")
    public ResponseEntity<MotoristaDTO> obterMotoristaPorId(@PathVariable Long id) {
        return motoristaService.obterMotoristaPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Listar todos os clientes
    @GetMapping
    public ResponseEntity<List<MotoristaDTO>> listarMotoristas() {
        List<MotoristaDTO> motoristas = motoristaService.listarMotoristas();
        return ResponseEntity.ok(motoristas);
    }

}
