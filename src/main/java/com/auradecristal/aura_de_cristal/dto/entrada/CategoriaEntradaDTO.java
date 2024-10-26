package com.auradecristal.aura_de_cristal.dto.entrada;
import jakarta.validation.constraints.NotBlank;

public class CategoriaEntradaDTO {

    @NotBlank(message = "Debe escribir una descripcion de la categoria")
    private String descripcion;

    public CategoriaEntradaDTO(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
