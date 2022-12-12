import java.awt.*;
import java.util.Arrays;

public class OnePlayer extends GameMode {

    static int bodyParts = 6;
    static int appleEaten = 0;

    @Override
    public void drawMode(Graphics graphics) {
        for (int i = 0; i < GamePanel.SCREEN_HEIGHT / GamePanel.UNIT_SIZE; i++) {
            graphics.drawLine(i * GamePanel.UNIT_SIZE, 0, i * GamePanel.UNIT_SIZE, GamePanel.SCREEN_HEIGHT);
            graphics.drawLine(0, i * GamePanel.UNIT_SIZE, GamePanel.SCREEN_WIDTH, i * GamePanel.UNIT_SIZE);
        }
        graphics.setColor(Color.RED);
        graphics.fillOval(GamePanel.appleX, GamePanel.appleY, GamePanel.UNIT_SIZE, GamePanel.UNIT_SIZE);

        for (int i = 0; i < bodyParts; i++) {
            if (i == 0) {
                graphics.setColor(Color.GREEN);
                graphics.fillRect(GamePanel.x[i], GamePanel.y[i], GamePanel.UNIT_SIZE, GamePanel.UNIT_SIZE);
            } else {
                graphics.setColor(new Color(45, 180, 0));
                graphics.fillRect(GamePanel.x[i], GamePanel.y[i], GamePanel.UNIT_SIZE, GamePanel.UNIT_SIZE);
            }
        }
        graphics.setColor(Color.RED);
        graphics.setFont(new Font("Ink Free", Font.BOLD, 24));
        FontMetrics fontMetrics = graphics.getFontMetrics(graphics.getFont());
        graphics.drawString(("Score: " + appleEaten), (GamePanel.SCREEN_WIDTH - fontMetrics.stringWidth("Score: " + appleEaten)) / 2, graphics.getFont().getSize());

    }



    @Override
    public void gameMove() {
        for (int i = bodyParts; i > 0; i--) {
            GamePanel.x[i] = GamePanel.x[i - 1];
            GamePanel.y[i] = GamePanel.y[i - 1];
        }
        switch (GamePanel.direction) {
            case 'U':
                GamePanel.y[0] = GamePanel.y[0] - GamePanel.UNIT_SIZE;
                break;
            case 'D':
                GamePanel. y[0] = GamePanel.y[0] + GamePanel.UNIT_SIZE;
                break;
            case 'L':
                GamePanel.x[0] = GamePanel.x[0] - GamePanel.UNIT_SIZE;
                break;
            case 'R':
                GamePanel. x[0] = GamePanel.x[0] + GamePanel.UNIT_SIZE;
                break;
        }

    }

    @Override
    public void eatApple() {
        if ((GamePanel.x[0] == GamePanel.appleX && GamePanel.y[0] == GamePanel.appleY)) {
            bodyParts++;
            appleEaten++;
            GamePanel.newApple();
        }

    }

    @Override
    void checkCollisions() {
        for (int i = bodyParts; i > 0; i--) {
            if ((GamePanel.x[0] == GamePanel.x[i] && GamePanel.y[0] == GamePanel.y[i])) {
                GamePanel.State = GamePanel.STATE.GAMEOVER;
                GamePanel.timer.stop();
            }
        }
        if (GamePanel.x[0] < 0 || GamePanel.x[0] > GameFunctionality.SCREEN_WIDTH || GamePanel.y[0] < 0 || GamePanel.y[0] > GameFunctionality.SCREEN_HEIGHT) {
            GamePanel.State = GamePanel.STATE.GAMEOVER;
            GamePanel.timer.stop();
        }
    }

    @Override
    void newGame() {
        GamePanel.State = GamePanel.STATE.GAME;
        appleEaten = 0;
        bodyParts = 6;
        GamePanel.newApple();
        GamePanel.running = true;
        Arrays.fill(GamePanel.x, 0);
        Arrays.fill(GamePanel.y, 0);
        GamePanel.direction = 'R';
        GamePanel.timer.start();
    }
}
