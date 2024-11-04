package com.auradecristal.aura_de_cristal.dto.salida;

import com.auradecristal.aura_de_cristal.entity.Producto;

public class ImagenSalidaDTO {

    private Long id;
    private String url;
    private ProductoSalidaDTO producto;

    public ImagenSalidaDTO() {
    }

    public ImagenSalidaDTO(Long id, String url, ProductoSalidaDTO producto) {
        this.id = id;
        this.url = url;
        this.producto = producto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ProductoSalidaDTO getProducto() {
        return producto;
    }

    public void setProducto(ProductoSalidaDTO producto) {
        this.producto = producto;
    }
}
