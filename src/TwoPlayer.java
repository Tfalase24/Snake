import java.awt.*;

public class TwoPlayer extends GameMode{
    @Override
    void drawMode(Graphics graphics) {
        for (int i = 0; i < GamePanel.SCREEN_HEIGHT / GamePanel.UNIT_SIZE; i++) {
            graphics.drawLine(i * GamePanel.UNIT_SIZE, 0, i * GamePanel.UNIT_SIZE, GamePanel.SCREEN_HEIGHT);
            graphics.drawLine(0, i * GamePanel.UNIT_SIZE, GamePanel.SCREEN_WIDTH, i * GamePanel.UNIT_SIZE);
        }
        graphics.setColor(Color.RED);
        graphics.fillOval(GamePanel.appleX, GamePanel.appleY, GamePanel.UNIT_SIZE, GamePanel.UNIT_SIZE);


    }

    @Override
    void gameMove() {


    }

    @Override
    void eatApple() {

    }

    @Override
    void checkCollisions() {

    }

    @Override
    void throughWalls() {

    }

    @Override
    void eatApplePoison() {

    }

    @Override
    void eatGoldenApple() {

    }
}
