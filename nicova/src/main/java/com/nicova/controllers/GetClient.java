/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nicova.controllers;

import com.nicova.objetos.Habitacion;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetClient {

    public static void GetClient(String[] args) {
        String csvFile = "C:\\Nicova\\habitaciones.csv"; // Ruta del archivo CSV
        List<Habitacion> productos = leerHabitaciones(csvFile);

        // Imprimir los objetos Producto creados
        for (Habitacion producto : productos) {
            System.out.println(producto);
        }
    }

    public static List<Habitacion> leerHabitaciones(String csvFile) {
        List<Habitacion> productos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                
                if (i != 0) {
                    String[] datos = line.split(","); // Separar los datos por coma (CSV)

                    // Obtener los valores de las variables
                    int id = Integer.parseInt(datos[0]);
                    double precio = Double.parseDouble(datos[1]);
                    boolean disponibilidad = true;
                    if (datos[2].equals("0")) {
                        disponibilidad = true;
                    } else {
                        disponibilidad = false;
                    }

                    // Crear objeto Producto y agregarlo a la lista
                    Habitacion producto = new Habitacion(id, precio, disponibilidad);
                    productos.add(producto);
                } else {
                    i++;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return productos;
    }
}
