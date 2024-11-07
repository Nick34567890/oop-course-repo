package oop.Lab2.Task3.CoffeClasses;


import oop.Lab2.Task3.Enum.EnumIntensity;


public class Americano extends Coffee {
    // Fields
    private int mlOfWater;

    // Getter for mlOfWater
    protected int getMlOfWater() {
        return mlOfWater;
    }

    // Method (Override) to print coffee details
    @Override
    public void printCoffeeDetails() {
        super.printCoffeeDetails(); // Calling the method from the superclass (Coffee)
        System.out.println("Americano water: " + getMlOfWater());
    }

    // Method to make Americano
    public Americano makeAmericano() {
        makeCoffee(); // Calling the method from the superclass (Coffee)
        System.out.println("Adding " + getMlOfWater() + " mls of WATER");
        return this; // Returning the current instance of Americano
    }

    // Constructor
    public Americano(EnumIntensity intensity, int mlOfWater) {
        super(intensity); // Calling the constructor of the superclass (Coffee)
        this.setCoffeeName("Americano"); // Using setter for coffeeName
        this.mlOfWater = mlOfWater;
    }
}

