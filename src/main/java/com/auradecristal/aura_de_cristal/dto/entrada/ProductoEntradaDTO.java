package com.auradecristal.aura_de_cristal.dto.entrada;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import java.util.List;

public class ProductoEntradaDTO {

    @NotBlank(message = "Debe especificarse el nombre del producto")
    @Size(max = 100, message = "El nombre debe tener hasta 50 caracteres")
    private String nombre;

    @NotBlank(message = "Debe realizar una descripción del producto")
    @Size(max = 300, message = "La descripcion debe tener hasta 300 caracteres")
    private String descripcion;

    @Positive(message = "El precio de alquiler debe ser un valor positivo")
    private double precio_alquiler;

    @PositiveOrZero(message = "La disponibilidad debe ser cero o positiva")
    private int disponibilidad;

    @PositiveOrZero(message = "El inventario debe ser cero o positivo")
    private int inventario;

    @NotNull(message = "Debe especificarse la categoria a la que pertenece el producto")
    private Long categoria_id;

    @NotNull(message = "Debe especificarse la tematica a la que pertenece el producto")
    private Long tematica_id;

    @NotNull(message = "Debe ingresar al menos una imagen para el producto")
    private List<String> imagenes;

    public ProductoEntradaDTO(String nombre, String descripcion, double precio_alquiler, int disponibilidad, int inventario, Long categoria_id, Long tematica_id, List<String> imagenes) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio_alquiler = precio_alquiler;
        this.disponibilidad = disponibilidad;
        this.inventario = inventario;
        this.categoria_id = categoria_id;
        this.tematica_id = tematica_id;
        this.imagenes = imagenes;
    }

    public ProductoEntradaDTO () {}

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

    public int getInventario() {
        return inventario;
    }

    public void setInventario(int inventario) {
        this.inventario = inventario;
    }

    public Long getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(Long categoria_id) {
        this.categoria_id = categoria_id;
    }

    public Long getTematica_id() {
        return tematica_id;
    }

    public void setTematica_id(Long tematica_id) {
        this.tematica_id = tematica_id;
    }

    public @NotNull(message = "Debe ingresar al menos una imagen para el producto") List<String> getImagenes() {
        return imagenes;
    }

    public void setImagenes(@NotNull(message = "Debe ingresar al menos una imagen para el producto") List<String> imagenes) {
        this.imagenes = imagenes;
    }
}