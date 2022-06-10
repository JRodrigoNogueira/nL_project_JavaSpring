package com.newlife.Newlife.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
public class MoradorForm {

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

}
