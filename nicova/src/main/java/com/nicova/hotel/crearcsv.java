package com.nicova.hotel;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class crearcsv {
    public void Crear(String[] args) {
        agregarHolaMundoAlCSV("C:\\Nicova\\clientes.csv");
    }

    public static void agregarHolaMundoAlCSV(String nombreArchivo) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo, true));
            writer.append("Hola Mundo");
            writer.newLine();
            writer.close();
            System.out.println("Se agregó 'Hola Mundo' al archivo CSV: " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Ocurrió un error al escribir en el archivo.");
        }
    }
}
