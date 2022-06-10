package com.newlife.Newlife.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class VeiculoForm {

    private String placa;
    private String marca;
    private String modelo;
    private String cor;
    private Long idApartamento;

}
