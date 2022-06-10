package com.newlife.Newlife.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class VisitanteForm {

    private String visitante;
    private String rg;
    private String Cpf;
    private String telefone1;
    private String telefone2;
    private String observacoes;
    private Long idApartamento;

}
