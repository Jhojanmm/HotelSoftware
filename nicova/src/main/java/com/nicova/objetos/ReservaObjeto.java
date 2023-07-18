/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nicova.objetos;

public class ReservaObjeto {
    private String idHabitacion;
    private String idCliente;
    private String idCreador;
    private String fechaEntrada;
    private String fechaSalida;
    private String estadoReserva;
    private String cantidadPersonas;
    private String horaLlegada;
    private String retencionFuente;
    private String cantidadAnticipo;
    private String porcentajeRetencion;
    private String total;

    // Constructor
    public ReservaObjeto(String idHabitacion, String idCliente, String idCreador, String fechaEntrada,
                   String fechaSalida, String estadoReserva, String cantidadPersonas,
                   String horaLlegada, String retencionFuente, String cantidadAnticipo,
                   String porcentajeRetencion, String total) {
        this.idHabitacion = idHabitacion;
        this.idCliente = idCliente;
        this.idCreador = idCreador;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.estadoReserva = estadoReserva;
        this.cantidadPersonas = cantidadPersonas;
        this.horaLlegada = horaLlegada;
        this.retencionFuente = retencionFuente;
        this.cantidadAnticipo = cantidadAnticipo;
        this.porcentajeRetencion = porcentajeRetencion;
        this.total = total;
    }

    // Getters y Setters (opcional, puedes generarlos automáticamente en tu IDE)

    public String getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(String idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getIdCreador() {
        return idCreador;
    }

    public void setIdCreador(String idCreador) {
        this.idCreador = idCreador;
    }

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(String estadoReserva) {
        this.estadoReserva = estadoReserva;
    }

    public String getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(String cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    public String getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(String horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public String getRetencionFuente() {
        return retencionFuente;
    }

    public void setRetencionFuente(String retencionFuente) {
        this.retencionFuente = retencionFuente;
    }

    public String getCantidadAnticipo() {
        return cantidadAnticipo;
    }

    public void setCantidadAnticipo(String cantidadAnticipo) {
        this.cantidadAnticipo = cantidadAnticipo;
    }

    public String getPorcentajeRetencion() {
        return porcentajeRetencion;
    }

    public void setPorcentajeRetencion(String porcentajeRetencion) {
        this.porcentajeRetencion = porcentajeRetencion;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
