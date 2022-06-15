package com.newlife.Newlife.dto;

import com.newlife.Newlife.entity.Morador;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class MoradorDto {

    private Long id;
    private String morador;

    private String rg;

    private String cpf;

    private String telefone1;

    private String telefone2;

    private String email;

    private String contatoEmergencia;

    private String telefoneEmergencia;

    private String observacoes;

    private Long idApartamento;

    public MoradorDto(Morador morador) {
        this.id = morador.getId();
        this.morador = morador.getMorador();
        this.rg = morador.getRg();
        this.cpf = morador.getCpf();
        this.telefone1 = morador.getTelefone1();
        this.telefone2 = morador.getTelefone2();
        this.email = morador.getEmail();
        this.contatoEmergencia = morador.getContatoEmergencia();
        this.telefoneEmergencia = morador.getTelefoneEmergencia();
        this.observacoes = morador.getObservacoes();
        this.idApartamento = morador.getIdApartamento();
    }

}
