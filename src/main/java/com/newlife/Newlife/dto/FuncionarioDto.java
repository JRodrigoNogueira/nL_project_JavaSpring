package com.newlife.Newlife.dto;

import com.newlife.Newlife.entity.Funcionario;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class FuncionarioDto {

    private Long id;

    private String funcionario;

    private String rg;

    private String cpf;

    private String telefone1;

    private String telefone2;

    private String observacoes;

    private Long idApartamento;

    public FuncionarioDto(Funcionario funcionario) {
        this.id = funcionario.getId();
        this.funcionario = funcionario.getFuncionario();
        this.rg = funcionario.getRg();
        this.cpf = funcionario.getCpf();
        this.telefone1 = funcionario.getTelefone1();
        this.telefone2 = funcionario.getTelefone2();
        this.observacoes = funcionario.getObservacoes();
        this.idApartamento = funcionario.getIdApartamento();
    }

}
