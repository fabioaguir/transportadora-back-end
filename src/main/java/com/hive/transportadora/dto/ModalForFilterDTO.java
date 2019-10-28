package com.hive.transportadora.dto;

/**
 * @author Fabio Aguiar
 */
public class ModalForFilterDTO {

    private Long id;
    private String nome;
    private Long qtdTransportadoras;

    public ModalForFilterDTO() {

    }

    public ModalForFilterDTO(Long id, String nome, Long qtdTransportadoras) {
        this.id = id;
        this.nome = nome;
        this.qtdTransportadoras = qtdTransportadoras;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getQtdTransportadoras() {
        return qtdTransportadoras;
    }

    public void setQtdTransportadoras(Long qtdTransportadoras) {
        this.qtdTransportadoras = qtdTransportadoras;
    }
}
