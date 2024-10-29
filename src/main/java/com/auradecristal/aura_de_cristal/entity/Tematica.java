package com.auradecristal.aura_de_cristal.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tematica")
public class Tematica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tematica;
    @Column(length = 50)
    private String descripcion;

    public Tematica() { }

    public Tematica(Long id_tematica, String descripcion) {
        this.id_tematica = id_tematica;
        this.descripcion = descripcion;
    }

    public Long getId_tematica() {
        return id_tematica;
    }

    public void setId_tematica(Long id_tematica) {
        this.id_tematica = id_tematica;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
