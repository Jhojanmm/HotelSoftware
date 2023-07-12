/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nicova.controllers;

import com.nicova.objetos.Cliente;
import com.nicova.objetos.Habitacion;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetClientes {


    public static List<Cliente> leerClientes(String csvFile) {
        List<Cliente> clientes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                
                if (i != 0) {
                    String[] datos = line.split(","); // Separar los datos por coma (CSV)

                    // Obtener los valores de las variables
                    String id = datos[1];
                    String nombre = datos[0];
                    String correo = datos[2];
                    

                    // Crear objeto Producto y agregarlo a la lista
                    Cliente custom = new Cliente(id, nombre, correo);
                    clientes.add(custom);
                } else {
                    i++;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return clientes;
    }
}
