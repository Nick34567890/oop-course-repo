package oop.Lab2.Task1.CoffeClasses;

import oop.Lab2.Task1.Enum.EnumIntensity;

public class Cappuccino extends Coffee {
    // Field
    private int mlOfMilk;

    // Property (Getter)
    public int getMlOfMilk() {
        return mlOfMilk;
    }

    // Constructor
    public Cappuccino(EnumIntensity intensity, int mlOfMilk) {
        super(intensity);  // Calling the constructor of the superclass (Coffee)
        this.coffeeName = "Cappuccino";
        this.mlOfMilk = mlOfMilk;
    }
}

