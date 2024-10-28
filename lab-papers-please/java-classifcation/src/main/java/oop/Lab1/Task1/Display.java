package oop.Lab1.Task1;

public class Display {
    private int width;
    private int height;
    private float ppi;
    private String model;

    // Constructor
    public Display(int width, int height, float ppi, String model) {
        this.width = width;
        this.height = height;
        this.ppi = ppi;
        this.model = model;
    }

    // Method to compare the size
    public void compareSize(Display otherDisplay) {
        int thisSize = this.width * this.height;
        int otherSize = otherDisplay.width * otherDisplay.height;

        System.out.println("Comparing size between " + this.model + " and " + otherDisplay.model + ":");
        if (thisSize > otherSize) {
            System.out.println(this.model + " is larger than " + otherDisplay.model + ".");
        } else if (thisSize < otherSize) {
            System.out.println(otherDisplay.model + " is larger than " + this.model + ".");
        } else {
            System.out.println("Both displays are the same size.");
        }
    }

    // Method to compare the sharpness
    public void compareSharpness(Display otherDisplay) {
        System.out.println("Comparing sharpness between " + this.model + " and " + otherDisplay.model + ":");
        if (this.ppi > otherDisplay.ppi) {
            System.out.println(this.model + " is sharper than " + otherDisplay.model + ".");
        } else if (this.ppi < otherDisplay.ppi) {
            System.out.println(otherDisplay.model + " is sharper than " + this.model + ".");
        } else {
            System.out.println("Both displays have the same sharpness.");
        }
    }

    // Method to compare both size and sharpness
    public void compareWithMonitor(Display otherDisplay) {
        System.out.println("Comparing both size and sharpness between " + this.model + " and " + otherDisplay.model + ":");
        compareSize(otherDisplay);
        compareSharpness(otherDisplay);
    }


}

