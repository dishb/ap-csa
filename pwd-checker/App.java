import java.util.Scanner;

public class App  {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter your password: ");
        String input = sc.nextLine();
        sc.close();

        System.out.println("Your password's strength is: " + passChecker(input));
    }

    public static String passChecker(String x) {
        if(checkLen(x) && hasNum(x) && hasUpper(x) && hasLower(x) && hasSpecial(x)) {
            if(x.length() >= 12) {
                return "strong";
            } else {
                return "medium";
            }
        } else {
            return "weak";
        }
    }

    public static boolean checkLen(String x) {
        return x.length() >= 8;
    }

    public static boolean hasNum(String x) {
        if(
            (x.indexOf("0") != -1) || 
            (x.indexOf("1") != -1) ||
            (x.indexOf("2") != -1) ||
            (x.indexOf("3") != -1) ||
            (x.indexOf("4") != -1) ||
            (x.indexOf("5") != -1) ||
            (x.indexOf("6") != -1) ||
            (x.indexOf("7") != -1) ||
            (x.indexOf("8") != -1) ||
            (x.indexOf("9") != -1)
        ) {
            return true;
        }

        return false;
    }

    public static boolean hasUpper(String x){
        return !x.equals(x.toLowerCase());
    }

    public static boolean hasLower(String x) {
        return !x.equals(x.toUpperCase());
    } 
    
    public static boolean hasSpecial(String x) {
        if(
            (x.indexOf("!") != -1) || 
            (x.indexOf("@") != -1) ||
            (x.indexOf("#") != -1) ||
            (x.indexOf("$") != -1) ||
            (x.indexOf("%") != -1) ||
            (x.indexOf("^") != -1) ||
            (x.indexOf("&") != -1) ||
            (x.indexOf("*") != -1) ||
            (x.indexOf("(") != -1) ||
            (x.indexOf(")") != -1)
        ) {
            return true;
        }

        return false;
    }
}

