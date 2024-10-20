// import javax.swing.*;
// import java.awt.event.*;
import kareltherobot.*;

public class App implements Directions {
    public static void main(String[] args) throws Exception{
        World.setDelay(3);
        World.setVisible(true);
        World.setSize(10, 10);

        Robot emojiBot = new Robot(5, 2, East, 39);
        
        makeBox(emojiBot);
        for (int i =  0; i < 4; i++) { emojiBot.move(); }
        makeBox(emojiBot);
        turnRight(emojiBot);
        for (int i =  0; i < 3; i++) { emojiBot.move(); }
        emojiBot.turnLeft();
        for (int i =  0; i < 2; i++) { emojiBot.move(); }
        for (int i =  0; i < 2; i++) { turnRight(emojiBot); }
        moveBeepX(emojiBot, 7);
    }

    public static void turnRight (Robot emojiBot) {
        for (int i = 0; i < 3; i++) {
            emojiBot.turnLeft();
        }
    }

    public static void moveBeepX (Robot emojiBot, int x) {
        for (int i = 0; i < x; i++) {
            emojiBot.putBeeper();
            emojiBot.move();
        }
    }

    public static void makeBox (Robot emojiBot) {
        moveBeepX(emojiBot, 2);
        emojiBot.turnLeft();

        moveBeepX(emojiBot, 3);
        emojiBot.turnLeft();

        moveBeepX(emojiBot, 2);
        emojiBot.turnLeft();

        moveBeepX(emojiBot, 3);
        emojiBot.turnLeft();
    }
}
