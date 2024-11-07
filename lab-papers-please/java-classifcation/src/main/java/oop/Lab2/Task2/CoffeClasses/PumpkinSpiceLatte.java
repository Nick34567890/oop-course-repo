package oop.Lab2.Task2.CoffeClasses;


import oop.Lab2.Task2.Enum.EnumIntensity;

public class PumpkinSpiceLatte extends Cappuccino {
    // Field
    private int mgOfPumpkinSpice;

    // Property (Getter)
    public int getMgOfPumpkinSpice() {
        return mgOfPumpkinSpice;
    }

    // Method (Override)
    @Override
    public void printCoffeeDetails() {
        super.printCoffeeDetails();  // Calling the method from the superclass (Cappuccino)
        System.out.println("Pumpkin Spice Latte pumpkin-spice: " + getMgOfPumpkinSpice());
    }

    // Constructor
    public PumpkinSpiceLatte(EnumIntensity intensity, int mlOfMilk, int mgOfPumpkinSpice) {
        super(intensity, mlOfMilk);  // Calling the constructor of the superclass (Cappuccino)
        this.coffeeName = "PumpkinSpiceLatte";
        this.mgOfPumpkinSpice = mgOfPumpkinSpice;
    }
}

