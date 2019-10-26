package com.hive.transportadora.services;

import com.hive.transportadora.models.Transportadora;
import com.hive.transportadora.repositories.TransportadoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransportadoraService {

    @Autowired
    private TransportadoraRepository repository;

    public List<Transportadora> findAll() {
        List<Transportadora> transportadoras = repository.findAll();
        return transportadoras;
    }

    public Transportadora save(Transportadora transportadora) {
        transportadora.setId(null);
        return this.repository.save(transportadora);
    }
}
