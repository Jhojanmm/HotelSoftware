/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nicova.objetos;

/**
 *
 * @author jhoja
 */
public class Cliente {
    private String documento;
    private String nombre;
    private String correo;
    private String telefono;
    private String ocupacion;
    private String direccion;

    public Cliente(String id, String nombre, String correo, String ocupacion, String telefono, String direccion) {
        this.documento = id;
        this.nombre = nombre;
        this.correo = correo;
        this.ocupacion = ocupacion;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    // Getters y Setters
    public String getDocumento() {
        return documento;
    }
    
    public String getOcupacion() {
        return ocupacion;
    }
    
    public String getTelefono() {
        return telefono;
    }
    
    public String getdireccion() {
        return direccion;
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
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String GetCorreo() {
        return correo;
    }

    public void SetCorreo(String correo) {
        this.correo = correo;
    }
}
