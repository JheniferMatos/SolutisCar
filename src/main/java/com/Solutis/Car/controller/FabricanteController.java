package com.solutis.car.controller;

import com.solutis.car.model.dto.FabricanteDTO;
import com.solutis.car.service.FabricanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fabricantes")
public class FabricanteController {

    @Autowired
    private FabricanteService fabricanteService;

    @GetMapping("/{id}")
    public ResponseEntity<FabricanteDTO> getFabricanteById(@PathVariable Long id) {
        FabricanteDTO fabricanteDTO = fabricanteService.findById(id);
        return ResponseEntity.ok(fabricanteDTO);
    }

    @GetMapping
    public ResponseEntity<List<FabricanteDTO>> getAllFabricantes() {
        List<FabricanteDTO> fabricantes = fabricanteService.findAll();
        return ResponseEntity.ok(fabricantes);
    }

    @PostMapping
    public ResponseEntity<FabricanteDTO> addFabricante(@RequestBody FabricanteDTO fabricanteDTO) {
        FabricanteDTO addedFabricante = fabricanteService.add(fabricanteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedFabricante);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FabricanteDTO> updateFabricante(@PathVariable Long id, @RequestBody FabricanteDTO fabricanteDTO) {
        FabricanteDTO updatedFabricante = fabricanteService.update(id, fabricanteDTO);
        return ResponseEntity.ok(updatedFabricante);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFabricante(@PathVariable Long id) {
        fabricanteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
