package com.suprun.arrayoperation.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

// class is used for reading data from source
public class CustomDataReader {

    // default data file path
    private final String defaultFile = "file.txt";

    // method is used for reading data from console
    public int consoleRead(Scanner scanner){
        int value = 0;
        while (!scanner.hasNextInt()) {
            System.out.println("You enter non integer number");
            scanner.next();
        }
        return value = scanner.nextInt();
    }

    // method is used for reading data from console
    public String fileRead(String filePath){
        Path file = null;
        if (Files.isRegularFile(Paths.get(filePath))){
            file = Paths.get(filePath);
        } else {
            URL fileLocation = this.getClass().getClassLoader().getResource(defaultFile);
            if (fileLocation != null) {
            file = Paths.get(fileLocation.toString().substring(6));
            System.out.printf("Failed to load array values from specified file %s, so array filled from default file%n",
                    filePath);}
        }
        StringBuilder lines = new StringBuilder();
        String line;
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            while ((line = reader.readLine()) != null){
                lines.append(line);
                lines.append(System.lineSeparator());
            }
            return lines.toString();
        } catch (IOException e) {
            System.out.printf("Failed to load array values from file %s%n",
                    file.toString());
            return line = "";
        }
    }
}