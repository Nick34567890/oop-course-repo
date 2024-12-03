package oop.Lab3.Task2ServingClasses;

import oop.Lab3.Task2ServingClasses.Intergaces.IRefuelable;

public class ElectricStation implements IRefuelable {
    @Override
    public void refuel(int carId) {
        System.out.println("Refueling ELECTRIC Car " + carId);
        ServeData.incrementElectricCars();
    }
}

