package com.hive.transportadora.services;

import com.hive.transportadora.exceptions.ObjectNotFoundException;
import com.hive.transportadora.models.Modal;
import com.hive.transportadora.models.Transportadora;
import com.hive.transportadora.queriesCustomized.TransportadoraQueryCustom;
import com.hive.transportadora.repositories.ModalRepository;
import com.hive.transportadora.repositories.TransportadoraRepository;
import com.hive.transportadora.utils.Cryptography;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author Fabio Aguiar
 */
@Service
public class TransportadoraService {

    @Autowired
    private TransportadoraRepository repository;

    @Autowired
    private ModalRepository modalRepository;

    @Autowired
    private TransportadoraQueryCustom queryCustom;

    public List<Transportadora> findAll() {
        return this.repository.findAll();
    }

    public Transportadora findById(Long id) {
        Optional<Transportadora> transportadora = this.repository.findById(id);
        return transportadora.orElse(null);
    }

    @Transactional
    public Transportadora save(Transportadora transportadora) {
        transportadora.setId(null);
        transportadora.setLogo(Cryptography.encoderBase64(transportadora.getLogo()));
        return this.repository.save(transportadora);
    }

    @Transactional
    public Transportadora update(Transportadora transportadora) {
        transportadora.setLogo(Cryptography.encoderBase64(transportadora.getLogo()));
        return this.repository.save(transportadora);
    }

    @Transactional
    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    public List<Transportadora> search (String nome, List<Long> ufs, String cidade, List<Long> modals) {
        List<Modal> listModal = modals != null ? this.modalRepository.findAllById(modals) : null;
        return this.queryCustom.searchForFilter(nome, ufs, cidade, listModal);
    }

    public void verificarTransportdoraExistente(Long id) {
        if(this.findById(id) == null)
            throw new ObjectNotFoundException("Transportadora não encontrada com código: " + id);
    }

}
