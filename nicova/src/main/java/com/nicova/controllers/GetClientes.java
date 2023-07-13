/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nicova.controllers;

import com.nicova.objetos.Cliente;
import com.nicova.objetos.Habitacion;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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
                    String ocupacion = datos[4];
                    String telefono = datos[3];
                    String direccion = datos[5];
                    

                    // Crear objeto Producto y agregarlo a la lista
                    Cliente custom = new Cliente(id, nombre, correo, ocupacion, telefono, direccion);
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
    
    public static void actualizarCliente(String archivoCSV,String nombre, String documento, String correo, String telefono, String ocupacion, String ciudad) {
        String tempFile = "temp.csv";
        String line;
        String[] datos;

        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV));
             BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))) {

            while ((line = br.readLine()) != null) {
                datos = line.split(",");
                if (datos[1].equals(documento)) { // Columna del documento en el CSV (índice 1)
                    // Actualizar los datos del cliente
                    datos[0] = nombre;     
                    datos[1] = documento;
                    datos[2] = correo;     
                    datos[3] = telefono;   
                    datos[4] = ocupacion;  
                    datos[5] = ciudad;     
                }
                bw.write(String.join(",", datos));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Reemplazar el archivo original con el archivo temporal
        try {
            FileWriter fileWriter = new FileWriter(archivoCSV);
            FileReader fileReader = new FileReader(tempFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                bufferedWriter.write(currentLine + System.getProperty("line.separator"));
            }
            bufferedReader.close();
            bufferedWriter.close();
            fileReader.close();
            fileWriter.close();
            // Eliminar el archivo temporal
            new File(tempFile).delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
