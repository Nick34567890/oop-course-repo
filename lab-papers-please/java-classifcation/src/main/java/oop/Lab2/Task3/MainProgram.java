package oop.Lab2.Task3;

import oop.Lab2.Task3.CoffeClasses.Cappuccino;
import oop.Lab2.Task3.CoffeClasses.PumpkinSpiceLatte;
import oop.Lab2.Task3.CoffeClasses.Americano;
import oop.Lab2.Task3.CoffeClasses.Coffee;

import oop.Lab2.Task3.CoffeClasses.SyrupCappuccino;
import oop.Lab2.Task3.Enum.EnumIntensity;
import oop.Lab2.Task3.Enum.EnumSyrupType;

public class MainProgram {
    public static void main(String[] args) {
        // Clear the console (optional in Java, not directly supported)
        System.out.print("\033[H\033[2J");
        System.out.flush();

        // Create and make a Cappuccino
        Coffee cappuccino = new Cappuccino(EnumIntensity.NORMAL, 42).makeCappuccino();
        cappuccino.printCoffeeDetails();
        System.out.println();

        // Create and make an Americano
        Coffee americano = new Americano(EnumIntensity.NORMAL, 52).makeAmericano();
        americano.printCoffeeDetails();
        System.out.println();

        // Create and make a Pumpkin Spice Latte
        Coffee pumpkinSpiceLatte = new PumpkinSpiceLatte(EnumIntensity.LIGHT, 90, 30).makePumpkinSpiceLatte();
        pumpkinSpiceLatte.printCoffeeDetails();
        System.out.println();

        // Create and make a Syrup Cappuccino
        Coffee syrupCappuccino = new SyrupCappuccino(EnumIntensity.LIGHT, 60, EnumSyrupType.CHOCOLATE).makeSyrupCappuccino();
        syrupCappuccino.printCoffeeDetails();
        System.out.println();
    }
}
