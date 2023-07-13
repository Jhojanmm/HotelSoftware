/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nicova.controllers;

import com.nicova.connetion.checkConnetion;
import com.nicova.connetion.offlineConnection;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.GeneralSecurityException;

/**
 *
 * @author jhoja
 */
public class AddUser {
    
    
    public static void main(String[] data) throws GeneralSecurityException {
        if (checkConnetion.isConnected()) {
            String filePath = "C:\\Nicova\\usuarios.csv";
            writeCSV(data, filePath, true);
            System.out.println("Datos guardados en " + filePath);
        } else {
            String filePath = "C:\\Nicova\\usuariosOffline.csv";
            CrearArchivoCSV(filePath);
            writeCSV(data, filePath, false);
            System.out.println("Datos guardados en " + filePath);
        }

    }

    public static void CrearArchivoCSV(String rutaArchivo) throws GeneralSecurityException {
        File archivoCSV = new File(rutaArchivo);

        if (archivoCSV.exists()) {
            System.out.println("El archivo ya existe en la ubicación especificada.");
        } else {
            try {
                if (archivoCSV.createNewFile()) {
                    System.out.println("El archivo ha sido creado correctamente.");
                } else {
                    System.out.println("No se pudo crear el archivo.");
                }
            } catch (IOException e) {
                System.out.println("Error al crear el archivo: " + e.getMessage());
            }
        }
    }

    private static void writeCSV(String[] data, String filePath, boolean check) {
        try {
            FileWriter writer = new FileWriter(filePath, true);

            for (int i = 0; i < data.length; i++) {
                writer.append(data[i]); // Escribir el valor en el archivo CSV
                if (i < data.length - 1) {
                    writer.append(','); // Separador de columnas
                }
            }
            writer.append('\n');

            writer.flush();
            writer.close();
            if (check) {
                com.nicova.hotel.csvToSheet.main("1eryWNc7sn1KG8PlZFsfsin-DH6NP5SQAgWCUDTk17ys", "C:\\Nicova\\usuarios.csv");
            } else {
                offlineConnection internetChecker = new offlineConnection();
                Thread thread = new Thread(internetChecker);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
