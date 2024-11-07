package oop.Lab2.Task3.CoffeClasses;

import oop.Lab2.Task3.Enum.EnumIntensity;
import oop.Lab2.Task3.Enum.EnumSyrupType;


public final class SyrupCappuccino extends Cappuccino {
    // Fields
    private EnumSyrupType syrup;

    // Getter for Syrup
    private EnumSyrupType getSyrup() {
        return syrup;
    }

    // Method to print coffee details
    @Override
    public void printCoffeeDetails() {
        super.printCoffeeDetails(); // Calling the method from the superclass (Cappuccino)
        System.out.println("Syrup Cappuccino syrup type: " + getSyrup());
    }

    // Method to make Syrup Cappuccino
    public SyrupCappuccino makeSyrupCappuccino() {
        makeCappuccino(); // Calling the method from the superclass (Cappuccino)
        System.out.println("Adding some " + getSyrup() + " syrup");
        return this; // Returning the current instance of SyrupCappuccino
    }

    // Constructor
    public SyrupCappuccino(EnumIntensity intensity, int mlOfMilk, EnumSyrupType syrup) {
        super(intensity, mlOfMilk); // Calling the constructor of the superclass (Cappuccino)
        this.coffeeName = "SyrupCappuccino";
        this.syrup = syrup;
    }
}

