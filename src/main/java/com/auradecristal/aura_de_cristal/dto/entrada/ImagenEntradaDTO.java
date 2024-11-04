package com.auradecristal.aura_de_cristal.dto.entrada;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ImagenEntradaDTO {

    @NotBlank(message = "Debe especificarse la url del producto")
    private String url;

    @NotBlank(message = "Debe especificar el id del producto")
    private Long id_producto;

    public ImagenEntradaDTO() {
    }

    public ImagenEntradaDTO(String url, Long id_producto) {
        this.url = url;
        this.id_producto = id_producto;
    }

    public @NotBlank(message = "Debe especificarse la url del producto") String getUrl() {
        return url;
    }

    public void setUrl(@NotBlank(message = "Debe especificarse la url del producto") String url) {
        this.url = url;
    }

    public @NotBlank(message = "Debe especificar el id del producto") Long getId_producto() {
        return id_producto;
    }

    public void setId_producto(@NotBlank(message = "Debe especificar el id del producto") Long id_producto) {
        this.id_producto = id_producto;
    }
}
