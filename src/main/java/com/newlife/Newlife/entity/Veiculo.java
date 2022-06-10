package com.newlife.Newlife.entity;


import com.newlife.Newlife.dto.VeiculoForm;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Veiculos")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Placa")
    private String placa;

    @Column(name = "Marca")
    private String marca;

    @Column(name = "Modelo")
    private String modelo;

    @Column(name = "Cor")
    private String cor;

    @Column(name = "Apartamento")
    private Long idApartamento;

    public Veiculo(VeiculoForm form) {
        this.placa = form.getPlaca();
        this.marca = form.getMarca();
        this.modelo = form.getModelo();
        this.cor = form.getCor();
        this.idApartamento = form.getIdApartamento();
    }

    public void atualizarRegistro(VeiculoForm form) {
        this.marca = form.getMarca();
        this.modelo = form.getModelo();
        this.cor = form.getCor();
        this.idApartamento = form.getIdApartamento();
    }


}
