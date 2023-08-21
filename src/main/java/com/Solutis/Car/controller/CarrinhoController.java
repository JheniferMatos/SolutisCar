package com.solutis.car.controller;

import com.solutis.car.model.dto.ItemCarrinhoDTO;
import com.solutis.car.model.entities.ItemCarrinho;
import com.solutis.car.model.entities.Motorista;
import com.solutis.car.service.ItemCarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

    private final ItemCarrinhoService carrinhoService;

    @Autowired
    public CarrinhoController(ItemCarrinhoService carrinhoService) {
        this.carrinhoService = carrinhoService;
    }

    @PostMapping("/adicionar")
    public ItemCarrinho adicionarAoCarrinho(@RequestBody ItemCarrinho itemCarrinho) {
        return carrinhoService.adicionarItemAoCarrinho(itemCarrinho);
    }

    @PostMapping("/confirmar")
    public String confirmarReserva(@RequestBody Motorista cliente) {
        String reserva = carrinhoService.confirmarReserva(cliente);
        return cliente.getNome() + ", sua reserva foi confirmada\n" + reserva;
    }

    @GetMapping("/termos")
    public String buscarTermos(@RequestBody Motorista cliente) {
        String reserva = carrinhoService.consultar(cliente);
        return cliente.getNome() + ", seu contrato de aluguel atual:\n" + reserva;
    }

    @DeleteMapping("/remover")
    public ResponseEntity<Void> removerDoCarrinho(@RequestBody ItemCarrinho itemCarrinho) {
        carrinhoService.RetirarCarroDoCarrinho(itemCarrinho);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<ItemCarrinhoDTO> editarNoCarrinho(@PathVariable Long id, @RequestBody ItemCarrinhoDTO itemCarrinhoDTO) {
        ItemCarrinhoDTO updatedItemCarrinho = carrinhoService.editarCarrinho(id, itemCarrinhoDTO);
        return ResponseEntity.ok(updatedItemCarrinho);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ItemCarrinho>> listarVeiculosNoCarrinho() {
        List<ItemCarrinho> itensCarrinho = carrinhoService.listarTodosOsItens();
        return ResponseEntity.ok(itensCarrinho);
    }
}