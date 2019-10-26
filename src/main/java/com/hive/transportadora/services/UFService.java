package com.hive.transportadora.services;

import com.hive.transportadora.models.UF;
import com.hive.transportadora.repositories.UFRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UFService {

    @Autowired
    private UFRepository repository;

    public List<UF> findAll() {
        List<UF> ufs = repository.findAll();
        return ufs;
    }
}
