import java.awt.*;
import java.util.Arrays;
import java.util.Random;

public abstract class GameMode {



    public static int appleEaten = 0;
    public static int bodyParts = 6;

    abstract void drawMode(Graphics graphics);

    abstract void gameMove();

    abstract void eatApple();

    abstract void checkCollisions();

    abstract void throughWalls();

    static void newGame() {
        GamePanel.State = GamePanel.STATE.GAME;
        appleEaten = 0;
        bodyParts = 6;
        GamePanel.newApple();
        GamePanel.running = true;
        Arrays.fill(GameFunctionality.x, 0);
        Arrays.fill(GameFunctionality.y, 0);
        GamePanel.direction = 'R';
        GamePanel.timer.start();
    }
}
