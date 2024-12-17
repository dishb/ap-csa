import java.util.ArrayList;

public class VenMac {
    private ArrayList<Drink> stock;
    // Creates a list of drinks that the vending machine can hold.
    private String[] drinkNames = {"Coke", "Diet Coke", "Water", "Mountain Dew", "Iced Tea"};

    // Creates a vending machine and stocks it with a random amount of randomn drinks. At least 1 drink is added.
    public VenMac() {
        stock = new ArrayList<Drink>();
        
        // Range of "i" is 0 to 4, inclusive for both.
        for (int i = 0; i < (int)(Math.random() * 4 + 1); i++) {
            // The random price is any where from 1 to 4 dollars, inclusive both.
            double randPrice = Math.random() * 4 + 1;
            // The line below rounds a the randPrice variable to the nearest hundredth.
            double roundedPrice = (double)((int)(randPrice * 100)) / 100;
            // The line below gets a random index in the array of drink names so that we can get a random drink.
            int randIndex  = (int)(Math.random() * this.drinkNames.length);
            // The line below gets a random number from 1 to 4 so that we have a random quantity of each drink.
            int ranQuant = (int)(Math.random() * 3 + 1);
            for (int j = 0; j < ranQuant; j++) {
                // We add a random quantity of a random drink to our stock variable, an ArrayList that keeps track of drinks in the machine.
                this.stock.add(new Drink(this.drinkNames[randIndex], roundedPrice, true, true));
            }
        }
        
        // Prints out all the contents of our stock in a formatted manner. Includes price, name, and index in the stock variable.
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
