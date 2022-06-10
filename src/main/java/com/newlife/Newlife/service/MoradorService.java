package com.newlife.Newlife.service;

import com.newlife.Newlife.dto.MoradorDto;
import com.newlife.Newlife.dto.MoradorForm;
import com.newlife.Newlife.entity.Morador;
import com.newlife.Newlife.repository.MoradorRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@AllArgsConstructor
@Service
public class MoradorService {

    private final MoradorRepository moradorRepository;

    public MoradorDto findByMorador(String morador){
        Morador m = this.moradorRepository.findByMorador(morador).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return new MoradorDto(m);
    }

    public void createMorador(MoradorForm form){
        Morador v = new Morador(form);
        this.moradorRepository.save(v);
    }

    public void updateMorador(String morador, MoradorForm form){
        Morador v = this.moradorRepository.findByMorador(morador).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        v.atualizarRegistro(form);
        moradorRepository.save(v);
    }

    public void deleteMorador(String morador) {
        Morador m = this.moradorRepository.findByMorador(morador).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        moradorRepository.delete(m);
    }


}
