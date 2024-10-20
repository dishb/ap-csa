import java.util.Scanner;
import kareltherobot.*;

public class JumpThoseHurdles {
	Robot hurdler = new Robot(1, 1, Directions.East, 0);
    int max_h = Integer.MIN_VALUE;
    int min_w = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		new JumpThoseHurdles().start();
	}

	public void start() {
		loadWorld();
		
		int w = 0;
    	int h = 0; 

        for (int i = 0; i < 3; i++) {
            w = findHurdle();

            h = clearHurdle();

            if ((w < min_w) && (i > 0)) {
                min_w = w;
            }

            if (h > max_h) {
                max_h = h;
            }
        }

        System.out.println("\nThe maximum height was " + max_h);
        System.out.println("\nThe minimum width was " + min_w);
	}

    public void turnRight(Robot r) {
        for (int i = 0; i < 3; i++) {
            r.turnLeft();
        }
    }

	private int findHurdle() {
        int i = 0;
		while (hurdler.frontIsClear()) {
            hurdler.move();
            i++;
        }

        return i;
	}

	private int climbHurdle() {
        int i = 0;
        while (!hurdler.frontIsClear()) {
            hurdler.turnLeft();
            hurdler.move();
            i++;
            turnRight(hurdler);
        }
        
		return i;
	}

	private int clearHurdle() {
		int temp = climbHurdle();

        hurdler.move();
        turnRight(hurdler);

        while (hurdler.frontIsClear()) {
            hurdler.move();
        }

        hurdler.turnLeft();

        return temp;
	}

	private void loadWorld() {
        Scanner s = new Scanner(System.in);
        System.out.println("\nPlease enter the name of a world file to load:\n");
        String worldName = s.nextLine();
        s.close();
        System.out.print("\n");

		World.readWorld(worldName);
		World.setVisible(true);
		World.setDelay(5);
	}
}
