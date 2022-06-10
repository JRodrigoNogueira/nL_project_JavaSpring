package com.newlife.Newlife.controller;

import com.newlife.Newlife.dto.FuncionarioDto;
import com.newlife.Newlife.dto.FuncionarioForm;
import com.newlife.Newlife.service.FuncionarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("funcionario")
@AllArgsConstructor
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    @GetMapping("/{funcionario}")
    public ResponseEntity<?> getUserById(@PathVariable String funcionario) {
        FuncionarioDto dto = this.funcionarioService.findByFuncionario(funcionario);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PostMapping()
    @Transactional
    public ResponseEntity<?> criarFuncionario(@RequestBody FuncionarioForm form){
        this.funcionarioService.createFuncionario(form);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{funcionario}")
    @Transactional
    public ResponseEntity<?> atualizarFuncionario(@PathVariable String funcionario, @RequestBody FuncionarioForm form){
        this.funcionarioService.updateFuncionario(funcionario, form);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{funcionario}")
    public ResponseEntity<?> deletarFuncionario(@PathVariable String funcionario){
        this.funcionarioService.deleteFuncionario(funcionario);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}