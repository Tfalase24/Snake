import java.awt.*;
import java.util.Random;

public class OnePlayer extends GameMode {
    GamePanel gamePanel;
    Random random;
    int[] x = new int[GamePanel.GAME_UNITS];
    int[] y = new int[GamePanel.GAME_UNITS];

    public void checkCollisions() {
        for (int i = GamePanel.bodyParts; i > 0; i--) {
            if ((GamePanel.x[0] == GamePanel.x[i] && GamePanel.y[0] == GamePanel.y[i])) {
                GamePanel.State = GamePanel.STATE.GAMEOVER;
            }
        }

        if (GamePanel.x[0] < 0 || GamePanel.x[0] > GamePanel.SCREEN_WIDTH || GamePanel.y[0] < 0 || GamePanel.y[0] > GamePanel.SCREEN_HEIGHT) {
            GamePanel.State = GamePanel.STATE.GAMEOVER;
        }
        if (!GamePanel.running) {
            GamePanel.timer.stop();
        }
    }

    @Override
    void newApple() {
        appleX = random.nextInt((int) (GamePanel.SCREEN_WIDTH / GamePanel.UNIT_SIZE)) * GamePanel.UNIT_SIZE;
        appleY = random.nextInt((int) (GamePanel.SCREEN_HEIGHT / GamePanel.UNIT_SIZE)) * GamePanel.UNIT_SIZE;

    }

    @Override
    public void drawMode(Graphics graphics) {
        for (int i = 0; i < GamePanel.SCREEN_HEIGHT / GamePanel.UNIT_SIZE; i++) {
            graphics.drawLine(i * GamePanel.UNIT_SIZE, 0, i * GamePanel.UNIT_SIZE, GamePanel.SCREEN_HEIGHT);
            graphics.drawLine(0, i * GamePanel.UNIT_SIZE, GamePanel.SCREEN_WIDTH, i * GamePanel.UNIT_SIZE);
        }
        graphics.setColor(Color.RED);
        graphics.fillOval(appleX, appleY, GamePanel.UNIT_SIZE, GamePanel.UNIT_SIZE);

        for (int i = 0; i < GamePanel.bodyParts; i++) {
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
        if ((x[0] == appleX && y[0] == appleY)) {
            System.out.println(appleX);
            System.out.println(appleY);
            bodyParts++;
            appleEaten++;
            // newApple();
        }

    }
}
