package com.newlife.Newlife.controller;

import com.newlife.Newlife.dto.VisitanteDto;
import com.newlife.Newlife.dto.VisitanteForm;
import com.newlife.Newlife.service.VisitanteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("visitante")
@AllArgsConstructor
public class VisitanteController {

    private final VisitanteService visitanteService;

    @GetMapping("/{visitante}")
    public ResponseEntity<?> getUserById(@PathVariable String visitante){
        VisitanteDto dto = this.visitanteService.findByVisitante(visitante);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PostMapping()
    @Transactional
    public ResponseEntity<?> criarVisitante(@RequestBody VisitanteForm form){
        this.visitanteService.createVisitante(form);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{visitante}")
    @Transactional
    public ResponseEntity<?> atualizarVisitante(@PathVariable String visitante, @RequestBody VisitanteForm form){
        this.visitanteService.updateVisitante(visitante, form);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{visitante}")
    public ResponseEntity<?> deletarVisitante(@PathVariable String visitante){
        this.visitanteService.deleteVisitante(visitante);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
