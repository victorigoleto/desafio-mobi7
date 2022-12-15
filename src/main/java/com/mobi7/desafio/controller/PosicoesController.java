package com.mobi7.desafio.controller;

import com.mobi7.desafio.dto.PosicoesDTO;
import com.mobi7.desafio.service.PosicoesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/positions")
public class PosicoesController {

    private final PosicoesService posicoesService;

    public PosicoesController(PosicoesService posicoesService) {
        this.posicoesService = posicoesService;
    }

    @PostMapping(path = "/create")
    public ResponseEntity<?> create(@RequestBody @Valid PosicoesDTO posicoesDTO) {
        posicoesService.addPosicoes(posicoesDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<PosicoesDTO>> getAll(@Valid PosicoesDTO posicoesDTO) {
        List<PosicoesDTO> posicoes = posicoesService.getPosicoes(posicoesDTO);
        return new ResponseEntity<>(posicoes, HttpStatus.OK);
    }
}
