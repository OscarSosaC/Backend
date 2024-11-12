package com.auradecristal.aura_de_cristal.entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "caracteristica")
public class Caracteristica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCaracteristica;
    @Column(length = 150)
    private String descripcion;
    @ManyToMany(mappedBy = "caracteristicas")
    private Set<Producto> productos;

    public Caracteristica() {}

    public Caracteristica(Long idCaracteristica, String descripcion, Set<Producto> productos) {
        this.idCaracteristica = idCaracteristica;
        this.descripcion = descripcion;
        this.productos = productos;
    }

    public Long getIdCaracteristica() {
        return idCaracteristica;
    }

    public void setIdCaracteristica(Long idCaracteristica) {
        this.idCaracteristica = idCaracteristica;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<Producto> getProductos() {
        return productos;
    }

    public void setProductos(Set<Producto> productos) {
        this.productos = productos;
    }
}
