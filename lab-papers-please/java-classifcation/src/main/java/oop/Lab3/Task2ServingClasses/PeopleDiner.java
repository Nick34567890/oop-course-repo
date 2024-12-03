package oop.Lab3.Task2ServingClasses;

public class PeopleDiner implements IDineable {
    @Override
    public void serveDiner(int carId) {
        System.out.println("Serving diner to PEOPLE from car " + carId);
        ServeData.incrementDining();
    }
}
