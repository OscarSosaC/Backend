package com.auradecristal.aura_de_cristal.dto.salida;

import java.time.LocalDate;

public class ReservaSalidaDTO {

    private Long id;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private int cantidad;
    private ProductoSalidaDTO producto;
    private UsuarioSalidaDTO usuario;

    public ReservaSalidaDTO() {
    }

    // Constructor
    public ReservaSalidaDTO(Long id, LocalDate fechaInicio, LocalDate fechaFin, int cantidad, ProductoSalidaDTO producto, UsuarioSalidaDTO usuario) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.cantidad = cantidad;
        this.producto = producto;
        this.usuario = usuario;
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

    public ProductoSalidaDTO getProducto() {
        return producto;
    }

    public void setProducto(ProductoSalidaDTO producto) {
        this.producto = producto;
    }

    public UsuarioSalidaDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioSalidaDTO usuario) {
        this.usuario = usuario;
    }
}