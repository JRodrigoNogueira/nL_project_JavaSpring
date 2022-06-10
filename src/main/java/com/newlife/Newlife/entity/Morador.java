package com.newlife.Newlife.entity;


import com.newlife.Newlife.dto.MoradorForm;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Moradores")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Morador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Morador")
    private String morador;

    @Column(name = "Rg")
    private String rg;

    @Column(name = "Cpf")
    private String cpf;

    @Column(name = "Telefone1")
    private String telefone1;

    @Column(name = "Telefone2")
    private String telefone2;

    @Column(name = "Email")
    private String email;

    @Column(name = "ContatoEmergencia")
    private String contatoEmergencia;

    @Column(name = "TelefoneEmergencia")
    private String telefoneEmergencia;

    @Column(name = "Observacoes")
    private String observacoes;

    @Column(name = "Apartamento")
    private Long idApartamento;

    public Morador(MoradorForm form) {
        this.morador = form.getMorador();
        this.rg = form.getRg();
        this.cpf = form.getCpf();
        this.telefone1 = form.getTelefone1();
        this.telefone2 = form.getTelefone2();
        this.email = form.getEmail();
        this.contatoEmergencia = form.getContatoEmergencia();
        this.telefoneEmergencia = form.getTelefoneEmergencia();
        this.observacoes = form.getObservacoes();
        this.idApartamento = form.getIdApartamento();
    }

    public void atualizarRegistro(MoradorForm form) {
        this.telefone1 = form.getTelefone1();
        this.telefone2 = form.getTelefone2();
        this.email = form.getEmail();
        this.contatoEmergencia = form.getContatoEmergencia();
        this.telefoneEmergencia = form.getTelefoneEmergencia();
        this.observacoes = form.getObservacoes();
        this.idApartamento = form.getIdApartamento();
    }


}
