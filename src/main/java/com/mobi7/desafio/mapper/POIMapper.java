package com.mobi7.desafio.mapper;

import com.mobi7.desafio.dto.POIDTO;
import com.mobi7.desafio.entity.POI;
import org.springframework.stereotype.Component;

@Component
public class POIMapper {

    public POI toEntity(POIDTO poidto) {
        return new POI(
                poidto.getNome(),
                poidto.getRaio(),
                poidto.getLatitude(),
                poidto.getLongitude()
        );
    }

    public POIDTO toDto(POI poi) {
        return new POIDTO(
                poi.getNome(),
                poi.getRaio(),
                poi.getLatitude(),
                poi.getLongitude()
        );
    }
}
