package com.auradecristal.aura_de_cristal.dto.salida;

public class UsuarioSalidaDTO {

    private String nombre;
    private String apellido;
    private String email;
    private String rol;

    public UsuarioSalidaDTO(String nombre, String apellido, String email, String rol) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.rol = rol;
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

    @Override
    public String toString() {
        return "UsuarioSalidaDTO {"+this.nombre + " - " +this.apellido + " - " +this.email +"}";
    }
}
