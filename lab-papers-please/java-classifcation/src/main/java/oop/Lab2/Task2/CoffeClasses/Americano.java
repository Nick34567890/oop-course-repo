package oop.Lab2.Task2.CoffeClasses;


import oop.Lab2.Task2.Enum.EnumIntensity;

public class Americano extends Coffee {
    // Field
    private int mlOfWater;

    // Property (Getter)
    public int getMlOfWater() {
        return mlOfWater;
    }

    // Constructor
    public Americano(EnumIntensity intensity, int mlOfWater) {
        super(intensity);  // Calling the constructor of the superclass (Coffee)
        this.coffeeName = "Americano";
        this.mlOfWater = mlOfWater;
    }
}

