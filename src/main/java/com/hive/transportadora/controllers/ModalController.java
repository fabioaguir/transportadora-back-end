package com.hive.transportadora.controllers;

import com.hive.transportadora.models.Modal;
import com.hive.transportadora.repositories.ModalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/modal")
public class ModalController {

    @Autowired
    private ModalRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Modal> findAll() {
        List<Modal> modals = this.repository.findAll();
        return modals;
    }
}
