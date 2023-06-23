package com.nicova.controllers;

import java.io.FileWriter;
import java.io.IOException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jhoja
 */
public class AddClient {
    
    
    public static void main(String[] data) {
        String filePath = "C:\\Nicova\\clientes.csv";
        writeCSV(data, filePath);
        System.out.println("Datos guardados en " + filePath);
    }

    private static void writeCSV(String[] data, String filePath) {
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
            com.nicova.hotel.csvToSheet.main();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
