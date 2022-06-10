package com.newlife.Newlife.entity;


import com.newlife.Newlife.dto.FuncionarioForm;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Funcionarios")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Funcionario")
    private String funcionario;

    @Column(name = "Rg")
    private String rg;

    @Column(name = "Cpf")
    private String cpf;

    @Column(name = "Telefone1")
    private String telefone1;

    @Column(name = "Telefone2")
    private String telefone2;

    @Column(name = "Observacoes")
    private String observacoes;

    @Column(name = "Apartamento")
    private Long idApartamento;

    public Funcionario(FuncionarioForm form) {
        this.funcionario = form.getFuncionario();
        this.rg = form.getRg();
        this.cpf = form.getCpf();
        this.telefone1 = form.getTelefone1();
        this.telefone2 = form.getTelefone2();
        this.observacoes = form.getObservacoes();
        this.idApartamento = form.getIdApartamento();
    }

    public void atualizarRegistro(FuncionarioForm form) {
        this.telefone1 = form.getTelefone1();
        this.telefone2 = form.getTelefone2();
        this.observacoes = form.getObservacoes();
        this.idApartamento = form.getIdApartamento();
    }


}
