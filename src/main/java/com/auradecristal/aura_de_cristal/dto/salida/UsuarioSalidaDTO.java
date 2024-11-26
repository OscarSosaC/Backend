package com.auradecristal.aura_de_cristal.dto.salida;

import java.util.List;

public class UsuarioSalidaDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String rol;
    private List<ReservaSalidaDTO> reservas;

    public UsuarioSalidaDTO(Long id, String nombre, String apellido, String email, String rol, List<ReservaSalidaDTO> reservas) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.rol = rol;
        this.reservas = reservas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UsuarioSalidaDTO() {}

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public List<ReservaSalidaDTO> getReservas() {
        return reservas;
    }

    public void setReservas(List<ReservaSalidaDTO> reservas) {
        this.reservas = reservas;
    }

    @Override
    public String toString() {
        return "UsuarioSalidaDTO {"+this.nombre + " - " +this.apellido + " - " +this.email +"}";
    }
}
