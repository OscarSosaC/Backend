package com.auradecristal.aura_de_cristal.dto.salida;

import java.util.List;

public class CaracteristicaSalidaDTO {

    private Long idCaracteristica;
    private String descripcion;
    private List<Long> productoIds;

    public CaracteristicaSalidaDTO(Long idCaracteristica, String descripcion, List<Long> productoIds) {
        this.idCaracteristica = idCaracteristica;
        this.descripcion = descripcion;
        this.productoIds = productoIds;
    }

    public CaracteristicaSalidaDTO() {}

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

    public List<Long> getProductoIds() {
        return productoIds;
    }

    public void setProductoIds(List<Long> productoIds) {
        this.productoIds = productoIds;
    }
}
