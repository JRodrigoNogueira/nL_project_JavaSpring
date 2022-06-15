package com.newlife.Newlife.service;

import com.newlife.Newlife.dto.VeiculoDto;
import com.newlife.Newlife.dto.VeiculoForm;
import com.newlife.Newlife.entity.Veiculo;
import com.newlife.Newlife.repository.VeiculoRepository;
import com.newlife.Newlife.repository.specifications.VeiculoSpecification;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@AllArgsConstructor
@Service
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;

    public VeiculoDto findByPlaca(String placa){
        Veiculo veiculo = this.veiculoRepository.findByPlaca(placa).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return new VeiculoDto(veiculo);
    }

    public void createVeiculo(VeiculoForm form){
        // Validação
        Optional<Veiculo> veiculoConflito = this.veiculoRepository.findByPlaca(form.getPlaca());
        if(veiculoConflito.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Já existe um carro com essa placa cadastrada no BD");
        // Criar o novo registro de veiculo
        Veiculo novoVeiculo = new Veiculo(form);
        this.veiculoRepository.save(novoVeiculo);
    }

    public void updateVeiculo(String placa, VeiculoForm form){
        // Validação
        Veiculo veiculo = this.veiculoRepository.findByPlaca(placa).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        // Criar o novo registro de veiculo
        veiculo.atualizarRegistro(form);
        veiculoRepository.save(veiculo);
    }

    public void deleteVeiculo(Long id){
        // Validação
        Veiculo veiculo = this.veiculoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        // Apagar registro de veiculo
        veiculoRepository.delete(veiculo);
    }

    public Page<Veiculo> findAll(Pageable pageable) {
        return this.veiculoRepository.findAll(pageable);
    }

    public Page<Veiculo> findAll(Pageable pageable, String query) {
        return this.veiculoRepository.findAll(VeiculoSpecification.likeGenericQuery(query),pageable);
    }

}
