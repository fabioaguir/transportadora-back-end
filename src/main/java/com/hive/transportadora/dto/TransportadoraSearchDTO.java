package com.hive.transportadora.dto;

import com.hive.transportadora.models.Transportadora;
import com.hive.transportadora.utils.Cryptography;

/**
 * @author Fabio Aguiar
 */
public class TransportadoraSearchDTO {

    private Long id;
    private String email;
    private String nome;
    private String cnpj;
    private String telefone;
    private String celular;
    private String whatsapp;
    private String logo;

    public TransportadoraSearchDTO() {
    }

    public TransportadoraSearchDTO(Transportadora transportadora) {
        this.id = transportadora.getId();
        this.email = transportadora.getEmail();
        this.nome = transportadora.getNome();
        this.cnpj = transportadora.getCnpj();
        this.telefone = transportadora.getTelefone();
        this.celular = transportadora.getCelular();
        this.whatsapp = transportadora.getWhatsapp();
        this.logo = Cryptography.decoderBase64(transportadora.getLogo());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
