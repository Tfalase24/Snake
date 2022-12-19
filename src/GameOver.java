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
        graphics.drawString(("Score: " + GameMode.appleEaten), (GamePanel.SCREEN_WIDTH - fontMetrics.stringWidth("Score: " + GameMode.appleEaten)) / 2, graphics.getFont().getSize());

        graphics.setColor(Color.WHITE);
        graphics.setFont(new Font("Ink Free", Font.BOLD, 24));
        graphics.drawString(("Restart"), (GamePanel.SCREEN_WIDTH - fontMetrics.stringWidth("Restart")) / 2, 388);
        graphics.drawString(("Quit"), (GamePanel.SCREEN_WIDTH - fontMetrics.stringWidth("Quit")) / 2, 488);


        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.draw(restartGame);
        graphics2D.draw(quitGame);
    }

    public Rectangle restartGame = new Rectangle((GamePanel.SCREEN_WIDTH / 2) - 75, 350, 150, 76);
    public Rectangle quitGame = new Rectangle((GamePanel.SCREEN_WIDTH / 2) - 75, 450, 150, 76);

}
