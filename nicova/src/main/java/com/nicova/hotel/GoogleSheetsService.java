/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nicova.hotel;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

public class GoogleSheetsService {
    private static final String CREDENTIALS_FILE_PATH = "C:\\Nicova\\nicovaDB.json";

    public static Sheets getSheetsService() throws IOException, GeneralSecurityException {
        GoogleCredential credential = GoogleCredential
                .fromStream(new FileInputStream(CREDENTIALS_FILE_PATH))
                .createScoped(Collections.singleton(SheetsScopes.SPREADSHEETS));

        return new Sheets.Builder(credential.getTransport(), credential.getJsonFactory(), credential)
                .setApplicationName("Google Sheets to CSV")
                .build();
    }
}
