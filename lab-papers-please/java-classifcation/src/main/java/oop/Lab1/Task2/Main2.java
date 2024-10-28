package oop.Lab1.Task2;

import java.io.IOException;

public class Main2 {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please provide the file path as a command-line argument.");
            return;
        }
        for(int i = 0; i < args.length; i++) {
            String filePath = args[i];
            try {
                String content = FileReader.readFileIntoString(filePath);
                TextData textData = new TextData(filePath, content);
                System.out.println(textData + "\n\n");
            } catch (IOException e) {
                System.out.println("Error reading the file: " + e.getMessage());
            }
        }

    }
}
