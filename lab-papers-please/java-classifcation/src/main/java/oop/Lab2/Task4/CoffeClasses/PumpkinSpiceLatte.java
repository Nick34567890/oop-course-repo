package oop.Lab2.Task4.CoffeClasses;


import oop.Lab2.Task4.Enum.EnumIntensity;

class PumpkinSpiceLatte extends Cappuccino {
    // Field
    private int mgOfPumpkinSpice;

    // Property (Getter)
    public int getMgOfPumpkinSpice() {
        return mgOfPumpkinSpice;
    }

    // Constructor
    public PumpkinSpiceLatte(EnumIntensity intensity, int mlOfMilk, int mgOfPumpkinSpice) {
        super(intensity, mlOfMilk);  // Calling the constructor of the superclass (Cappuccino)
        this.coffeeName = "PumpkinSpiceLatte";
        this.mgOfPumpkinSpice = mgOfPumpkinSpice;
    }
}

