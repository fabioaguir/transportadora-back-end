package com.hive.transportadora.models;

import javax.persistence.*;

@Entity
@Table(name = "transportadoras")
public class Transportadora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String nome;
    private String empresa;
    private String cnpj;
    private String telefone;
    private String celular;
    private String whatsapp;
    private String cep;
    private String cidade;
    private String bairro;
    private String logradouro;
    private String numero;
    private Boolean termo;

    @ManyToOne
    @JoinColumn(name = "modal_id")
    private Modal modal;

    @ManyToOne
    @JoinColumn(name = "uf_id")
    private UF uf;

    public Transportadora() {
    }

    public Transportadora(Long id, String email, String nome, String empresa, String cnpj, String telefone, String celular,
                          String whatsapp, String cep, String cidade, String bairro, String logradouro, String numero,
                          Boolean termo, Modal modal, UF uf) {
        this.id = id;
        this.email = email;
        this.nome = nome;
        this.empresa = empresa;
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.celular = celular;
        this.whatsapp = whatsapp;
        this.cep = cep;
        this.cidade = cidade;
        this.bairro = bairro;
        this.logradouro = logradouro;
        this.numero = numero;
        this.termo = termo;
        this.modal = modal;
        this.uf = uf;
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

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Boolean getTermo() {
        return termo;
    }

    public void setTermo(Boolean termo) {
        this.termo = termo;
    }

    public Modal getModal() {
        return modal;
    }

    public void setModal(Modal modal) {
        this.modal = modal;
    }

    public UF getUf() {
        return uf;
    }

    public void setUf(UF uf) {
        this.uf = uf;
    }
}
