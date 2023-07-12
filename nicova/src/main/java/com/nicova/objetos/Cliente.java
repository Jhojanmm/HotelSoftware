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

    public Cliente(String id, String nombre, String correo) {
        this.documento = id;
        this.nombre = nombre;
        this.correo = correo;
    }

    // Getters y Setters
    public String getDocumento() {
        return documento;
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

    public String GetCorreo() {
        return correo;
    }

    public void SetCorreo(String correo) {
        this.correo = correo;
    }
}
