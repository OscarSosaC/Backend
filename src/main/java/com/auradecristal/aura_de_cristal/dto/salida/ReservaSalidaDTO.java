package com.auradecristal.aura_de_cristal.dto.salida;

import java.time.LocalDate;

public class ReservaSalidaDTO {

    private Long id;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private int cantidad;
    private Long productoId;
    private Long usuarioId;

    public ReservaSalidaDTO() {
    }

    // Constructor
    public ReservaSalidaDTO(Long id, LocalDate fechaInicio, LocalDate fechaFin, int cantidad, Long productoId, Long usuarioId) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.cantidad = cantidad;
        this.productoId = productoId;
        this.usuarioId = usuarioId;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}