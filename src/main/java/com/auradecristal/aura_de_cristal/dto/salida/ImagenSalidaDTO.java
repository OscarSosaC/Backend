package com.auradecristal.aura_de_cristal.dto.salida;

import com.auradecristal.aura_de_cristal.entity.Producto;

public class ImagenSalidaDTO {

    private Long id;
    private String url;

    public ImagenSalidaDTO() {
    }

    public ImagenSalidaDTO(Long id, String url) {
        this.id = id;
        this.url = url;
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

}
