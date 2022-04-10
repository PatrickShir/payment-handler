package main.java.se.lumera.example.service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Logger;

/**
 * FileHandler simply reads expected files within a targeted folder and calls for them to be processed.
 */
public class FileHandler {
    private static final Logger LOGGER = Logger.getLogger(FileHandler.class.getName());

    /**
     * This method reads all files within a chosen folder and calls to process the ones with a known filename.
     */
    public void readFiles(String folderPath) {
        File folder = new File(folderPath + "/");
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.getName().contains("_betalningsservice.txt") || file.getName().contains("_inbetalningstjansten.txt")) {
                processFile(folderPath, file);
            } else {
                LOGGER.warning("WARNING MESSAGE Unrecognized filename" + "\n" + file.getName());
            }
        }
    }

    /**
     * Transforms a selected file into a list of string and passes it onwards to the service class for extraction.
     */
    private void processFile(String folderPath, File file) {
        PaymentService paymentService = new PaymentService();
        try {
            List<String> content = Files.readAllLines(Paths.get(folderPath + "/" + file.getName()), StandardCharsets.ISO_8859_1);
            if (!content.isEmpty()) {
                paymentService.extractData(content);
            } else {
                LOGGER.severe("ERROR MESSAGE File is empty" + "\n" + folderPath + "/" + file.getName());
            }
        } catch (IOException | IndexOutOfBoundsException e) {
            LOGGER.severe("ERROR MESSAGE " + e + "\n" + "File " + file.getName());
        }
    }
}