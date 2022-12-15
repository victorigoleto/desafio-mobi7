package com.mobi7.desafio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PosicoesDTO {

    private String placa;
    private Date data;
    private Integer velocidade;
    private Double latitude;
    private Double longitude;
    private Boolean ignicao;

}
