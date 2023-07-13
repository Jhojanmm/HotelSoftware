/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nicova.objetos;

/**
 *
 * @author jhoja
 */
public class Usuario {
    private String documento;
    private String nombre;
    private String correo;
    private String contraseña;
    private String permisos;

    public Usuario(String id, String nombre, String correo, String contraseña, String permisos) {
        this.documento = id;
        this.nombre = nombre;
        this.correo = correo;
        this.permisos = permisos;
        this.contraseña = contraseña;
    }

    // Getters y Setters
    public String getDocumento() {
        return documento;
    }
    
    public String getpermisos() {
        return permisos;
    }
    
    public String getcontraseña() {
        return contraseña;
    }
    
    public void setdocumeto(String id) {
        this.documento = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setcontraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    
    public void setpermisos(String permisos) {
        this.permisos = permisos;
    }

    public String GetCorreo() {
        return correo;
    }

    public void SetCorreo(String correo) {
        this.correo = correo;
    }
}
