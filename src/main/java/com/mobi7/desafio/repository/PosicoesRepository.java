package com.mobi7.desafio.repository;

import com.mobi7.desafio.entity.Posicoes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PosicoesRepository extends JpaRepository<Posicoes, UUID> {
    List<Posicoes> findAll();
}
