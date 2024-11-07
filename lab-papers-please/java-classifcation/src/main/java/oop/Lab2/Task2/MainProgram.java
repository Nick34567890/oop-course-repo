package oop.Lab2.Task2;

import oop.Lab2.Task2.CoffeClasses.Cappuccino;
import oop.Lab2.Task2.CoffeClasses.PumpkinSpiceLatte;
import oop.Lab2.Task2.CoffeClasses.Americano;
import oop.Lab2.Task2.CoffeClasses.Coffee;

import oop.Lab2.Task2.CoffeClasses.SyrupCappuccino;
import oop.Lab2.Task2.Enum.EnumIntensity;
import oop.Lab2.Task2.Enum.EnumSyrupType;

public class MainProgram {
    public static void main(String[] args) {
        Coffee coffee = new Coffee(EnumIntensity.STRONG);
        coffee.printCoffeeDetails();

        Cappuccino cappuccino = new Cappuccino(EnumIntensity.STRONG, 100);
        cappuccino.printCoffeeDetails();

        Americano americano = new Americano(EnumIntensity.STRONG, 110);
        americano.printCoffeeDetails();

        PumpkinSpiceLatte pumpkinSpiceLatte = new PumpkinSpiceLatte(EnumIntensity.NORMAL, 50, 30);
        pumpkinSpiceLatte.printCoffeeDetails();

        SyrupCappuccino syrupCappuccino = new SyrupCappuccino(EnumIntensity.LIGHT, 20, EnumSyrupType.CHOCOLATE);
        syrupCappuccino.printCoffeeDetails();
    }
}
