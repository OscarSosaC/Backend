package com.auradecristal.aura_de_cristal.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "imagen")
public class Imagen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_imagen;
    @Column(length = 150)
    private String url;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    private Producto producto;

    public Imagen() {
    }

    public Imagen(Long id_imagen, String url, Producto producto) {
        this.id_imagen = id_imagen;
        this.url = url;
        this.producto = producto;
    }

    public Long getId_imagen() {
        return id_imagen;
    }

    public void setId_imagen(Long id_imagen) {
        this.id_imagen = id_imagen;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
