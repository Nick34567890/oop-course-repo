//package oop.Lab2.Task4;
//// TODO: Define the Barista class to have access to the Coffee class.
//// TODO: Define methods to make specific coffee types like Pumpkin Spice Latte
//// TODO: Call makeCoffee method in Coffee class and implement the specific logic for Americano
//// TODO: Implement logic to print details about the coffee
//
//import oop.Lab2.Task4.CoffeClasses.Cappuccino;
//import oop.Lab2.Task4.CoffeClasses.PumpkinSpiceLatte;
//import oop.Lab2.Task4.CoffeClasses.Americano;
//import oop.Lab2.Task4.CoffeClasses.Coffee;
//
//import oop.Lab2.Task4.CoffeClasses.SyrupCappuccino;
//import oop.Lab2.Task4.Enum.EnumIntensity;
//import oop.Lab2.Task4.Enum.EnumSyrupType;
//
//
//import java.util.List;
//
//public class BaristaProgram {
//    // Method to make a Pumpkin Spice Latte
//    public PumpkinSpiceLatte makePumpkinSpiceLatte(EnumIntensity intensity, int mlOfMilk, int mgOfPumpkinSpice) {
//        PumpkinSpiceLatte pumpkinSpiceLatte = new PumpkinSpiceLatte(intensity, mlOfMilk, mgOfPumpkinSpice);
//        pumpkinSpiceLatte.makeCoffeeForBarista();  // Calling the makeCoffee method
//        printCoffeeDetails(pumpkinSpiceLatte);  // Printing details of the Pumpkin Spice Latte
//        return pumpkinSpiceLatte;
//    }
//
//    // Method to make an Americano
//    public Americano makeAmericano(EnumIntensity intensity, int mlOfWater) {
//        Americano americano = new Americano(intensity, mlOfWater);
//        americano.makeCoffeeForBarista();  // Calling the makeCoffee method
//        printCoffeeDetails(americano);  // Printing details of the Americano
//        return americano;
//    }
//
//    // Method to make a Syrup Cappuccino
//    public SyrupCappuccino makeSyrupCappuccino(EnumIntensity intensity, int mlOfMilk, EnumSyrupType syrupType) {
//        SyrupCappuccino syrupCappuccino = new SyrupCappuccino(intensity, mlOfMilk, syrupType);
//        syrupCappuccino.makeCoffeeForBarista();  // Calling the makeCoffee method
//        printCoffeeDetails(syrupCappuccino);  // Printing details of the Syrup Cappuccino
//        return syrupCappuccino;
//    }
//
//    // Method to print coffee details
//    public void printCoffeeDetails(Coffee coffee) {
//        System.out.println("Coffee Name: " + coffee.getCoffeeName());
//        System.out.println("Coffee Intensity: " + coffee.getCoffeeIntensity());
//    }
//
//    // Method to make multiple coffees (useful for a coffee shop with a list of orders)
//    public void makeAllCoffees(List<Coffee> coffees) {
//        for (Coffee coffee : coffees) {
//            coffee.makeCoffeeForBarista();  // Calling the makeCoffee method
//            printCoffeeDetails(coffee);  // Printing details of each coffee
//        }
//    }
//}
//
//
