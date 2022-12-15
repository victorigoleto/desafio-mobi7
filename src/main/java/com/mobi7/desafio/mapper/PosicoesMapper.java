package com.mobi7.desafio.mapper;

import com.mobi7.desafio.dto.PosicoesDTO;
import com.mobi7.desafio.entity.Posicoes;
import org.springframework.stereotype.Component;

@Component
public class PosicoesMapper {

    public Posicoes toEntity(PosicoesDTO posicoesDTO) {
        return new Posicoes(
                posicoesDTO.getPlaca(),
                posicoesDTO.getData(),
                posicoesDTO.getVelocidade(),
                posicoesDTO.getLatitude(),
                posicoesDTO.getLongitude(),
                posicoesDTO.getIgnicao()
        );
    }

    public PosicoesDTO toDto(Posicoes posicoes) {
        return new PosicoesDTO(
                posicoes.getPlaca(),
                posicoes.getData(),
                posicoes.getVelocidade(),
                posicoes.getLatitude(),
                posicoes.getLongitude(),
                posicoes.getIgnicao()
        );
    }
}
