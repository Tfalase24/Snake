import java.awt.*;

public class GameOver {

    public void gameOver(Graphics graphics) {

        Graphics2D graphics2D = (Graphics2D) graphics;

        graphics.setColor(Color.RED);
        graphics.setFont(new Font("Ink Free", Font.BOLD, 40));
        FontMetrics metrics = graphics.getFontMetrics(graphics.getFont());
        graphics.drawString("Game Over ... You Lose", (GamePanel.SCREEN_WIDTH - metrics.stringWidth("Game Over ... You Lose")) / 2, (GamePanel.SCREEN_HEIGHT / 2) - 150);

        graphics.setColor(Color.RED);
        graphics.setFont(new Font("Ink Free", Font.BOLD, 24));
        FontMetrics fontMetrics = graphics.getFontMetrics(graphics.getFont());
        graphics.drawString(("Score: " + GamePanel.appleEaten), (GamePanel.SCREEN_WIDTH - fontMetrics.stringWidth("Score: " + GamePanel.appleEaten)) / 2, graphics.getFont().getSize());

        graphics.setColor(Color.WHITE);
        graphics.setFont(new Font("Ink Free", Font.BOLD, 24));
        FontMetrics fontMetrics2 = graphics.getFontMetrics(graphics.getFont());
        graphics.drawString(("Restart"), (GamePanel.SCREEN_WIDTH - fontMetrics2.stringWidth("Return to Menu")) / 2, 300);

        graphics.setColor(Color.WHITE);
        graphics.setFont(new Font("Ink Free", Font.BOLD, 24));
        FontMetrics fontMetrics3 = graphics.getFontMetrics(graphics.getFont());
        graphics.drawString(("Exit"), (GamePanel.SCREEN_WIDTH - fontMetrics3.stringWidth("Exit")) / 2, 450);

        graphics2D.draw(menubutton);
        graphics2D.draw(quitbutton);
    }

    public Rectangle menubutton = new Rectangle((GamePanel.SCREEN_WIDTH/2 - 100), 240, 200, 100);
    public Rectangle quitbutton = new Rectangle((GamePanel.SCREEN_WIDTH/2 - 100), 390, 200, 100);
}
