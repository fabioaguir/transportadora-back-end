package com.hive.transportadora.controllers;

import com.hive.transportadora.dto.TransportadoraSearchDTO;
import com.hive.transportadora.models.Transportadora;
import com.hive.transportadora.services.TransportadoraService;
import com.hive.transportadora.utils.Cryptography;
import com.hive.transportadora.utils.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Fabio Aguiar
 */
@RestController
@RequestMapping(value = "/transportadora")
public class TransportadoraController {

    @Autowired
    private TransportadoraService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> findAll() {
        List<Transportadora> transportadoras = this.service.findAll();
        return new ResponseEntity<>(transportadoras, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        try {
            this.service.verificarTransportdoraExistente(id);
            Transportadora transportadora = this.service.findById(id);
            transportadora.setLogo(Cryptography.decoderBase64(transportadora.getLogo()));

            return new ResponseEntity<>(transportadora, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody Transportadora transportadora) {
        try {
            Transportadora result = service.save(transportadora);

            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Transportadora transportadora) {
        try {
            this.service.verificarTransportdoraExistente(id);
            Transportadora result = service.update(transportadora);

            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        try {
            this.service.verificarTransportdoraExistente(id);
            this.service.delete(id);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ResponseEntity<List<TransportadoraSearchDTO>> search(
            @RequestParam(value = "nome", defaultValue = "") String nome,
            @RequestParam(value = "ufs", defaultValue = "") String ufs,
            @RequestParam(value = "cidade", defaultValue = "") String cidade,
            @RequestParam(value = "modals", defaultValue = "") String modals
    ) {
        String nomeDecoded = URL.decodeParam(nome);
        String cidadeDecoded = URL.decodeParam(cidade);
        List<Long> idsUf = URL.decodeLongList(ufs);
        List<Long> idsModal = URL.decodeLongList(modals);

        List<Transportadora> list = this.service.search(nomeDecoded, idsUf, cidadeDecoded, idsModal);
        List<TransportadoraSearchDTO> listaTransportadora = list.stream().map(obj -> new TransportadoraSearchDTO(obj)).collect(Collectors.toList());
        return new ResponseEntity<>(listaTransportadora, HttpStatus.OK);
    }

}
