package oop.Lab1.Task3;

class Display {
    private int width;
    private int height;
    private float ppi;
    private String model;

    // Constructors, setters, and getters are assumed to be defined here

    public Display(int width, int height, float ppi, String model) {
        this.width = width;
        this.height = height;
        this.ppi = ppi;
        this.model = model;
    }

    public void compareSize(Display other) {
        if (this.width * this.height > other.width * other.height) {
            System.out.println(this.model + " is bigger than " + other.model);
        } else if (this.width * this.height < other.width * other.height) {
            System.out.println(this.model + " is smaller than " + other.model);
        } else {
            System.out.println(this.model + " and " + other.model + " are the same size.");
        }
    }

    public void compareSharpness(Display other) {
        if (this.ppi > other.ppi) {
            System.out.println(this.model + " is sharper than " + other.model);
        } else if (this.ppi < other.ppi) {
            System.out.println(this.model + " is less sharp than " + other.model);
        } else {
            System.out.println(this.model + " and " + other.model + " have the same sharpness.");
        }
    }

    public void compareWithMonitor(Display other) {
        compareSize(other);
        compareSharpness(other);
    }

    public String getModel() {
        return model;
    }
}