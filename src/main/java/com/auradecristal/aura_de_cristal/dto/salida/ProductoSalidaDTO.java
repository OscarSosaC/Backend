package com.auradecristal.aura_de_cristal.dto.salida;

import com.auradecristal.aura_de_cristal.entity.Categoria;
import com.auradecristal.aura_de_cristal.entity.Tematica;

import java.time.LocalDateTime;

public class ProductoSalidaDTO {

    private Long id;
    private String nombre;
    private String descripcion;
    private double precio_alquiler;
    private int disponibilidad;
    private LocalDateTime fecha_registro;
    private int inventario;
    private CategoriaSalidaDTO categoria;
    private TematicaSalidaDTO tematica;

    public ProductoSalidaDTO(Long id, String nombre, String descripcion, double precio_alquiler, int disponibilidad, LocalDateTime fecha_registro, int inventario, Categoria categoria, Tematica tematica) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio_alquiler = precio_alquiler;
        this.disponibilidad = disponibilidad;
        this.fecha_registro = fecha_registro;
        this.inventario = inventario;
        this.categoria = new CategoriaSalidaDTO(categoria.getId_categoria(), categoria.getDescripcion());
        this.tematica = new TematicaSalidaDTO(tematica.getId_tematica(), tematica.getDescripcion());
    }

    public ProductoSalidaDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio_alquiler() {
        return precio_alquiler;
    }

    public void setPrecio_alquiler(double precio_alquiler) {
        this.precio_alquiler = precio_alquiler;
    }

    public int getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(int disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public LocalDateTime getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(LocalDateTime fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public int getInventario() {
        return inventario;
    }

    public void setInventario(int inventario) {
        this.inventario = inventario;
    }

    public CategoriaSalidaDTO getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaSalidaDTO categoria) {
        this.categoria = categoria;
    }

    public TematicaSalidaDTO getTematica() {
        return tematica;
    }

    public void setTematica(TematicaSalidaDTO tematica) {
        this.tematica = tematica;
    }
}
