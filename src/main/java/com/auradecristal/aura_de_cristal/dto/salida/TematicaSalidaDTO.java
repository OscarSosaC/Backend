package com.auradecristal.aura_de_cristal.dto.salida;

public class TematicaSalidaDTO {

    private Long id;
    private String descripcion;

    public TematicaSalidaDTO(Long id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public TematicaSalidaDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
