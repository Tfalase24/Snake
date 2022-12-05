import java.awt.*;

public class GameOver {

    GamePanel gamePanel;

    public void gameOver(Graphics graphics) {

        graphics.setColor(Color.RED);
        graphics.setFont(new Font("Ink Free", Font.BOLD, 40));
        FontMetrics metrics = graphics.getFontMetrics(graphics.getFont());
        graphics.drawString("Game Over ... You Lose", (GamePanel.SCREEN_WIDTH - metrics.stringWidth("Game Over ... You Lose")) / 2, GamePanel.SCREEN_HEIGHT / 2);

        graphics.setColor(Color.RED);
        graphics.setFont(new Font("Ink Free", Font.BOLD, 24));
        FontMetrics fontMetrics = graphics.getFontMetrics(graphics.getFont());
        graphics.drawString(("Score: " + GamePanel.appleEaten), (GamePanel.SCREEN_WIDTH - fontMetrics.stringWidth("Score: " + GamePanel.appleEaten)) / 2, graphics.getFont().getSize());

        graphics.setColor(Color.WHITE);
        graphics.setFont(new Font("Ink Free", Font.BOLD, 24));
        FontMetrics fontMetrics2 = graphics.getFontMetrics(graphics.getFont());
        graphics.drawString(("Restart"), (GamePanel.SCREEN_WIDTH - fontMetrics.stringWidth("Restart")) / 2, 388);


        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.draw(restartGame);
    }

    public Rectangle restartGame = new Rectangle((GamePanel.SCREEN_WIDTH / 2) - 75, 350, 150, 76);

}
