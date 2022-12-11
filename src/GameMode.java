import java.awt.*;
import java.util.Random;

public abstract class GameMode {
    public static int getBodyParts() {
        return bodyParts;
    }

    public static void setBodyParts(int bodyParts) {
        GameMode.bodyParts = bodyParts;
    }

    abstract void newApple();

    public static int bodyParts;
    public static int appleEaten;
    public static int appleX;
    public static int appleY;
    public static Random random;


    public static int getAppleEaten() {
        return appleEaten;
    }

    public static void setAppleEaten(int appleEaten) {
        GameMode.appleEaten = appleEaten;
    }

    abstract void drawMode(Graphics graphics);

    abstract void gameMove();

    abstract void eatApple();
}
