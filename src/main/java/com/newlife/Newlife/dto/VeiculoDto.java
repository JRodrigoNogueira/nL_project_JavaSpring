package com.newlife.Newlife.dto;

import com.newlife.Newlife.entity.Veiculo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VeiculoDto {

    private Long id;
    private String placa;
    private String marca;
    private String modelo;
    private String cor;
    private Long idApartamento;

    public VeiculoDto(Veiculo veiculo) {
        this.id = veiculo.getId();
        this.placa = veiculo.getPlaca();
        this.marca = veiculo.getMarca();
        this.modelo = veiculo.getModelo();
        this.cor = veiculo.getCor();
        this.idApartamento = veiculo.getIdApartamento();
    }

}
