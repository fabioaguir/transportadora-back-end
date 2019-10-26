package com.hive.transportadora.controllers;

import com.hive.transportadora.models.Transportadora;
import com.hive.transportadora.services.TransportadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/transportadora")
public class TransportadoraController {

    @Autowired
    private TransportadoraService service;

    @RequestMapping(method = RequestMethod.GET)
    public List<Transportadora> findAll() {
        List<Transportadora> transportadoras = this.service.findAll();
        return transportadoras;
    }
}
