package com.mobi7.desafio.controller;

import com.mobi7.desafio.dto.POIDTO;
import com.mobi7.desafio.service.POIService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/poi")
public class POIController {

    private final POIService poiService;

    public POIController(POIService poiService) {
        this.poiService = poiService;
    }

    @PostMapping(path = "/create")
    public ResponseEntity<?> create(@RequestBody @Valid POIDTO poidto) {
        poiService.addPOI(poidto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<POIDTO>> getAll(@Valid POIDTO poidto) {
        List<POIDTO> poi = poiService.getPOI(poidto);
        return new ResponseEntity<>(poi, HttpStatus.OK);
    }
}
