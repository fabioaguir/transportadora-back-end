package com.hive.transportadora.dto;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Fabio Aguiar
 *
 * Class necessária para que possa recuperar todos os atributos a serem
 * persistidos e por meio deles realizar os tratamentos necessários
 * para persistência da transportadora na base de dados
 */
public class TransportadoraDTO {

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
    private Long modalId;
    private Long ufId;
    private String logo;

    public TransportadoraDTO() {
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

    public Long getModalId() {
        return modalId;
    }

    public void setModalId(Long modalId) {
        this.modalId = modalId;
    }

    public Long getUfId() {
        return ufId;
    }

    public void setUfId(Long ufId) {
        this.ufId = ufId;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
