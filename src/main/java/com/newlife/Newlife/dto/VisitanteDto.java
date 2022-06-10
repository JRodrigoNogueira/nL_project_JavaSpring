package com.newlife.Newlife.dto;

import com.newlife.Newlife.entity.Visitante;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class VisitanteDto {

    private String visitante;

    private String rg;

    private String cpf;

    private String telefone1;

    private String telefone2;

    private String observacoes;

    public VisitanteDto(Visitante visitante) {
        this.visitante = visitante.getVisitante();
        this.rg = visitante.getRg();
        this.cpf = visitante.getCpf();
        this.telefone1 = visitante.getTelefone1();
        this.telefone2 = visitante.getTelefone2();
        this.observacoes = visitante.getObservacoes();
    }

}
