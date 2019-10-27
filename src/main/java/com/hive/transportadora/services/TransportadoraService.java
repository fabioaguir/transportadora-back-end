package com.hive.transportadora.services;

import com.hive.transportadora.dto.TransportadoraDTO;
import com.hive.transportadora.exceptions.ObjectNotFoundException;
import com.hive.transportadora.models.Modal;
import com.hive.transportadora.models.Transportadora;
import com.hive.transportadora.models.UF;
import com.hive.transportadora.repositories.ModalRepository;
import com.hive.transportadora.repositories.TransportadoraRepository;
import com.hive.transportadora.repositories.UFRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TransportadoraService {

    @Autowired
    private TransportadoraRepository repository;

    @Autowired
    private ModalRepository modalRepository;

    @Autowired
    private UFRepository ufRepository;

    public List<Transportadora> findAll() {
        List<Transportadora> transportadoras = repository.findAll();
        return transportadoras;
    }

    public Transportadora findById(Long id) {
        Optional<Transportadora> transportadora = repository.findById(id);
        return transportadora.orElse(null);
    }

    @Transactional
    public Transportadora save(TransportadoraDTO transportadoraDTO) {
        Transportadora transportadora = this.getInstanceTransportadora(transportadoraDTO);
        transportadora.setId(null);
        return this.repository.save(transportadora);
    }

    @Transactional
    public Transportadora update(TransportadoraDTO transportadoraDTO) {
        Transportadora transportadora = this.getInstanceTransportadora(transportadoraDTO);
        return this.repository.save(transportadora);
    }

    @Transactional
    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    public Transportadora getInstanceTransportadora(TransportadoraDTO dto) {
        Optional<Modal> modal = this.modalRepository.findById(dto.getModalId());
        Optional<UF> uf = ufRepository.findById(dto.getUfId());
        Transportadora transportadora = new Transportadora(
                dto.getId(),
                dto.getEmail(),
                dto.getNome(),
                dto.getEmpresa(),
                dto.getCnpj(),
                dto.getTelefone(),
                dto.getCelular(),
                dto.getWhatsapp(),
                dto.getCep(),
                dto.getCidade(),
                dto.getBairro(),
                dto.getLogradouro(),
                dto.getNumero(),
                dto.getTermo(),
                modal.orElse(null),
                uf.orElse(null)
                );

        return transportadora;
    }

    public void verificarTransportdoraExistente(Long id) {
        if(this.findById(id) == null)
            throw new ObjectNotFoundException("Transportadora não encontrada " + id);
    }
}
