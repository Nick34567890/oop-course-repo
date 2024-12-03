package oop.Lab3.Task2ServingClasses;

public class RobotsDiner implements IDineable {
    @Override
    public void serveDiner(int carId) {
        System.out.println("Serving diner to ROBOTS from car " + carId);
        ServeData.incrementDining();
    }
}

