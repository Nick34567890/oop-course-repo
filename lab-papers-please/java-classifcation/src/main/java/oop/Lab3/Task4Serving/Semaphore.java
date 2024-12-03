package oop.Lab3.Task4Serving;

import oop.Lab3.CarStation;

import oop.Lab3.Task1QueueClasses.LinkedListQueue;
import oop.Lab3.Task2ServingClasses.ElectricStation;
import oop.Lab3.Task2ServingClasses.GasStation;
import oop.Lab3.Task2ServingClasses.PeopleDiner;
import oop.Lab3.Task2ServingClasses.RobotsDiner;
import oop.Lab3.Task3CarRelated.Car;
import oop.Lab3.Task3CarRelated.CarType;
import oop.Lab3.Task3CarRelated.PassengersType;

import java.util.List;


public class Semaphore {
    private List<CarStation> carStations;

    // Constructor
    public Semaphore(List<CarStation> carStations) {
        this.carStations = carStations;
    }

    // Getter method for car stations
    public List<CarStation> getCarStations() {
        return carStations;
    }

    // Choosing the right station for each car
    private void leadToRightStation(Car car) {
        if (car.getType() == CarType.GAS && car.getPassengers() == PassengersType.PEOPLE) {
            for (CarStation station : carStations) {
                if (station.getRefuelingService() instanceof GasStation && station.getDiningService() instanceof PeopleDiner) {
                    System.out.println("Adding Car " + car.getId() + ", to the GAS station for PEOPLE");
                    station.addCar(car);
                    break;
                }
            }
        } else if (car.getType() == CarType.GAS && car.getPassengers() == PassengersType.ROBOTS) {
            for (CarStation station : carStations) {
                if (station.getRefuelingService() instanceof GasStation && station.getDiningService() instanceof RobotsDiner) {
                    System.out.println("Adding Car " + car.getId() + ", to the GAS station for ROBOTS");
                    station.addCar(car);
                    break;
                }
            }
        } else if (car.getType() == CarType.ELECTRIC && car.getPassengers() == PassengersType.ROBOTS) {
            for (CarStation station : carStations) {
                if (station.getRefuelingService() instanceof ElectricStation && station.getDiningService() instanceof RobotsDiner) {
                    System.out.println("Adding Car " + car.getId() + ", to the ELECTRIC station for ROBOTS");
                    station.addCar(car);
                    break;
                }
            }
        } else if (car.getType() == CarType.ELECTRIC && car.getPassengers() == PassengersType.PEOPLE) {
            for (CarStation station : carStations) {
                if (station.getRefuelingService() instanceof ElectricStation && station.getDiningService() instanceof PeopleDiner) {
                    System.out.println("Adding Car " + car.getId() + ", to the ELECTRIC station for PEOPLE");
                    station.addCar(car);
                    break;
                }
            }
        }
    }

    // Going through each added car from each station and serving them
    public void serveCars(LinkedListQueue<Car> carsForServing) {
        while (carsForServing.size() > 0) {
            leadToRightStation(carsForServing.dequeue());
        }
    }
}
