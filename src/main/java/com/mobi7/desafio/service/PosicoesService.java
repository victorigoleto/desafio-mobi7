package com.mobi7.desafio.service;

import com.mobi7.desafio.dto.PosicoesDTO;
import com.mobi7.desafio.entity.Posicoes;
import com.mobi7.desafio.mapper.PosicoesMapper;
import com.mobi7.desafio.repository.PosicoesRepository;
import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Service
public class PosicoesService {

    private final PosicoesRepository posicoesRepository;
    private final PosicoesMapper posicoesMapper;

    public PosicoesService(PosicoesRepository posicoesRepository, PosicoesMapper posicoesMapper) {
        this.posicoesRepository = posicoesRepository;
        this.posicoesMapper = posicoesMapper;
    }

    @Transactional
    public void addPosicoes(PosicoesDTO posicoesDTO) {
        log.info("Adicionando posicoes");
        posicoesRepository.save(posicoesMapper.toEntity(posicoesDTO));
    }

    @Transactional
    public List<PosicoesDTO> getPosicoes(PosicoesDTO posicoesDTO) {
        log.info("Retornando as posicoes");
        List<Posicoes> posicoes = posicoesRepository.findAll();
        return mapToDto(posicoes);
    }


    private List<PosicoesDTO> mapToDto(List<Posicoes> posicoes) {
        return posicoes.stream().map(posicoesMapper::toDto).collect(Collectors.toList());
    }
}
