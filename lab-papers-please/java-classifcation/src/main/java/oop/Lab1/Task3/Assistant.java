package oop.Lab1.Task3;
import java.util.ArrayList;
import java.util.List;

class Assistant {
    private String assistantName;
    private List<Display> assignedDisplays;

    public Assistant(String assistantName) {
        this.assistantName = assistantName;
        this.assignedDisplays = new ArrayList<>();
    }

    public void assignDisplay(Display d) {
        assignedDisplays.add(d);
        System.out.println("Assigned " + d.getModel() + " to " + assistantName);
    }

    public void assist() {
        if (assignedDisplays.size() < 2) {
            System.out.println("Not enough displays to compare.");
            return;
        }

        for (int i = 0; i < assignedDisplays.size() - 1; i++) {
            Display current = assignedDisplays.get(i);
            Display next = assignedDisplays.get(i + 1);
            System.out.println("Comparing " + current.getModel() + " with " + next.getModel() + ":");
            current.compareWithMonitor(next);
        }
    }

    public Display buyDisplay(Display d) {
        if (assignedDisplays.remove(d)) {
            System.out.println(d.getModel() + " has been bought and removed from the assistant's list.");
            return d;
        } else {
            System.out.println("Display " + d.getModel() + " is not in the list.");
            return null;
        }
    }
}
