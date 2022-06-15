package com.newlife.Newlife.controller;

import com.newlife.Newlife.dto.VisitanteDto;
import com.newlife.Newlife.dto.VisitanteForm;
import com.newlife.Newlife.service.VisitanteService;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("visitante")
@AllArgsConstructor
public class VisitanteController {

    private final VisitanteService visitanteService;

    private final ConversionService conversionService;

    @GetMapping("/{visitante}")
    public ResponseEntity<?> getUserById(@RequestParam String visitante){
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
    public ResponseEntity<?> atualizarVisitante(@RequestParam String visitante, @RequestBody VisitanteForm form){
        this.visitanteService.updateVisitante(visitante, form);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{visitante}")
    public ResponseEntity<?> deletarVisitante(@PathVariable String visitante){
        this.visitanteService.deleteVisitante(visitante);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/allVisitantes")
    public @ResponseBody
    Page<VisitanteDto> findAllPaginated(
            @RequestParam(required = false) String query,
            Pageable pageable
    ){
        if(query==null){
            return this.visitanteService.findAll(pageable).map(entity -> this.conversionService.convert(entity, VisitanteDto.class));
        }
        return this.visitanteService.findAll(pageable,query).map(entity -> this.conversionService.convert(entity, VisitanteDto.class));
    }

}
