package com.newlife.Newlife.service;

import com.newlife.Newlife.dto.VisitanteDto;
import com.newlife.Newlife.dto.VisitanteForm;
import com.newlife.Newlife.entity.Visitante;
import com.newlife.Newlife.repository.VisitanteRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@AllArgsConstructor
@Service
public class VisitanteService {

    private final VisitanteRepository visitanteRepository;

    public VisitanteDto findByVisitante(String visitante){
        Visitante v = this.visitanteRepository.findByVisitante(visitante).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return new VisitanteDto(v);
    }

    public void createVisitante(VisitanteForm form){
        Visitante v = new Visitante(form);
        this.visitanteRepository.save(v);
    }

    public void updateVisitante(String visitante, VisitanteForm form){
        Visitante v = this.visitanteRepository.findByVisitante(visitante).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        v.atualizarRegistro(form);
        visitanteRepository.save(v);
    }

    public void deleteVisitante(String visitante){
        // Validação
        Visitante v = this.visitanteRepository.findByVisitante(visitante).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        // Apagar registro de veiculo
        visitanteRepository.delete(v);
    }

}
