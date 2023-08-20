// package com.solutis.car.controller;

// import com.solutis.car.model.dto.ModeloCarroDTO;
// import com.solutis.car.service.ModeloCarroService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/modeloscarro")
// public class ModeloCarroController {

//     @Autowired
//     private ModeloCarroService modeloCarroService;

//     @GetMapping("/{id}")
//     public ResponseEntity<ModeloCarroDTO> getModeloCarroById(@PathVariable Long id) {
//         ModeloCarroDTO modeloCarroDTO = modeloCarroService.findById(id);
//         return ResponseEntity.ok(modeloCarroDTO);
//     }

//     @GetMapping
//     public ResponseEntity<List<ModeloCarroDTO>> getAllModelosCarro() {
//         List<ModeloCarroDTO> modelosCarro = modeloCarroService.findAll();
//         return ResponseEntity.ok(modelosCarro);
//     }

//     @PostMapping
//     public ResponseEntity<ModeloCarroDTO> addModeloCarro(@RequestBody ModeloCarroDTO modeloCarroDTO) {
//         ModeloCarroDTO addedModeloCarro = modeloCarroService.add(modeloCarroDTO);
//         return ResponseEntity.status(HttpStatus.CREATED).body(addedModeloCarro);
//     }

//     @PutMapping("/{id}")
//     public ResponseEntity<ModeloCarroDTO> updateModeloCarro(@PathVariable Long id, @RequestBody ModeloCarroDTO modeloCarroDTO) {
//         ModeloCarroDTO updatedModeloCarro = modeloCarroService.update(id, modeloCarroDTO);
//         return ResponseEntity.ok(updatedModeloCarro);
//     }

//     @DeleteMapping("/{id}")
//     public ResponseEntity<Void> deleteModeloCarro(@PathVariable Long id) {
//         modeloCarroService.deleteById(id);
//         return ResponseEntity.noContent().build();
//     }
// }
