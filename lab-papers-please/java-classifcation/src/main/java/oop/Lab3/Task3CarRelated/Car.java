package oop.Lab3.Task3CarRelated;

public class Car {
    private int id;
    private CarType type;
    private PassengersType passengers;
    private boolean isDining;
    private int consumption;

    // Constructor
    public Car(int id, String type, String passengers, boolean isDining, int consumption) {
        this.id = id;
        this.type = type.equals("ELECTRIC") ? CarType.ELECTRIC : CarType.GAS;
        this.passengers = passengers.equals("ROBOTS") ? PassengersType.ROBOTS : PassengersType.PEOPLE;
        this.isDining = isDining;
        this.consumption = consumption;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CarType getType() {
        return type;
    }

    public void setType(CarType type) {
        this.type = type;
    }

    public PassengersType getPassengers() {
        return passengers;
    }

    public void setPassengers(PassengersType passengers) {
        this.passengers = passengers;
    }

    public boolean isDining() {
        return isDining;
    }

    public void setDining(boolean isDining) {
        this.isDining = isDining;
    }

    public int getConsumption() {
        return consumption;
    }

    public void setConsumption(int consumption) {
        this.consumption = consumption;
    }
}

