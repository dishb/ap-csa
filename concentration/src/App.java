import javax.swing.*;
import java.awt.*;

public class App {
    private final int ROWS = 3;
    private final int COLS = 4;

    App() {
        JFrame frame = new JFrame("\"Concentration\" by Dishant Bhandula");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 700);
        frame.setLayout(new GridLayout(ROWS, COLS));

        Board board = new Board(ROWS, COLS);
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                JButton button = new JButton();
                button.setText(board.gameboard[i][j].getHidden());
                frame.add(button);
            }
        }

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new App();
    }
}
