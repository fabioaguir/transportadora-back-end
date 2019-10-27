package com.hive.transportadora.controllers;

import com.hive.transportadora.dto.TransportadoraDTO;
import com.hive.transportadora.models.Transportadora;
import com.hive.transportadora.services.TransportadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/transportadora")
public class TransportadoraController {

    @Autowired
    private TransportadoraService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> findAll() {
        List<Transportadora> transportadoras = this.service.findAll();
        return new ResponseEntity<>(transportadoras, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> save(@RequestBody TransportadoraDTO transportadoraDTO) {
        Transportadora transportadora = service.save(transportadoraDTO);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(transportadora.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
