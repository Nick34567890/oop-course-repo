package oop.Lab1.Task2;

import java.io.IOException;

public class Main2 {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please provide the file path as a command-line argument.");
            return;
        }

        String filePath = args[0];
        try {
            String content = FileReader.readFileIntoString(filePath);
            TextData textData = new TextData(filePath, content);
            textData.printData();
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
