package oop.Lab2.Task3.CoffeClasses;


import oop.Lab2.Task3.Enum.EnumIntensity;

public class PumpkinSpiceLatte extends Cappuccino {
    // Field
    private int mgOfPumpkinSpice;

    // Property (Getter)
    private int getMgOfPumpkinSpice() {
        return mgOfPumpkinSpice;
    }

    // Method (Override)
    @Override
    public void printCoffeeDetails() {
        super.printCoffeeDetails();  // Calling the method from the superclass (Cappuccino)
        System.out.println("Pumpkin Spice Latte pumpkin-spice: " + getMgOfPumpkinSpice());
    }

    // Method to make Pumpkin Spice Latte
    public PumpkinSpiceLatte makePumpkinSpiceLatte() {
        makeCappuccino();  // Calling the method from the superclass (Cappuccino)
        System.out.println("Sprinkling " + getMgOfPumpkinSpice() + " mg of pumpkin spice");
        return this;  // Returning the current instance of PumpkinSpiceLatte
    }

    // Constructor
    public PumpkinSpiceLatte(EnumIntensity intensity, int mlOfMilk, int mgOfPumpkinSpice) {
        super(intensity, mlOfMilk);  // Calling the constructor of the superclass (Cappuccino)
        this.coffeeName = "PumpkinSpiceLatte";
        this.mgOfPumpkinSpice = mgOfPumpkinSpice;
    }
}

