package oop.Lab1.Task2;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Paths;

class FileReader {
    public static String readFileIntoString(String path) throws IOException {
        System.out.println(System.getProperty("user.dir"));
        return new String(Files.readAllBytes(Paths.get(path)));
    }
}





