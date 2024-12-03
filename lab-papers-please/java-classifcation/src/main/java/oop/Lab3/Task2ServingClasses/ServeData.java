package oop.Lab3.Task2ServingClasses;

public class ServeData {
    // Fields for tracking various data
    private static int gasCars = 0;
    private static int electricCars = 0;
    private static int gasConsumption = 0;
    private static int electricConsumption = 0;
    private static int amountDining = 0;
    private static int amountNotDining = 0;
    private static int amountRobots = 0;
    private static int amountPeople = 0;

    // Getter methods to access private fields (optional if needed)
    public static int getGasCars() { return gasCars; }
    public static int getElectricCars() { return electricCars; }
    public static int getGasConsumption() { return gasConsumption; }
    public static int getElectricConsumption() { return electricConsumption; }
    public static int getAmountDining() { return amountDining; }
    public static int getAmountNotDining() { return amountNotDining; }
    public static int getAmountRobots() { return amountRobots; }
    public static int getAmountPeople() { return amountPeople; }

    // Methods to increment the fields
    public static void incrementGasCars() {
        gasCars++;
    }

    public static void incrementElectricCars() {
        electricCars++;
    }

    public static void incrementGasConsumption(int consumption) {
        gasConsumption += consumption;
    }

    public static void incrementElectricConsumption(int consumption) {
        electricConsumption += consumption;
    }

    public static void incrementDining() {
        amountDining++;
    }

    public static void incrementNotDining() {
        amountNotDining++;
    }

    public static void incrementRobotsAmount() {
        amountRobots++;
    }

    public static void incrementPeopleAmount() {
        amountPeople++;
    }

    // Method to reset all data
    public static void resetData() {
        gasCars = 0;
        electricCars = 0;
        gasConsumption = 0;
        electricConsumption = 0;
        amountDining = 0;
        amountNotDining = 0;
        amountRobots = 0;
        amountPeople = 0;
    }

    // Method to print an overview of all data
    public static void overview() {
        System.out.println("\nIn total we have served:");
        System.out.println("\tELECTRIC cars - " + electricCars + ", with a total consumption of " + electricConsumption);
        System.out.println("\tGAS cars - " + gasCars + ", with a total consumption of " + gasConsumption);
        System.out.println("\tROBOTS - " + amountRobots);
        System.out.println("\tPEOPLE - " + amountPeople);
        System.out.println("\tEntities that did dine - " + amountDining);
        System.out.println("\tEntities that did NOT dine - " + amountNotDining + "\n");
    }
}

