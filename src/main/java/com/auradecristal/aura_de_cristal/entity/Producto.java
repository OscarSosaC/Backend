package com.auradecristal.aura_de_cristal.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;
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
    @JoinColumn(name = "categoria_id", referencedColumnName = "idCategoria")
    private Categoria categoria;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tematica_id", referencedColumnName = "idTematica")
    private Tematica tematica;
    @ManyToMany
    @JoinTable(
            name = "producto_caracteristica",
            joinColumns = @JoinColumn(name = "producto_id"),
            inverseJoinColumns = @JoinColumn(name = "caracteristica_id")
    )
    private Set<Caracteristica> caracteristicas;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "producto_id", referencedColumnName = "idProducto")
    private List<Imagen> imagenes = new ArrayList<>();

    @PrePersist
    protected void onCreate() {
        this.fecha_registro = LocalDateTime.now(); // Asigna la fecha y hora actual
    }

    public Producto() {}

    public Producto(Long idProducto, String nombre, String descripcion, double precio_alquiler, int disponibilidad, LocalDateTime fecha_registro, int inventario, Categoria categoria, Tematica tematica, Set<Caracteristica> caracteristicas, List<Imagen> imagenes) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio_alquiler = precio_alquiler;
        this.disponibilidad = disponibilidad;
        this.fecha_registro = fecha_registro;
        this.inventario = inventario;
        this.categoria = categoria;
        this.tematica = tematica;
        this.caracteristicas = caracteristicas;
        this.imagenes = imagenes;
    }

    public Long getidProducto() {
        return idProducto;
    }

    public void setidProducto(Long idProducto) {
        this.idProducto = idProducto;
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

    public Set<Caracteristica> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(Set<Caracteristica> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public List<Imagen> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<Imagen> imagenes) {
        this.imagenes = imagenes;
    }
}
