package oop.Lab3.Task4Serving;

import com.fasterxml.jackson.databind.ObjectMapper;
import oop.Lab3.Task1QueueClasses.LinkedListQueue;
import oop.Lab3.Task3CarRelated.Car;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Json {

    // Method to deserialize JSON data into a Car object
    private static Car deserialize(String jsonData) {
        // Checking if the provided string is a file path
        if (new File(jsonData).exists()) {
            try {
                jsonData = new String(Files.readAllBytes(Paths.get(jsonData)));
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        // Deserializing into Car object using Jackson's ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(jsonData, Car.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Method to process a queue of JSON strings and enqueue corresponding Car objects
    public static void toCar(LinkedListQueue<String> sourceJson, LinkedListQueue<Car> carsForServing) {
        // Deserializing the content of each JSON string from the queue
        while (sourceJson.size() > 0) {
            String json = sourceJson.dequeue();
            if (json != null) {
                Car car = deserialize(json);
                if (car != null) {
                    carsForServing.enqueue(car);
                }
            }
        }
    }
}


