package com.mobi7.desafio.service;

import com.mobi7.desafio.dto.POIDTO;
import com.mobi7.desafio.entity.POI;
import com.mobi7.desafio.mapper.POIMapper;
import com.mobi7.desafio.repository.POIRepository;
import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Service
public class POIService {

    private final POIRepository poiRepository;
    private final POIMapper poiMapper;

    public POIService(POIRepository poiRepository, POIMapper poiMapper) {
        this.poiRepository = poiRepository;
        this.poiMapper = poiMapper;
    }

    @Transactional
    public void addPOI(POIDTO poidto) {
        log.info("Adicionando POI");
        poiRepository.save(poiMapper.toEntity(poidto));
    }

    @Transactional
    public List<POIDTO> getPOI(POIDTO poidto) {
        log.info("Retornando as POI");
        List<POI> poi = poiRepository.findAll();
        return mapToDto(poi);
    }


    private List<POIDTO> mapToDto(List<POI> poi) {
        return poi.stream().map(poiMapper::toDto).collect(Collectors.toList());
    }


}
