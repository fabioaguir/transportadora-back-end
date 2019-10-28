package com.hive.transportadora.services;

import com.hive.transportadora.dto.ModalForFilterDTO;
import com.hive.transportadora.models.Modal;
import com.hive.transportadora.queriesCustomized.ModalQueryCustom;
import com.hive.transportadora.repositories.ModalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author Fabio Aguiar
 */
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

    /**
     * Método criado para instância dos modals no banco de dados
     */
    public void instanciarModals() {
        Modal modal1 = new Modal(null, "Rodoviário");
        Modal modal2 = new Modal(null, "Aéreo");
        Modal modal3 = new Modal(null, "Aquaviário");

        this.repository.saveAll(Arrays.asList(modal1, modal2, modal3));
    }
}
