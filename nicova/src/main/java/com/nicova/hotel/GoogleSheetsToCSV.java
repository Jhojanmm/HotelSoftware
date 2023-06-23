/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nicova.hotel;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;

import java.io.FileWriter;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

public class GoogleSheetsToCSV {

    private static final String SPREADSHEET_ID = "1f2tjSzo8NbGoYk-ERMuGhaOrSD7x1FaQ4XJOBuBVCt8";
    private static final String OUTPUT_FILE_PATH = "C:\\Nicova\\clientes.csv";

    public static void main() throws GeneralSecurityException {
        try {
            Sheets sheetsService = GoogleSheetsService.getSheetsService(); // Obtener el servicio de Google Sheets

            List<List<Object>> values = readSheetData(sheetsService, "Sheet1"); // Leer los datos de la hoja "Sheet1"

            if (values != null) {
                writeCSV(values, OUTPUT_FILE_PATH); // Escribir los datos en un archivo CSV
                System.out.println("Datos guardados en " + OUTPUT_FILE_PATH);
            } else {
                System.out.println("No se encontraron datos en la hoja de cálculo.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<List<Object>> readSheetData(Sheets service, String sheetName) throws IOException {
        String range = sheetName + "!A1:ZZ"; // Rango de celdas a leer (todas las columnas desde A hasta ZZ)
        ValueRange response = service.spreadsheets().values().get(SPREADSHEET_ID, range).execute();
        List<List<Object>> values = response.getValues();
        return values;
    }

    private static void writeCSV(List<List<Object>> data, String filePath) throws IOException {
        FileWriter writer = new FileWriter(filePath);

        for (List<Object> row : data) {
            for (Object cell : row) {
                writer.append(cell.toString()); // Escribir el valor de la celda en el archivo CSV
                writer.append(',');
            }
            writer.append('\n'); // Nueva línea para cada fila
        }

        writer.flush();
        writer.close();
    }
}
