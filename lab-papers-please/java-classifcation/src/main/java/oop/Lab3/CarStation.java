package oop.Lab3;
import oop.Lab3.Task1QueueClasses.IQueue;
import oop.Lab3.Task2ServingClasses.Intergaces.IDineable;
import oop.Lab3.Task2ServingClasses.Intergaces.IRefuelable;
import oop.Lab3.Task2ServingClasses.ServeData;
import oop.Lab3.Task3CarRelated.Car;
import oop.Lab3.Task3CarRelated.CarType;
import oop.Lab3.Task3CarRelated.PassengersType;

public class CarStation {
    private IDineable diningService;
    private IRefuelable refuelingService;
    private IQueue<Car> queue;

    // Constructor
    public CarStation(IDineable dineable, IRefuelable refuelable, IQueue<Car> queue) {
        this.diningService = dineable;
        this.refuelingService = refuelable;
        this.queue = queue;
    }

    // Serve cars in the queue
    public void serveCars() {
        while (queue.size() > 0) {
            System.out.println();
            Car dequeuedCar = queue.dequeue();

            // Serving the entities at the Diner
            if (dequeuedCar.isDining()) {
                diningService.serveDiner(dequeuedCar.getId());
            } else {
                ServeData.incrementNotDining();
            }

            if (dequeuedCar.getPassengers() == PassengersType.PEOPLE) {
                ServeData.incrementPeopleAmount();
            } else {
                ServeData.incrementRobotsAmount();
            }

            // Refueling the car
            refuelingService.refuel(dequeuedCar.getId());
            if (dequeuedCar.getType() == CarType.ELECTRIC) {
                ServeData.incrementElectricConsumption(dequeuedCar.getConsumption());
            } else {
                ServeData.incrementGasConsumption(dequeuedCar.getConsumption());
            }

            System.out.println("Car " + dequeuedCar.getId() + " has been served");
        }
    }

    // Add a car to the queue
    public void addCar(Car car) {
        queue.enqueue(car);
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return queue.size() == 0;
    }

    // Getter methods for dining and refueling services
    public IDineable getDiningService() {
        return diningService;
    }

    public IRefuelable getRefuelingService() {
        return refuelingService;
    }
}
