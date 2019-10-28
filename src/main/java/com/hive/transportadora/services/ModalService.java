package com.hive.transportadora.services;

import com.hive.transportadora.dto.ModalForFilterDTO;
import com.hive.transportadora.models.Modal;
import com.hive.transportadora.queriesCustomized.ModalQueryCustom;
import com.hive.transportadora.repositories.ModalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModalService {

    @Autowired
    private ModalRepository repository;

    @Autowired
    private ModalQueryCustom queryCustom;

    public List<Modal> findAll() {
        return this.repository.findAll();
    }

    public List<ModalForFilterDTO> searchForParamsFilter() {
        return this.queryCustom.searchForParamsFilter();
    }
}
