import kareltherobot.*;

public class Main implements Directions {
    public static void main(String[] args) {
        // Changed semi-colons to commas to seperate arguments.
        // Changed starting position.
        // Gave 'fred' more beepers.
        Robot fred = new Robot(2, 2, East, 13);
        World.setVisible(true);
		World.setSize(15, 15);
		World.setDelay(5);

        // Added the keyword 'int' when defining the variable 'i'. Added semi-colons to seperate expressions.
		for(int i = 0; i < 5; i++) {
			fred.move();
			fred.putBeeper();
		}

		makeVertical(fred);

		turnRight(fred);

        // Added 'int' keyword.
		for(int i = 0; i < 4; i++) {
            // Changed 'fres' to 'fred'.
			fred.move();
			fred.putBeeper();
		}
    // Added curly braces to close the main method block.
    }

    // Changed spelling of 'makeVertacal' to 'makeVertical'.
	public static void makeVertical(Robot wilma) {
        // Changed all instances of 'fred' to 'wilma' in this function.
		wilma.turnLeft();
		for (int i = 0; i < 4; i++) {
			wilma.move();
			wilma.putBeeper();
		}
	}

    // Add 'Robot' keyword when defining the type for a parameter.
	public static void turnRight(Robot fred) {
        // Changed 'i += 2' to 'i++' to turn left 3 times.
		for(int i = 0; i < 3; i++) {
            // Called method 'turnLeft' on 'fred'.
			fred.turnLeft();
		}
	// Added curly braces to close 'turnRight' function block.
    }
}
