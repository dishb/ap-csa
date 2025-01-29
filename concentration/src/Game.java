import java.util.Scanner;

public class Game {
    private Scanner in = new Scanner(System.in);

    private Board board;
    private int row1, col1;
    private int row2, col2;

    public void play() {
        System.out.println("Welcome!");
        System.out.println("Select the tile locations you want to match,");
        System.out.println("or enter any non-integer character to quit.");
        System.out.println("(You will need to know 2D arrays to play!)");
        System.out.println("\nPress Enter to continue...");
        in.nextLine();

        board = new Board();
        while (!board.allTilesMatch()) {
                row1 = -1;
                col1 = -1;

            boolean validTile = false;
            while (!validTile) {
                displayBoard();
                System.out.print("First choice (row col): ");
                validTile = getTile(true); 
            }

            board.showValue(row1, col1);

            row2 = -1;
            col2 = -1;
            validTile = false;
            while (!validTile) {
                displayBoard();
                System.out.print("Second choice (row col): ");
                validTile = getTile(false);
            
                if ((row1 == row2) && (col1 == col2)) {
                    AudioPlayer.playSound("/Users/dishb/Documents/ap-csa/concentration/sounds/error.wav");
                    System.out.println("You mush choose a different second tile");
                    wait(2);
                    validTile = false;
                }
            }

            board.showValue(row2, col2);
            displayBoard();

            String matched = board.checkForMatch(row1, col1, row2, col2);
            System.out.println(matched);
            wait(2); 
        }
    
        displayBoard();
        System.out.println("Game Over!");
    }

    private boolean getTile(boolean firstChoice) {
        int num1 = 0;
        int num2 = 0;
    
        if (in.hasNextInt()) {
            num1 = in.nextInt();
        }
        else {
            quitGame();
        }

        if (in.hasNextInt()) {
            num2 = in.nextInt();
        }
        else {
            quitGame();
        }

        in.reset();

        if (!board.validateSelection(num1, num2)) {
            AudioPlayer.playSound("/Users/dishb/Documents/ap-csa/concentration/sounds/error.wav");
            System.out.print("Invalid input, please try again. ");
            wait(2);
            return false;
        }

        if (firstChoice) {
            row1 = num1;
            col1 = num2;
        } else {
            row2 = num1;
            col2 = num2;
        }

        AudioPlayer.playSound("/Users/dishb/Documents/ap-csa/concentration/sounds/blip.wav");
        return true;
    }

    public void displayBoard() {
        for (int x = 0; x < 50; x++) {
            System.out.println();
        }

        System.out.println(board);
    }

    private void wait(int n) {
        try {
            Thread.sleep(n * 1000);
        }   catch (InterruptedException e) { }
    }

    private void quitGame() {
        System.out.println("Quit game!");
        System.exit(0);
    }
}
