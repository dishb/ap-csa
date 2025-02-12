import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class App {
    private final int ROWS = 3;
    private final int COLS = 4;
    private JButton firstButton = null;
    private JButton secondButton = null;
    private int firstRow = -1;
    private int firstCol = -1;
    private int secondRow = -1;
    private int secondCol = -1;

    public static void main(String[] args) {
        new App();
    }

    App() {
        JFrame frame = new JFrame("\"Concentration\" by Dishant Bhandula");
        frame.setLayout(new GridLayout(ROWS, COLS));
        Board board = new Board(ROWS, COLS);

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                JButton button = new JButton();
                button.setText(board.gameboard[i][j].getHidden());
                final int row = i;
                final int col = j;

                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (firstButton == null && board.validateSelection(row, col)) {
                            firstButton = button;
                            firstRow = row;
                            firstCol = col;
                            board.showValue(row, col);
                            firstButton.setText(board.gameboard[row][col].getValue());
                        } else if (secondButton == null && button != firstButton && board.validateSelection(row, col)) {
                            secondButton = button;
                            secondRow = row;
                            secondCol = col;
                            board.showValue(row, col);
                            secondButton.setText(board.gameboard[row][col].getValue());
                            
                            if (board.checkForMatch(firstRow, firstCol, secondRow, secondCol) == "Match found.") {
                                Timer timer = new Timer(500, new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        board.gameboard[firstRow][firstCol].foundMatch();
                                        board.gameboard[secondRow][secondCol].foundMatch();
                                        firstButton.setText(board.gameboard[firstRow][firstCol].getValue());
                                        secondButton.setText(board.gameboard[secondRow][secondCol].getValue());
                                        firstButton = null;
                                        secondButton = null;
                                    }
                                });
                                timer.setRepeats(false);
                                timer.start();
                            } else {
                                Timer timer = new Timer(500, new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        firstButton.setText(board.gameboard[firstRow][firstCol].getHidden());
                                        secondButton.setText(board.gameboard[secondRow][secondCol].getHidden());
                                        firstButton = null;
                                        secondButton = null;
                                    }
                                });
                                timer.setRepeats(false);
                                timer.start();
                            }
                        }
                        if (board.allTilesMatch()) {
                            JOptionPane.showMessageDialog(frame, "Congratulations! You matched all the tiles!");
                            System.exit(0);
                        }
                    }
                });

                frame.add(button);
            }
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);;
        frame.setVisible(true);
    }
}
