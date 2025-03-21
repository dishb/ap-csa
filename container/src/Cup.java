public class Cup extends Container {
    private String material;
    private boolean broken;

    public Cup() {
        super();
        this.material = "unknown and use the parent's default";
        this.broken = false;
    }

    public Cup(String name, int capacityLevel, String material, boolean broken) {
        super(name, capacityLevel);
        this.material = material;
        this.broken = broken;
    }

    public void dump() {
        setCapacityLevel(0);
        for (int i = 0; i < things.size(); i++) {
            things.remove(i);
        }
        System.out.println("You  dumped  everything in your cup on the floor, that was rude.");
    }

    @Override
    public void insert(String thing, int capacity) {
        things.add(thing);
        capacityLevel += capacity;
        if (capacity > 100) {
            broken = true;
            System.out.println("The item broke.");
        }
        else {
            System.out.println("You filled your cup with " + thing);
        }
    }

    @Override
    public String toString() {
        if (broken) {
            return "This cup is broken, you are sad.";
        } else {
            return super.toString();
        }
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public boolean isBroken() {
        return broken;
    }

    public void setBroken(boolean broken) {
        this.broken = broken;
    }
}
