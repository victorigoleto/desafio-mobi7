package com.mobi7.desafio.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "poi")
public class POI {

    @Id
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Integer raio;

    @Column(nullable = false)
    private Double latitude;

    @Column(nullable = false)
    private Double longitude;


    @PrePersist
    public void prePersist() {
        this.id = UUID.randomUUID();
    }

    public POI(String nome, Integer raio, Double latitude, Double longitude) {
        this.nome = nome;
        this.raio = raio;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
