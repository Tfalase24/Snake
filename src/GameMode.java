import java.awt.*;
import java.util.Random;

public abstract class GameMode {



    public static int appleEaten;
    public static int bodyParts;

    abstract void drawMode(Graphics graphics);

    abstract void gameMove();

    abstract void eatApple();

    abstract void checkCollisions();

    abstract void newGame();
}
