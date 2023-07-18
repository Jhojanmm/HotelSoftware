/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nicova.objetos;

import java.util.Date;

public class Reserva {
    private int idHabitacion;
    private int idCliente;
    private int idCreador;
    private Date fechaEntrada;
    private Date fechaSalida;
    private String estadoReserva;
    private int cantidadPersonas;
    private String horaLlegada;
    private double retencionFuente;
    private double cantidadAnticipo;
    private double porcentajeRetencion;
    private double total;

    // Constructor
    public Reserva(int idHabitacion, int idCliente, int idCreador, Date fechaEntrada, Date fechaSalida, String estadoReserva,
                   int cantidadPersonas, String horaLlegada, double retencionFuente,
                   double cantidadAnticipo, double porcentajeRetencion, double total) {
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

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(String estadoReserva) {
        this.estadoReserva = estadoReserva;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    public String getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(String horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public double getRetencionFuente() {
        return retencionFuente;
    }

    public void setRetencionFuente(double retencionFuente) {
        this.retencionFuente = retencionFuente;
    }

    public double getCantidadAnticipo() {
        return cantidadAnticipo;
    }

    public void setCantidadAnticipo(double cantidadAnticipo) {
        this.cantidadAnticipo = cantidadAnticipo;
    }

    public double getPorcentajeRetencion() {
        return porcentajeRetencion;
    }

    public void setPorcentajeRetencion(double porcentajeRetencion) {
        this.porcentajeRetencion = porcentajeRetencion;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
