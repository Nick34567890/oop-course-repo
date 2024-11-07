package oop.Lab2.Task2.CoffeClasses;

import oop.Lab2.Task2.Enum.EnumIntensity;

public class Coffee {
    // Fields
    private EnumIntensity coffeeIntensity;
    protected String coffeeName;

    // Properties (Getters)
    public EnumIntensity getCoffeeIntensity() {
        return coffeeIntensity;
    }

    public String getCoffeeName() {
        return coffeeName;
    }

    // Methods
    public void printCoffeeDetails() {
        System.out.println(coffeeName + " intensity: " + coffeeIntensity);
    }

    // Constructor
    public Coffee(EnumIntensity intensity) {
        this.coffeeName = "Coffee";
        this.coffeeIntensity = intensity;
    }
}

