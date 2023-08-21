package com.solutis.car.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.solutis.car.model.dto.CarroDTO;
import com.solutis.car.service.CarroService;

import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @GetMapping("/{id}")
    public ResponseEntity<CarroDTO> buscarCarroPorId(@PathVariable Long id) {
        CarroDTO carroDTO = carroService.findById(id);
        return ResponseEntity.ok(carroDTO);
    }

    @GetMapping
    public ResponseEntity<List<CarroDTO>> listarCarros() {
        List<CarroDTO> carrosDTO = carroService.findAll();
        return ResponseEntity.ok(carrosDTO);
    }

    @PostMapping
    public ResponseEntity<CarroDTO> criarCarro(@RequestBody CarroDTO carroDTO) {
        CarroDTO novoCarroDTO = carroService.add(carroDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoCarroDTO);
    }

    @PostMapping("/carrocompleto")
    public ResponseEntity<CarroDTO> criarCarroCompleto(@RequestBody CarroDTO carroDTO) {
        CarroDTO carroCriado = carroService.criarCarroCompleto(carroDTO);
        return new ResponseEntity<>(carroCriado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarroDTO> atualizarCarro(@PathVariable Long id, @RequestBody CarroDTO carroDTO) {
        CarroDTO carroAtualizadoDTO = carroService.update(id, carroDTO);
        return ResponseEntity.ok(carroAtualizadoDTO);
    }

    @GetMapping("/disponiveis")
    public ResponseEntity<List<CarroDTO>> getVeiculosDisponiveis(
            @RequestParam(required = false) String categoria,
            @RequestParam(required = false) List<String> acessorios) {

        List<CarroDTO> veiculosDisponiveis = carroService.findVeiculosDisponiveis(categoria, acessorios);
        return ResponseEntity.ok(veiculosDisponiveis);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCarro(@PathVariable Long id) {
        carroService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
