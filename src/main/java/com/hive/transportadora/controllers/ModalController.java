package com.hive.transportadora.controllers;

import com.hive.transportadora.dto.ModalForFilterDTO;
import com.hive.transportadora.models.Modal;
import com.hive.transportadora.services.ModalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Fabio Aguiar
 */
@RestController
@RequestMapping(value = "/modal")
public class ModalController {

    @Autowired
    private ModalService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> findAll() {
        List<Modal> modals = this.service.findAll();
        return new ResponseEntity<>(modals, HttpStatus.OK);
    }

    @RequestMapping(value = "/searchForParamsFilter", method = RequestMethod.GET)
    public ResponseEntity<List<ModalForFilterDTO>> searchForParamsFilter() {
        List<ModalForFilterDTO> modals = this.service.searchForParamsFilter();
        return new ResponseEntity<>(modals, HttpStatus.OK);
    }
}
