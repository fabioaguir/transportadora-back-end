package com.hive.transportadora.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Fabio Aguiar
 */
@Entity
@Table(name="modals")
public class Modal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @JsonIgnore
    @ManyToMany(mappedBy = "modal")
    private List<Transportadora> transportadoras = new ArrayList<>();

    public Modal() {
    }

    public Modal(Long id, String nome) {
        this.id = id;
        this.nome = nome;
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

    public List<Transportadora> getTransportadoras() {
        return transportadoras;
    }

    public void setTransportadoras(List<Transportadora> transportadoras) {
        this.transportadoras = transportadoras;
    }
}
