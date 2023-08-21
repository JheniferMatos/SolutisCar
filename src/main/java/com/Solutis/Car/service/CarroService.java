package com.solutis.car.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.solutis.car.mapper.CarroMapper;
// import com.solutis.car.model.dto.AcessorioDTO;
// import com.solutis.car.mapper.FabricanteMapper;
// import com.solutis.car.mapper.ModeloCarroMapper;
// import com.solutis.car.model.dto.CarroCompletoDTO;
import com.solutis.car.model.dto.CarroDTO;
// import com.solutis.car.model.entities.Acessorio;
// import com.solutis.car.model.dto.FabricanteDTO;
// import com.solutis.car.model.dto.ModeloCarroDTO;
// import com.solutis.car.model.entities.Acessorio;
import com.solutis.car.model.entities.Carro;
// import com.solutis.car.model.entities.Fabricante;
// import com.solutis.car.model.entities.ModeloCarro;
// import java.util.Set;
// import com.solutis.car.repositories.AcessorioRepository;
import com.solutis.car.repositories.CarroRepository;
// import com.solutis.car.repositories.FabricanteRepository;
import com.solutis.car.service.exception.NotFoundException;

// import java.util.ArrayList;
// import java.util.HashSet;
import java.util.List;

// import com.solutis.car.repositories.ModeloCarroRepository;
import java.util.stream.Collectors;

@Service
public class CarroService implements CrudService<CarroDTO> {

    @Autowired
    private CarroRepository repository;

    @Autowired
    private CarroMapper mapper;

    // @Autowired
    // private ModeloCarroRepository modeloCarroRepository;

    // @Autowired
    // private AcessorioRepository acessorioRepository;

    // @Autowired
    // private FabricanteRepository fabricanteRepository;

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


    

    // @Transactional
    // public CarroDTO criarCarroCompleto(CarroDTO carroCompletoDTO) {
    //     Fabricante fabricante = new Fabricante();
    //     fabricante.setNome(carroCompletoDTO.getFabricante().getNome());

    //     ModeloCarro modeloCarro = new ModeloCarro();
    //     modeloCarro.setDescricao(carroCompletoDTO.getModeloCarro().getDescricao());
    //     modeloCarro.setCategoria(carroCompletoDTO.getModeloCarro().getCategoria());
    //     modeloCarro.setFabricante(fabricante);

    //     Carro carro = new Carro();
    //     carro.setPlaca(carroCompletoDTO.getPlaca());
    //     carro.setChassi(carroCompletoDTO.getChassi());
    //     carro.setCor(carroCompletoDTO.getCor());
    //     carro.setValorDiaria(carroCompletoDTO.getValorDiaria());
    //     carro.setImageUrl(carroCompletoDTO.getImageUrl());
    //     carro.setModeloCarro(modeloCarro);

    //     // Salvar fabricante e modelo do carro
    //     fabricanteRepository.save(fabricante);
    //     modeloCarroRepository.save(modeloCarro);

    //     Set<Acessorio> acessoriosSet = new HashSet<>();
    //     if (carroCompletoDTO.getAcessorios() != null) {
    //         for (AcessorioDTO acessorioDTO : carroCompletoDTO.getAcessorios()) {
    //             Acessorio acessorio = new Acessorio();
    //             acessorio.setDescricao(acessorioDTO.getDescricao());
    //             acessoriosSet.add(acessorio);
    //         }
    //     }

    //     carro.setAcessorios(acessoriosSet);
    // }

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

    @Override
    public CarroDTO add(CarroDTO payload) {
        Carro carro = this.mapper.toEntity(payload);
        carro = this.repository.save(carro);
        return this.mapper.toDto(carro);
    }

    @Transactional(readOnly = true)
    public List<CarroDTO> findVeiculosDisponiveis(String categoria, List<String> acessorios) {
        List<Carro> veiculosDisponiveis = repository.findVeiculosDisponiveis(categoria, acessorios);
        return veiculosDisponiveis.stream().map(mapper::toDto).collect(Collectors.toList());
    }

}
