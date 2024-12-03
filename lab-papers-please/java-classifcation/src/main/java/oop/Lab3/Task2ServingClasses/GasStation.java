package oop.Lab3.Task2ServingClasses;

import oop.Lab3.Task2ServingClasses.Intergaces.IRefuelable;

public class GasStation implements IRefuelable {
    @Override
    public void refuel(int carId) {
        System.out.println("Refueling GAS Car " + carId);
        ServeData.incrementGasCars();
    }
}

