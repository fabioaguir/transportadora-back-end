package com.hive.transportadora.controllers;

import com.hive.transportadora.dto.UFForFilterDTO;
import com.hive.transportadora.models.UF;
import com.hive.transportadora.services.UFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/uf")
public class UFController {

    @Autowired
    private UFService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> findAll() {
        List<UF> ufs = this.service.findAll();
        return new ResponseEntity<>(ufs, HttpStatus.OK);
    }

    @RequestMapping(value = "/searchForParamsFilter", method = RequestMethod.GET)
    public ResponseEntity<List<UFForFilterDTO>> searchForParamsFilter() {
        List<UFForFilterDTO> ufs = this.service.searchForParamsFilter();
        return new ResponseEntity<>(ufs, HttpStatus.OK);
    }
}
