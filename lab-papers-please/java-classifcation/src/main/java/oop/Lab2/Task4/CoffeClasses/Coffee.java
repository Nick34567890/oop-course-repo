package oop.Lab2.Task4.CoffeClasses;

import oop.Lab2.Task4.Enum.EnumIntensity;

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

    // Constructor
    public Coffee(EnumIntensity intensity) {
        this.coffeeName = "Coffee";
        this.coffeeIntensity = intensity;
    }
}

