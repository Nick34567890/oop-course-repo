package oop.Lab2.Task3.CoffeClasses;

import oop.Lab2.Task3.Enum.EnumIntensity;

public class Cappuccino extends Coffee {
    // Field
    private int mlOfMilk;

    // Property (Getter)
    protected int getMlOfMilk() {
        return mlOfMilk;
    }

    // Method (Override)
    @Override
    public void printCoffeeDetails() {
        super.printCoffeeDetails();  // Calling the method from the superclass (Coffee)
        System.out.println("Cappuccino milk: " + getMlOfMilk());
    }

    // Method to make Cappuccino
    public Cappuccino makeCappuccino() {
        makeCoffee();  // Assuming the parent class has a method for making coffee
        System.out.println("Adding " + getMlOfMilk() + " mls of MILK");
        return this;  // Returning the current instance of Cappuccino
    }

    // Constructor
    public Cappuccino(EnumIntensity intensity, int mlOfMilk) {
        super(intensity);  // Calling the constructor of the superclass (Coffee)
        this.coffeeName = "Cappuccino";
        this.mlOfMilk = mlOfMilk;
    }
}

