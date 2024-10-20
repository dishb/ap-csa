import java.util.Scanner;

public class App {
    // The following 2 variables are instance variables.
    // We create a variable of type integer called 'max'. It is
    // set to the minimum value of the 'Integer' data type, which is -2,147,483,648
    static int max = Integer.MIN_VALUE;
    // Create a new variable of type integer called 'num'. Set it to 0.
    static int num = 0;

    public static void main(String[] args) throws Exception {
        askMax(); // Call the 'askMax' function.
    }

    public static void askMax() { // Define the 'askMax' function.
        while(num != 962024){
            // Create a scanner to recieve user input in the terminal.
            Scanner sc = new Scanner(System.in);
            // Print the text inside the quotation marks to the terminal.
            System.out.println("Enter a integer, type 962024 to end the loop");
            // Try to find the first integer typed by the user.
            try {
                num = sc.nextInt();
            } // If it fails and raises any type of error, print the text inside the quotation marks.
            catch(Exception e) {
                System.out.println("That is not a valid input.");
            }
            sc.close();

            if(num > max) { // If the number is greater than the max, we set the max to the number.
                max = num;
                System.out.println("The new max is "+ max + "\n\n"); // Print out what the new max is.
            }
            else {
                // If the number is not greater than the existing max, print out text saying the
                // 'num' variable is less than the 'max' variable.
                System.out.println(num + " is not larger than the old max of " + max + "\n\n");
                break; // This break statement will end the while loop.
            }
        }
    }
}
