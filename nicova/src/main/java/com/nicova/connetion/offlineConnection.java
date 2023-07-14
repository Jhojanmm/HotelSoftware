/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nicova.connetion;

import com.nicova.controllers.OfflineToOnlineCsv;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.security.GeneralSecurityException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class offlineConnection implements Runnable {

    private volatile boolean isConnected;
    private volatile boolean stop;

    public boolean isConnected() {
        return isConnected;
    }

    public void stopChecking() {
        stop = true;
    }

    public static void ActualizarCsv(String rutaArchivo, String rutaDestino) throws GeneralSecurityException {
        File archivoCSV = new File(rutaArchivo);

        if (archivoCSV.exists()) {
            com.nicova.controllers.OfflineToOnlineCsv.appendCSV(rutaArchivo, rutaDestino);
        }
    }

    public static boolean verificarArchivoCSV(String rutaArchivo) throws GeneralSecurityException {
        File archivoCSV = new File(rutaArchivo);

        if(archivoCSV.exists()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void run() {
        while (!stop) {
            try {
                InetAddress address = InetAddress.getByName("www.google.com");
                isConnected = address.isReachable(5000);
                if (verificarArchivoCSV("C:\\Nicova\\clientesOffline.csv")) {
                    ActualizarCsv("C:\\Nicova\\clientesOffline.csv", "C:\\Nicova\\clientes.csv");
                }
                if (verificarArchivoCSV("C:\\Nicova\\usuariosOffline.csv")) {
                    ActualizarCsv("C:\\Nicova\\usuariosOffline.csv", "C:\\Nicova\\usuarios.csv");
                }
            } catch (IOException e) {
                isConnected = false;
            } catch (GeneralSecurityException ex) {
                Logger.getLogger(offlineConnection.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Esperar un intervalo antes de la siguiente verificación
            try {
                Thread.sleep(5000); // 5000 milisegundos de intervalo entre verificaciones
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
