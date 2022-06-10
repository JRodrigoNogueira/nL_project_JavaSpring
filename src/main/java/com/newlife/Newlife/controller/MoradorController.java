package com.newlife.Newlife.controller;

import com.newlife.Newlife.dto.MoradorDto;
import com.newlife.Newlife.dto.MoradorForm;
import com.newlife.Newlife.service.MoradorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("morador")
@AllArgsConstructor
public class MoradorController {

    private final MoradorService moradorService;

    @GetMapping("/{morador}")
    public ResponseEntity<?> getUserById(@PathVariable String morador){
        MoradorDto dto = this.moradorService.findByMorador(morador);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PostMapping()
    @Transactional
    public ResponseEntity<?> criarMorador(@RequestBody MoradorForm form){
        this.moradorService.createMorador(form);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PutMapping("/{morador}")
    @Transactional
    public ResponseEntity<?> atualizarMorador(@PathVariable String morador, @RequestBody MoradorForm form){
        this.moradorService.updateMorador(morador, form);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{morador}")
    public ResponseEntity<?> deletarMorador(@PathVariable String morador){
        this.moradorService.deleteMorador(morador);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
