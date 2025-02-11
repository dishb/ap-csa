import java.util.ArrayList;

public class Board {  
    private static String[] tileValues = {"lion", "lion",
                                          "penguin", "penguin",
                                          "dolphin", "dolphin",
                                          "fox", "fox",
                                          "monkey", "monkey",
                                          "turtle", "turtle"
                                          }; 
    private ArrayList<Tile> tileValuesList = new ArrayList<Tile>();
    public Tile[][] gameboard;

    public Board(int rows, int cols) {
        gameboard = new Tile[rows][cols];

        for (String value : tileValues) {
            tileValuesList.add(new Tile(value));
        }

        for (int i = 0; i < gameboard.length; i++) {
            for (int j = 0; j < gameboard[0].length; j++) {
                int randomTile = (int) (Math.random() * tileValuesList.size());
                gameboard[i][j] = new Tile(tileValuesList.remove(randomTile).getValue());
            }
        }
    }

    public String toString() {
        String boardString = "";

        for (Tile[] row : gameboard) {
            for (Tile tile : row) {
                if (tile.isShowingValue()) {
                    boardString += tile.getValue() + " ";
                } else {
                    boardString += tile.getHidden() + " ";
                }
            }
            boardString += "\n";
        }

        return boardString;
    }

    public boolean allTilesMatch() {
        for (Tile[] row : gameboard) {
            for (Tile tile : row) {
                if (tile.matched() == false) {
                    return false;
                }
            }
        }

        return true;
    }

    public void showValue (int row, int col) {
        gameboard[row][col].show();
    }  

    public String checkForMatch(int row1, int col1, int row2, int col2) {
        String msg = "No match found.";

        if (gameboard[row1][col1].getValue().equals(gameboard[row2][col2].getValue())) {
            gameboard[row1][col1].foundMatch();
            gameboard[row2][col2].foundMatch();
            msg = "Match found.";
        } else {
            gameboard[row1][col1].hide();
            gameboard[row2][col2].hide();
        }

        if (msg.equals("No match found.")) {
            AudioPlayer.playSound("/Users/dishb/Documents/ap-csa/concentration/sounds/error.wav");
        }

        return msg;
    }

    public boolean validateSelection(int row, int col) {
        if (row < 0 || row >= gameboard.length || col < 0 || col >= gameboard[0].length) {
            return false;
        }

        if (gameboard[row][col].matched()) {
            return false;
        }

        return true;
    }
}
