package com.hive.transportadora.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/transportadora")
public class TransportadoraController {

    @RequestMapping(method = RequestMethod.GET)
    String home() {
        return "Hello World";
    }
}
