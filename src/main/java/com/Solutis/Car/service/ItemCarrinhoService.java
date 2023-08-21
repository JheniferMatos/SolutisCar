package com.solutis.car.service;

import com.solutis.car.mapper.ItemCarrinhoMapper;
import com.solutis.car.model.dto.ItemCarrinhoDTO;
import com.solutis.car.model.entities.*;
import com.solutis.car.repositories.ItemCarrinhoRepository;
import com.solutis.car.repositories.CarroRepository;
import com.solutis.car.service.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ItemCarrinhoService {

    @Autowired
    private ItemCarrinhoRepository repository;

    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private ItemCarrinhoMapper mapper;

    public ItemCarrinhoService(ItemCarrinhoRepository repository){
        this.repository = repository;
    }

    public ItemCarrinho adicionarItemAoCarrinho(ItemCarrinho itemCarrinho) {

        Optional<Carro> veiculo = carroRepository.findById(itemCarrinho.getCarroId());
        LocalDate dataInicio = itemCarrinho.getDataInicial();
        LocalDate dataTermino = itemCarrinho.getDataFinal();

        if (veiculo.isEmpty() || veiculo.get().isAlugado()) {
            return null;
        }

        long diasDeAluguel = Period.between(dataInicio, dataTermino).getDays();
        BigDecimal valor = veiculo.get().getValorDiaria().multiply(BigDecimal.valueOf(diasDeAluguel));

        itemCarrinho.setPreco(valor);
        repository.save(itemCarrinho);
        return itemCarrinho;
    }

    public void RetirarCarroDoCarrinho(ItemCarrinho itemCarrinho){
        repository.delete(itemCarrinho);
    }

    @Transactional
    public ItemCarrinhoDTO editarCarrinho(Long id, ItemCarrinhoDTO itemCarrinhoDTO){
        ItemCarrinho existingItemCarrinho = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Acessório não encontrado"));
        ItemCarrinho itemCarrinhoUpdate = mapper.toEntity(itemCarrinhoDTO);
        itemCarrinhoUpdate.setId(existingItemCarrinho.getId());
        itemCarrinhoUpdate = repository.save(itemCarrinhoUpdate);
        return mapper.toDto(itemCarrinhoUpdate);
    }
    public List<ItemCarrinho> listarTodosOsItens(){
        return repository.findAll();
    }

    public String confirmarReserva(Motorista cliente) {
        BigDecimal valorTotal = repository.findAll().stream()
                .map(ItemCarrinho::getPreco)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        List<Carro> veiculos = carroRepository.findAll();
        for (ItemCarrinho itemCarrinho : repository.findAll()) {
            for (Carro veiculo : veiculos) {
                if (Objects.equals(veiculo.getId(), itemCarrinho.getCarroId())) {
                    veiculo.isAlugado();
                    carroRepository.save(veiculo);
                }
            }
        }
        repository.deleteAll();
        Reserva reserva = new Reserva(0, cliente.getNome(), valorTotal, repository.findAll());

        return reserva.toString(carroRepository.findAll());
    }

    public String consultar(Motorista cliente) {
        BigDecimal valorTotal = repository.findAll().stream()
                .map(ItemCarrinho::getPreco)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        Reserva reserva = new Reserva(0, cliente.getNome(), valorTotal, repository.findAll());
        return reserva.toString(carroRepository.findAll());
    }
}
