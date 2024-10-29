package com.auradecristal.aura_de_cristal.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_producto;
    @Column(length = 50)
    private String nombre;
    @Column(length = 100)
    private String descripcion;
    private double precio_alquiler;
    private int disponibilidad;
    @Column(length = 50)
    private LocalDateTime fecha_registro;
    private int inventario;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "categoria_id", referencedColumnName = "id_categoria")
    private Categoria categoria;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tematica_id", referencedColumnName = "id_tematica")
    private Tematica tematica;

    @PrePersist
    protected void onCreate() {
        this.fecha_registro = LocalDateTime.now(); // Asigna la fecha y hora actual
    }

    public Producto() {}

    public Producto(Long id_producto, String nombre, String descripcion, double precio_alquiler, int disponibilidad, LocalDateTime fecha_registro, int inventario, Categoria categoria, Tematica tematica) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio_alquiler = precio_alquiler;
        this.disponibilidad = disponibilidad;
        this.fecha_registro = fecha_registro;
        this.inventario = inventario;
        this.categoria = categoria;
        this.tematica = tematica;
    }

    public Long getId_producto() {
        return id_producto;
    }

    public void setId_producto(Long id_producto) {
        this.id_producto = id_producto;
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Tematica getTematica() {
        return tematica;
    }

    public void setTematica(Tematica tematica) {
        this.tematica = tematica;
    }
}
