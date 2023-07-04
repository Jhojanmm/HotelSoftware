package com.nicova.hotel;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class csvToSheet {
    public static void main(String spreadsheetId, String filePath) {
        try {
            // Set up credentials
            FileInputStream credentialsFile = new FileInputStream("C:\\Nicova\\nicovaDB.json");
            GoogleCredential credential = GoogleCredential.fromStream(credentialsFile)
                    .createScoped(Arrays.asList(SheetsScopes.SPREADSHEETS, SheetsScopes.DRIVE));

            // Specify the spreadsheet ID

            // Create a blank spreadsheet
            Sheets service = new Sheets.Builder(credential.getTransport(), credential.getJsonFactory(), credential)
                    .setApplicationName("NewDatabase")
                    .build();

            // Open the spreadsheet
            String sheetName = service.spreadsheets().get(spreadsheetId).execute().getSheets().get(0).getProperties().getTitle();
            ValueRange requestBody = new ValueRange();
            requestBody.setRange(sheetName);

            // Read CSV with Apache Commons CSV
            CSVParser csvParser = new CSVParser(new FileReader(filePath), CSVFormat.DEFAULT);
            List<CSVRecord> records = csvParser.getRecords();

            // Convert CSV data to a 2D array
            List<List<Object>> data = new ArrayList<>();
            for (CSVRecord record : records) {
                List<Object> rowData = new ArrayList<>();
                for (String value : record) {
                    rowData.add(value);
                }
                data.add(rowData);
            }

            requestBody.setValues(data);

            // Update the sheet with CSV data
            service.spreadsheets().values().update(spreadsheetId, sheetName, requestBody)
                    .setValueInputOption("RAW")
                    .execute();

            System.out.println("Data successfully exported to Google Sheets.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
