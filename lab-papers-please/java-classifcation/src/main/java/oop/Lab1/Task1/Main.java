package oop.Lab1.Task1;

public class Main {
    // Main method to demonstrate the functionality
    public static void main(String[] args) {
        Display display1 = new Display(1920, 1080, 401, "One1");
        Display display2 = new Display(2560, 1440, 500, "Two2");
        Display display3 = new Display(1280, 720, 267, "Three3");

        // Comparing displays
        display1.compareSize(display2);
        System.out.println("\n");
        display2.compareSharpness(display3);
        System.out.println("\n");
        display1.compareWithMonitor(display3);
    }
}
