import java.awt.*;

public class OnePlayer extends GameMode {

    static int bodyParts = 6;
    static int appleEaten = 0;

    @Override
    public void drawMode(Graphics graphics) {
        for (int i = 0; i < GamePanel.SCREEN_HEIGHT / GamePanel.UNIT_SIZE; i++) {
            graphics.drawLine(i * GamePanel.UNIT_SIZE, 0, i * GamePanel.UNIT_SIZE, GamePanel.SCREEN_HEIGHT);
            graphics.drawLine(0, i * GamePanel.UNIT_SIZE, GamePanel.SCREEN_WIDTH, i * GamePanel.UNIT_SIZE);
        }
        if (GameMode.appleEaten % 6 == 0 && GameMode.appleEaten != 0) {
            graphics.setColor(Color.YELLOW);
        } else {
            graphics.setColor(Color.RED);
        }
        graphics.fillOval(GamePanel.appleX, GamePanel.appleY, GamePanel.UNIT_SIZE, GamePanel.UNIT_SIZE);

        for (int i = 0; i < GameMode.bodyParts; i++) {
            if (i == 0) {
                graphics.setColor(Color.GREEN);
                graphics.fillRect(GamePanel.x[i], GamePanel.y[i], GamePanel.UNIT_SIZE, GamePanel.UNIT_SIZE);
            } else {
                graphics.setColor(new Color(45, 0, 180));
                graphics.fillRect(GamePanel.x[i], GamePanel.y[i], GamePanel.UNIT_SIZE, GamePanel.UNIT_SIZE);
            }
        }
        graphics.setColor(Color.RED);
        graphics.setFont(new Font("Ink Free", Font.BOLD, 24));
        FontMetrics fontMetrics = graphics.getFontMetrics(graphics.getFont());
        graphics.drawString(("Score: " + GameMode.appleEaten), (GamePanel.SCREEN_WIDTH - fontMetrics.stringWidth("Score: " + GameMode.appleEaten)) / 2, graphics.getFont().getSize());

    }



    @Override
    public void gameMove() {
        for (int i = GameMode.bodyParts; i > 0; i--) {
            GameFunctionality.x[i] = GameFunctionality.x[i - 1];
            GameFunctionality.y[i] = GameFunctionality.y[i - 1];
        }
        switch (GamePanel.direction) {
            case 'U':
                GameFunctionality.y[0] = GameFunctionality.y[0] - GameFunctionality.UNIT_SIZE;
                break;
            case 'D':
                GameFunctionality. y[0] = GameFunctionality.y[0] + GameFunctionality.UNIT_SIZE;
                break;
            case 'L':
                GameFunctionality.x[0] = GameFunctionality.x[0] - GameFunctionality.UNIT_SIZE;
                break;
            case 'R':
                GameFunctionality.x[0] = GameFunctionality.x[0] + GameFunctionality.UNIT_SIZE;
                break;
        }

    }

    @Override
    public void eatApple() {
        if ((GameFunctionality.x[0] == GamePanel.appleX && GameFunctionality.y[0] == GamePanel.appleY)) {
            GameMode.bodyParts++;
            GameMode.appleEaten++;
            GamePanel.newApple();
        }

    }

    @Override
    void checkCollisions() {
        for (int i = GameMode.bodyParts; i > 0; i--) {
            if ((GameFunctionality.x[0] == GameFunctionality.x[i] && GameFunctionality.y[0] == GameFunctionality.y[i])) {
                GamePanel.State = GamePanel.STATE.GAMEOVER;
                GamePanel.timer.stop();
            }
        }
        if (GameFunctionality.x[0] < 0 || GameFunctionality.x[0] == GameFunctionality.SCREEN_WIDTH || GameFunctionality.y[0] < 0 || GameFunctionality.y[0] == GameFunctionality.SCREEN_HEIGHT) {
            GamePanel.State = GamePanel.STATE.GAMEOVER;
            GamePanel.timer.stop();
        }
    }

    @Override
    void throughWalls() {
        for (int i = GameMode.bodyParts; i > 0; i--) {
            if ((GameFunctionality.x[0] == GameFunctionality.x[i] && GameFunctionality.y[0] == GameFunctionality.y[i])) {
                GamePanel.State = GamePanel.STATE.GAMEOVER;
                GamePanel.timer.stop();
            }
        }
        if(GameFunctionality.x[0] < 0){
            GameFunctionality.x[0] = GameFunctionality.SCREEN_WIDTH - GameFunctionality.UNIT_SIZE;
        }
        if(GameFunctionality.x[0] == GameFunctionality.SCREEN_WIDTH){
            GameFunctionality.x[0] = 0;
        }
        if(GameFunctionality.y[0] < 0){
            GameFunctionality.y[0] = GameFunctionality.SCREEN_HEIGHT - GameFunctionality.UNIT_SIZE;
        }
        if(GameFunctionality.y[0] == GameFunctionality.SCREEN_HEIGHT){
            GameFunctionality.y[0] = 0;
        }
    }

    @Override
    void eatApplePoison() {

    }

    @Override
    void eatGoldenApple() throws InterruptedException {
        if ((GameFunctionality.x[0] == GamePanel.appleX && GameFunctionality.y[0] == GamePanel.appleY && appleEaten % 6 == 0 && appleEaten != 0)){
           GameMode.bodyParts++;
           GameMode.appleEaten = GameMode.appleEaten + 3;
           Thread.sleep(5000);
           GamePanel.newApple();
        }

    }

}
