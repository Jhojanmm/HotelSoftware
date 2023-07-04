/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nicova.controllers;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class OfflineToOnlineCsv {
    public static void appendCSV(String sourceFilePath, String destinationFilePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFilePath, true))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Borrar el archivo de origen
        deleteFile(sourceFilePath);
        com.nicova.hotel.csvToSheet.main("1f2tjSzo8NbGoYk-ERMuGhaOrSD7x1FaQ4XJOBuBVCt8",destinationFilePath);
    }

    public static void deleteFile(String filePath) {
        try {
            java.nio.file.Files.delete(java.nio.file.Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}