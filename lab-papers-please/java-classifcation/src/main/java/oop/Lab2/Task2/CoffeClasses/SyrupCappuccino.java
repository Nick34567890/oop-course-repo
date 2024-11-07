package oop.Lab2.Task2.CoffeClasses;

import oop.Lab2.Task2.Enum.EnumIntensity;
import oop.Lab2.Task2.Enum.EnumSyrupType;

public class SyrupCappuccino extends Cappuccino {
    // Field
    private EnumSyrupType syrup;

    // Property (Getter)
    public EnumSyrupType getSyrup() {
        return syrup;
    }

    // Constructor
    public SyrupCappuccino(EnumIntensity intensity, int mlOfMilk, EnumSyrupType syrup) {
        super(intensity, mlOfMilk);  // Calling the constructor of the superclass (Cappuccino)
        this.coffeeName = "SyrupCappuccino";
        this.syrup = syrup;
    }
}
