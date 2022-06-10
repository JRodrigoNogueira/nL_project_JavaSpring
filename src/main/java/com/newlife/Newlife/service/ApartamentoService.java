package com.newlife.Newlife.service;

import com.newlife.Newlife.dto.ApartamentoDto;
import com.newlife.Newlife.entity.Apartamento;
import com.newlife.Newlife.repository.ApartamentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@AllArgsConstructor
@Service
public class ApartamentoService {

    private final ApartamentoRepository apartamentoRepository;

    public ApartamentoDto findById(Long id){
        Apartamento ap = this.apartamentoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return new ApartamentoDto(ap);
    }

    public void deleteApartamento(Long id){
        Apartamento ap = this.apartamentoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        apartamentoRepository.delete(ap);
    }


}
