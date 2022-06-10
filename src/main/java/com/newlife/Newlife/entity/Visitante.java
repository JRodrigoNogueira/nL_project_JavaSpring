package com.newlife.Newlife.entity;

import com.newlife.Newlife.dto.VisitanteForm;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Visitantes")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Visitante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Visitante")
    private String visitante;

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

    public Visitante(VisitanteForm form) {
        this.visitante = form.getVisitante();
        this.rg = form.getRg();
        this.cpf = form.getCpf();
        this.telefone1 = form.getTelefone1();
        this.telefone2 = form.getTelefone2();
        this.observacoes = form.getObservacoes();
        this.idApartamento = form.getIdApartamento();
    }

    public void atualizarRegistro(VisitanteForm form) {
        this.telefone1 = form.getTelefone1();
        this.telefone2 = form.getTelefone2();
        this.observacoes = form.getObservacoes();
        this.idApartamento = form.getIdApartamento();
    }

}
