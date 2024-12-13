public class Drink{
    private String name;
    private double price;
    private boolean isCold;
    private boolean isEmpty;
      
    public Drink(String name, double price, boolean isCold, boolean isEmpty) {
        this.name = name;
        this.price = price;
        this.isCold = isCold;
        this.isEmpty = isEmpty;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCold(boolean isCold) {
        this.isCold = isCold;
    }

    public void setEmpty(boolean isEmpty) {
        this.isEmpty = isEmpty;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isCold() {
        return isCold;
    }

    public boolean isEmpty() {
        return isEmpty;
    }
}