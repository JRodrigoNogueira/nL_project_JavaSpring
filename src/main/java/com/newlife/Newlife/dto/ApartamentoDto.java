package com.newlife.Newlife.dto;

import com.newlife.Newlife.entity.Apartamento;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class ApartamentoDto {

    private Long id;

    public ApartamentoDto(Apartamento apartamento) {
        this.id = apartamento.getId();
    }

}
