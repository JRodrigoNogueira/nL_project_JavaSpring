package com.newlife.Newlife.controller;

import com.newlife.Newlife.dto.ApartamentoDto;
import com.newlife.Newlife.service.ApartamentoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("apartamento")
@AllArgsConstructor
public class ApartamentoController {

    private final ApartamentoService apartamentoService;

    @GetMapping("/{apartamento}")
    public ResponseEntity<?> getUserById(@PathVariable Long id){
        ApartamentoDto dto = this.apartamentoService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

}
