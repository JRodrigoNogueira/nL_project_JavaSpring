package com.newlife.Newlife.controller;

import com.newlife.Newlife.dto.FuncionarioDto;
import com.newlife.Newlife.dto.FuncionarioForm;
import com.newlife.Newlife.service.FuncionarioService;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("funcionario")
@AllArgsConstructor
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    private final ConversionService conversionService;

    @GetMapping("/{funcionario}")
    public ResponseEntity<?> getUserById(@RequestParam String funcionario) {
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
    public ResponseEntity<?> atualizarFuncionario(@RequestParam String funcionario, @RequestBody FuncionarioForm form){
        this.funcionarioService.updateFuncionario(funcionario, form);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{funcionario}")
    public ResponseEntity<?> deletarFuncionario(@PathVariable String funcionario){
        this.funcionarioService.deleteFuncionario(funcionario);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/allFuncionarios")
    public @ResponseBody
    Page<FuncionarioDto> findAllPaginated(
            @RequestParam(required = false) String query,
            Pageable pageable
    ){
        if(query==null){
            return this.funcionarioService.findAll(pageable).map(entity -> this.conversionService.convert(entity, FuncionarioDto.class));
        }
        return this.funcionarioService.findAll(pageable,query).map(entity -> this.conversionService.convert(entity, FuncionarioDto.class));
    }
}