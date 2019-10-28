package com.hive.transportadora.services;

import com.hive.transportadora.dto.UFForFilterDTO;
import com.hive.transportadora.models.UF;
import com.hive.transportadora.queriesCustomized.UFQueryCustom;
import com.hive.transportadora.repositories.UFRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UFService {

    @Autowired
    private UFRepository repository;

    @Autowired
    private UFQueryCustom queryCustom;

    public List<UF> findAll() {
        return this.repository.findAll();
    }

    public List<UFForFilterDTO> searchForParamsFilter() {
        return this.queryCustom.searchForParamsFilter();
    }
}
