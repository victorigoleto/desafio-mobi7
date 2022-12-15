package com.mobi7.desafio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class POIDTO {

    private String nome;
    private Integer raio;
    private Double latitude;
    private Double longitude;

}
