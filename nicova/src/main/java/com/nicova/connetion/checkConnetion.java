/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nicova.connetion;

import java.io.IOException;
import java.net.InetAddress;

public class checkConnetion {

    public static boolean isConnected() {
        try {
            InetAddress address = InetAddress.getByName("www.google.com");
            return address.isReachable(5000); // 5000 milisegundos de tiempo de espera
        } catch (IOException e) {
            return false;
        }
    }

}
