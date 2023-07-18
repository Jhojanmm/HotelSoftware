/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nicova.controllers;

import com.nicova.objetos.Cliente;
import com.nicova.objetos.Habitacion;
import com.nicova.objetos.ReservaObjeto;
import com.nicova.views.Reserva;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetReservas {


    public static List<ReservaObjeto> leerReservas(String csvFile) {
        List<ReservaObjeto> reserva = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                
                if (i != 0) {
                    String[] datos = line.split(","); // Separar los datos por coma (CSV)

                    // Obtener los valores de las variables
                    String idHabitacion = datos[0];
                    String idCliente = datos[1];
                    String idCreador = datos[2];
                    String fechaEntrada = datos[3];
                    String fechaSalida = datos[4];
                    String estadoReserva = datos[5];
                    String cantidadPersonas = datos[6];
                    String horaLlegada = datos[7];
                    String retencionFuente = datos[8];
                    String cantidadAnticipo = datos[9];
                    String porcentajeRetencion = datos[10];
                    String total = datos[11];
                    

                    // Crear objeto Producto y agregarlo a la lista
                    ReservaObjeto custom = new ReservaObjeto(idHabitacion,idCliente,idCreador,fechaEntrada,fechaSalida,estadoReserva, cantidadPersonas,horaLlegada,retencionFuente, cantidadAnticipo, porcentajeRetencion, total);
                    reserva.add(custom);
                } else {
                    i++;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return reserva;
    }
    
    public static void actualizarReserva(String archivoCSV,String nombre, String documento, String correo, String telefono, String ocupacion, String ciudad) {
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
