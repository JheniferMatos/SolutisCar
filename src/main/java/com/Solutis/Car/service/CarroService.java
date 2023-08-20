package com.solutis.car.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.solutis.car.mapper.CarroMapper;
// import com.solutis.car.mapper.FabricanteMapper;
// import com.solutis.car.mapper.ModeloCarroMapper;
// import com.solutis.car.model.dto.CarroCompletoDTO;
import com.solutis.car.model.dto.CarroDTO;
// import com.solutis.car.model.dto.FabricanteDTO;
// import com.solutis.car.model.dto.ModeloCarroDTO;
import com.solutis.car.model.entities.Acessorio;
import com.solutis.car.model.entities.Carro;
import com.solutis.car.model.entities.Fabricante;
import com.solutis.car.model.entities.ModeloCarro;
import com.solutis.car.repositories.AcessorioRepository;
import com.solutis.car.repositories.CarroRepository;
import com.solutis.car.repositories.FabricanteRepository;
import com.solutis.car.service.exception.NotFoundException;
import java.util.List;
import jakarta.persistence.EntityNotFoundException;

import com.solutis.car.repositories.ModeloCarroRepository;
import java.util.ArrayList;

import java.util.stream.Collectors;

@Service
public class CarroService implements CrudService<CarroDTO> {

    @Autowired
    private CarroRepository repository;

    @Autowired
    private CarroMapper mapper;

    @Autowired
    private ModeloCarroRepository modeloCarroRepository;

    @Autowired
    private AcessorioRepository acessorioRepository;

    @Autowired
    private FabricanteRepository fabricanteRepository;

    

    // @Autowired
    // private ModeloCarroService modeloCarroService;

    // @Autowired
    // private FabricanteService fabricanteService;



    @Transactional(readOnly = true)
    public CarroDTO findById(Long id) {
        return this.mapper.toDto(this.repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Carro não encontrado")));
    }

    @Transactional(readOnly = true)
    public List<CarroDTO> findAll() {
        return this.repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public CarroDTO add(CarroDTO carroDTO) {
        ModeloCarro modeloCarro = modeloCarroRepository.findById(carroDTO.getModeloCarroId())
                .orElseThrow(() -> new NotFoundException("Modelo de Carro não encontrado"));

        Carro carro = new Carro(carroDTO, modeloCarro);
        if (carroDTO.getAcessoriosId() != null) {
            List<Acessorio> acessorios = new ArrayList<>();
            for (Long acessorioId : carroDTO.getAcessoriosId()) {
                Acessorio acessorio = acessorioRepository.findById(acessorioId)
                        .orElseThrow(() -> new EntityNotFoundException("Acessório não encontrado"));
                acessorios.add(acessorio);
            }
            carro.setAcessorio(acessorios);
        }
        carro = repository.save(carro);
        return mapper.toDto(carro);
    }
    @Transactional
    public CarroDTO criarCarroCompleto(CarroDTO carroCompletoDTO) {
        Fabricante fabricante = new Fabricante();
        fabricante.setNome(carroCompletoDTO.getFabricante().getNome());

        ModeloCarro modeloCarro = new ModeloCarro();
        modeloCarro.setDescricao(carroCompletoDTO.getModeloCarro().getDescricao());
        modeloCarro.setCategoria(carroCompletoDTO.getModeloCarro().getCategoria());
        modeloCarro.setFabricante(fabricante);

        Carro carro = new Carro();
        carro.setPlaca(carroCompletoDTO.getPlaca());
        carro.setChassi(carroCompletoDTO.getChassi());
        carro.setCor(carroCompletoDTO.getCor());
        carro.setValorDiaria(carroCompletoDTO.getValorDiaria());
        carro.setImageUrl(carroCompletoDTO.getImageUrl());
        carro.setModeloCarro(modeloCarro);

        fabricanteRepository.save(fabricante);
        modeloCarroRepository.save(modeloCarro);
        repository.save(carro);

        return new CarroDTO(carro);
    }


    @Transactional
    public CarroDTO update(Long id, CarroDTO carroDTO) {
        Carro existingCarro = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Carro não encontrado"));
        Carro carroUpdate = this.mapper.toEntity(carroDTO);
        carroUpdate.setId(existingCarro.getId());
        carroUpdate = repository.save(carroUpdate);
        return this.mapper.toDto(carroUpdate);
    }

    @Transactional
    public void deleteById(Long id) {
        Carro carro = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Carro não encontrado"));
        repository.delete(carro);
    }
}
