package com.auradecristal.aura_de_cristal.dto.entrada;

import jakarta.validation.constraints.NotBlank;

public class CaracteristicaEntradaDTO {

    @NotBlank(message = "Debe especificarse la descripcion de la caracteristica")
    private String descripcion;

    public CaracteristicaEntradaDTO() {}

    public CaracteristicaEntradaDTO(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
