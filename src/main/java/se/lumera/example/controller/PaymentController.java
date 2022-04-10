package main.java.se.lumera.example.controller;

import main.java.se.lumera.example.service.FileHandler;

/**
 * A "controller" that is merely used for running the program.
 */
public class PaymentController {
    private static final String folderPath = "src/main/java/se/lumera/example/resources";

    //TODO: All sout prints in this project would obviously not be here if the code was to actually enter production.
    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandler();
        fileHandler.readFiles(folderPath);
    }
}