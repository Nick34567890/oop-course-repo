package oop.Lab1.Task3;


public class Main3 {
    public static void main(String[] args) {
        Display display1 = new Display(1920, 1080, 401, "Part A");
        Display display2 = new Display(2560, 1440, 530, "Part B");
        Display display3 = new Display(3840, 2160, 220, "Part C");

        Assistant assistant = new Assistant("Display Assistant");

        // Assign displays to the assistant
        assistant.assignDisplay(display1);
        assistant.assignDisplay(display2);
        assistant.assignDisplay(display3);
        System.out.println("\n");
        // Assist with comparisons
        assistant.assist();
        System.out.println("\n");
        // Buy a display
        assistant.buyDisplay(display2);

        // Display remaining comparisons after buying one
        assistant.assist();
        System.out.println("\n");
    }
}

