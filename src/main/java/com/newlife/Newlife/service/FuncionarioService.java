package com.newlife.Newlife.service;

import com.newlife.Newlife.dto.FuncionarioDto;
import com.newlife.Newlife.dto.FuncionarioForm;
import com.newlife.Newlife.entity.Funcionario;
import com.newlife.Newlife.repository.FuncionarioRepository;
import com.newlife.Newlife.repository.specifications.FuncionarioSpecification;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@AllArgsConstructor
@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioDto findByFuncionario(String funcionario){
        Funcionario f = this.funcionarioRepository.findByFuncionario(funcionario).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return new FuncionarioDto(f);
    }

    public void createFuncionario(FuncionarioForm form){
        Funcionario v = new Funcionario(form);
        this.funcionarioRepository.save(v);
    }

    public void updateFuncionario(String funcionario, FuncionarioForm form){
        Funcionario v = this.funcionarioRepository.findByFuncionario(funcionario).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        v.atualizarRegistro(form);
        funcionarioRepository.save(v);
    }

    public void deleteFuncionario(String funcionario){
        Funcionario f = this.funcionarioRepository.findByFuncionario(funcionario).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        funcionarioRepository.delete(f);
    }

    public Page<Funcionario> findAll(Pageable pageable) {  return this.funcionarioRepository.findAll(pageable);   }

    public Page<Funcionario> findAll(Pageable pageable, String query) {
        return this.funcionarioRepository.findAll(FuncionarioSpecification.likeGenericQuery(query),pageable);
    }


}
