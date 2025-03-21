import java.util.ArrayList;;

public class Container {
    private String name;
    protected int capacityLevel;
    protected ArrayList<String> things = new ArrayList<String>();
    
    public Container() {
        this.name = "unknown";
        this.capacityLevel = 0;
    }

    public Container(String name, int capacityLevel) {
        this.name = name;
        this.capacityLevel = capacityLevel;
    }

    public void insert(String thing, int capacity) {
        capacityLevel += capacity;
        things.add(thing);
        System.out.println("You've added " + thing + " to the container, the capacity is now " + capacityLevel + "% full.");
    }

    public String itemsInside(boolean print) {
        String output = "";
        for (String thing : things) {
            output += thing + ", ";
        }

        if (output.length() > 0) {
            output = output.substring(0, output.length() - 2);
        }

        if (print) {
            System.out.println(output);
        }

        return output;
    }

    public String toString() {
        return "This is a " + name + " container, it is " + capacityLevel + "% full and contains: " + itemsInside(false);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacityLevel() {
        return capacityLevel;
    }

    public void setCapacityLevel(int capacityLevel) {
        this.capacityLevel = capacityLevel;
    }

    public ArrayList<String> getThings() {
        return things;
    }

    public void setThings(ArrayList<String> things) {
        this.things = things;
    }
}
