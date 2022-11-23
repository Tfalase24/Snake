import java.awt.*;

public class GameOver {
    public void gameOver(Graphics graphics) {

        graphics.setColor(Color.RED);
        graphics.setFont(new Font("Ink Free", Font.BOLD, 40));
        FontMetrics metrics = graphics.getFontMetrics(graphics.getFont());
        graphics.drawString("Game Over ... You Lose", (GamePanel.SCREEN_WIDTH - metrics.stringWidth("Game Over ... You Lose")) / 2, GamePanel.SCREEN_HEIGHT / 2);

        graphics.setColor(Color.RED);
        graphics.setFont(new Font("Ink Free", Font.BOLD, 24));
        FontMetrics fontMetrics = graphics.getFontMetrics(graphics.getFont());
        graphics.drawString(("Score: " + GamePanel.appleEaten), (GamePanel.SCREEN_WIDTH - fontMetrics.stringWidth("Score: " + GamePanel.appleEaten)) / 2, graphics.getFont().getSize());
    }
}
