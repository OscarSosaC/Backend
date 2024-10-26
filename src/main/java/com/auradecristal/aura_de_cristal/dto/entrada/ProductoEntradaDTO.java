package com.auradecristal.aura_de_cristal.dto.entrada;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ProductoEntradaDTO {

    @NotBlank(message = "Debe especificarse el nombre del producto")
    @Size(max = 50, message = "El nombre debe tener hasta 50 caracteres")
    private String nombre;
    @NotBlank(message = "Debe realizar una descripción del producto")
    @Size(max = 100, message = "La descripcion debe tener hasta 100 caracteres")
    private String descripcion;
    @NotBlank(message = "Debe especificarse el precio de alquiler del producto")
    private double precio_alquiler;
    @NotBlank(message = "Debe especificarse si el producto se encuentra disponible para alquiler")
    private int disponibilidad;
    @NotBlank(message = "Debe especificarse la cantidad de inventario existente del producto")
    private int inventario;
    @NotBlank(message = "Debe especificarse la categoria a la que pertenece el producto")
    private CategoriaEntradaDTO categoria;

    public ProductoEntradaDTO(String nombre, String descripcion, double precio_alquiler, int disponibilidad, int inventario, CategoriaEntradaDTO categoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio_alquiler = precio_alquiler;
        this.disponibilidad = disponibilidad;
        this.inventario = inventario;
        this.categoria = categoria;
    }

    public @NotBlank(message = "Debe especificarse el nombre del producto") @Size(max = 50, message = "El nombre debe tener hasta 50 caracteres") String getNombre() {
        return nombre;
    }

    public void setNombre(@NotBlank(message = "Debe especificarse el nombre del producto") @Size(max = 50, message = "El nombre debe tener hasta 50 caracteres") String nombre) {
        this.nombre = nombre;
    }

    public @NotBlank(message = "Debe realizar una descripción del producto") @Size(max = 100, message = "La descripcion debe tener hasta 100 caracteres") String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(@NotBlank(message = "Debe realizar una descripción del producto") @Size(max = 100, message = "La descripcion debe tener hasta 100 caracteres") String descripcion) {
        this.descripcion = descripcion;
    }

    @NotBlank(message = "Debe especificarse el precio de alquiler del producto")
    public double getPrecio_alquiler() {
        return precio_alquiler;
    }

    public void setPrecio_alquiler(@NotBlank(message = "Debe especificarse el precio de alquiler del producto") double precio_alquiler) {
        this.precio_alquiler = precio_alquiler;
    }

    @NotBlank(message = "Debe especificarse si el producto se encuentra disponible para alquiler")
    public int getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(@NotBlank(message = "Debe especificarse si el producto se encuentra disponible para alquiler") int disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    @NotBlank(message = "Debe especificarse la cantidad de inventario existente del producto")
    public int getInventario() {
        return inventario;
    }

    public void setInventario(@NotBlank(message = "Debe especificarse la cantidad de inventario existente del producto") int inventario) {
        this.inventario = inventario;
    }

    public @NotBlank(message = "Debe especificarse la categoria a la que pertenece el producto") CategoriaEntradaDTO getCategoria() {
        return categoria;
    }

    public void setCategoria(@NotBlank(message = "Debe especificarse la categoria a la que pertenece el producto") CategoriaEntradaDTO categoria) {
        this.categoria = categoria;
    }
}
