package oop.Lab2.Task3.CoffeClasses;

import oop.Lab2.Task3.Enum.EnumIntensity;

public abstract class Coffee {
    // Fields
    private EnumIntensity coffeeIntensity;
    protected String coffeeName; // Change to protected

    // Properties (Getters and Setters)
    protected EnumIntensity getCoffeeIntensity() {
        return coffeeIntensity;
    }

    protected String getCoffeeName() {
        return coffeeName;
    }

    protected void setCoffeeName(String coffeeName) {
        this.coffeeName = coffeeName;
    }

    // Methods
    public void printCoffeeDetails() {
        System.out.println(getCoffeeName() + " intensity: " + getCoffeeIntensity());
    }

    protected Coffee makeCoffee() {
        System.out.println("Making " + getCoffeeName());
        System.out.println("Intensity set to " + getCoffeeIntensity());
        return this;  // Returning the current instance of Coffee
    }

    // Constructor
    protected Coffee(EnumIntensity intensity) {
        this.coffeeIntensity = intensity;
    }
}
