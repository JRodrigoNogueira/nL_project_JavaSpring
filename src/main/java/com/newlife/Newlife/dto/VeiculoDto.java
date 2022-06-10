package com.newlife.Newlife.dto;

import com.newlife.Newlife.entity.Veiculo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VeiculoDto {

    private String placa;
    private String marca;
    private String modelo;
    private String cor;

    public VeiculoDto(Veiculo veiculo) {
        this.placa = veiculo.getPlaca();
        this.marca = veiculo.getMarca();
        this.modelo = veiculo.getModelo();
        this.cor = veiculo.getCor();
    }

}
