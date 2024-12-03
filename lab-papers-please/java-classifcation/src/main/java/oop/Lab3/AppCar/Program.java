package oop.Lab3.AppCar;

import oop.Lab3.CarStation;
import oop.Lab3.Task1QueueClasses.CircularQueue;
import oop.Lab3.Task1QueueClasses.LinkedListQueue;
import oop.Lab3.Task1QueueClasses.SimpleQueue;
import oop.Lab3.Task2ServingClasses.*;
import oop.Lab3.Task3CarRelated.Car;
import oop.Lab3.Task4Serving.Json;
import oop.Lab3.Task4Serving.Semaphore;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Program {

    public static void main(String[] args) {
        List<CarStation> carStationList = new ArrayList<>();
        carStationList.add(new CarStation(new PeopleDiner(), new GasStation(), new CircularQueue<>(10)));
        carStationList.add(new CarStation(new RobotsDiner(), new GasStation(), new LinkedListQueue<>()));
        carStationList.add(new CarStation(new PeopleDiner(), new ElectricStation(), new CircularQueue<>(10)));
        carStationList.add(new CarStation(new RobotsDiner(), new ElectricStation(), new SimpleQueue<>()));
        Semaphore stationSemaphore = new Semaphore(carStationList);
        LinkedListQueue<Car> carQueue = new LinkedListQueue<>();

        Thread carAdditionThread = new Thread(() -> addCarsToCorrectStation(carQueue, stationSemaphore)); // Adding the cars to the station
        Thread carServingThread = new Thread(() -> serveCarsFromStations(carStationList)); // Serving the cars

        carAdditionThread.start();
        carServingThread.start();
    }

    private static void addCarsToCorrectStation(LinkedListQueue<Car> carQueue, Semaphore stationSemaphore) {
        //Path absolute to queue
        File folder = new File("C:\\Users\\My\\Documents\\University\\POO\\oop-course-repo\\lab-papers-please\\java-classifcation\\src\\main\\resources\\queue");
        File[] jsonFiles = folder.listFiles((dir, name) -> name.endsWith(".json"));

        if (jsonFiles != null) {
            for (File jsonFile : jsonFiles) {
                LinkedListQueue<String> jsonDataQueue = new LinkedListQueue<>();
                jsonDataQueue.enqueue(jsonFile.getAbsolutePath());
                Json.toCar(jsonDataQueue, carQueue);

                try {
                    Thread.sleep(2000); // Simulate processing time
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                stationSemaphore.serveCars(carQueue); // Serve the cars at stations
            }
        }
    }

    private static void serveCarsFromStations(List<CarStation> carStationList) {
        boolean carsLeftToServe = true;
        while (carsLeftToServe) {
            int emptyStationsCount = 0;
            try {
                Thread.sleep(9000); // Simulate the waiting time for cars to be ready
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            boolean firstServingCycle = true;
            for (CarStation station : carStationList) {
                if (station.isEmpty()) {
                    emptyStationsCount++;
                    continue;
                }
                if (firstServingCycle) {
                    System.out.println("\nProviding Service to Vehicles at the Station");
                    firstServingCycle = false;
                }
                station.serveCars();
            }

            if (emptyStationsCount == carStationList.size()) {
                break;
            }
            System.out.println("\n-----------------------------------------\n");
        }

        System.out.println("\nAll cars have been served successfully!");
        try {
            Thread.sleep(1000); // Simulate the final processing time
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ServeData.overview(); // Provide a final overview of the results
    }
}
