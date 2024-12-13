public class App {
    public static void main(String[] args) {
        Drink gatorade = new Drink("Gatorade", 4.00, true, false);
        Drink cocaCola = new Drink("Coca-Cola", 3.00, true, false);
        Drink tea = new Drink("Tea", 2.00, false, true);
        Drink wine = new Drink("Wine", 10.00, true, true);
        Drink orangeJuice = new Drink("Orange Juice", 100.00, true, false);
        
        Drink[] drinks = new Drink[8];
        drinks[0] = gatorade;
        drinks[1] = cocaCola;
        drinks[2] = tea;
        drinks[3] = wine;
        drinks[4] = orangeJuice;    

        cheapItems(drinks);
        longNameSale(drinks);
        drinkAll(drinks);

        VenMac vendingMachine = new VenMac();

        vendingMachine.getDrink();
        vendingMachine.twoFor1();
    }

    public static String cheapItems(Drink[] arr) {
        String output = "The cheap drinks are:";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                if (arr[i].getPrice() < 3.00) {
                    output += " " + arr[i].getName();
                }
            }
        }

        if (output.equals("The cheap drinks are:")) {
            output += " none";
        }

        return output;
    }

    public static void longNameSale(Drink[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                if (arr[i].getName().length() > 7) {
                    arr[i].setPrice(arr[i].getPrice() / 2.0);
                }
            }
        }
    }

    public static void drinkAll(Drink[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                if (arr[i].isEmpty() == true) {
                    arr[i].setEmpty(false);
                }
            }
        }
    }
}
