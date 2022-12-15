package com.mobi7.desafio.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "posicoes")
public class Posicoes {

    @Id
    private UUID id;

    @Column(nullable = false)
    private String placa;

    @Column(nullable = false)
    private Date data;

    @Column(nullable = false)
    private Integer velocidade;

    @Column(nullable = false)
    private Double latitude;

    @Column(nullable = false)
    private Double longitude;

    @Column(nullable = false)
    private Boolean ignicao;

    @PrePersist
    public void prePersist() {
        this.id = UUID.randomUUID();
    }

    public Posicoes(String placa, Date data, Integer velocidade, Double latitude, Double longitude, Boolean ignicao) {
        this.placa = placa;
        this.data = data;
        this.velocidade = velocidade;
        this.latitude = latitude;
        this.longitude = longitude;
        this.ignicao = ignicao;
    }
}
