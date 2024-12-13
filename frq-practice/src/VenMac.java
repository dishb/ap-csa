import java.util.ArrayList;

public class VenMac {
    private ArrayList<Drink> stock;
    private String[] drinkNames = {"Coke", "Diet Coke", "Water", "Mountain Dew", "Iced Tea"};

    public VenMac() {
        stock = new ArrayList<Drink>();
    
        for (int i = 0; i < (int)(Math.random() * 4 + 1); i++) {
            double randPrice = Math.random() * 4 + 1;
            double roundedPrice = (double)((int)(randPrice * 100)) / 100;
            int randIndex  = (int)(Math.random() * this.drinkNames.length);
            int ranQuant = (int)(Math.random() * 3 + 1);
            for (int j = 0; j < ranQuant; j++) {
                this.stock.add(new Drink(this.drinkNames[randIndex], roundedPrice, true, true));
            }
        }
        
        listContents();
    }

    public void listContents() {
        for (int i = 0; i < this.stock.size(); i++) {
            System.out.println("|Item #: " + i + "| Item name: " + this.stock.get(i).getName() + "| Price: " + this.stock.get(i).getPrice());
        }
    }

    public Drink getDrink() {
        int randIndex = (int)(Math.random() * this.stock.size());
        return this.stock.remove(randIndex);
    }

    public String twoFor1() {
        String output = "You got ";
        int randIndex = (int)(Math.random() * this.stock.size());
        if (this.stock.size() > 0) {
            output += this.stock.get(randIndex).getName();
            if (randIndex < this.stock.size() - 1) {
                output += " and " + this.stock.get(randIndex + 1).getName();
            }
        } else {
            output += "nothing, we are out of stock!";
        }

        return output;
    }

}