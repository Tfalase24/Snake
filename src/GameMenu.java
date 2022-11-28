import java.awt.*;

public class GameMenu {

    public void startScreen(Graphics graphics){
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics.setColor(Color.WHITE);
        graphics.setFont(new Font("Ink Free", Font.BOLD, 50));
        FontMetrics metrics = graphics.getFontMetrics(graphics.getFont());
        graphics.drawString(("Welcome to Snake"), (GamePanel.SCREEN_WIDTH - metrics.stringWidth("Welcome to Snake")) / 2, graphics.getFont().getSize());
        graphics.drawString(("Start"), (GamePanel.SCREEN_WIDTH - metrics.stringWidth("Start")) / 2, 215);
        graphics.drawString(("Help"), (GamePanel.SCREEN_WIDTH - metrics.stringWidth("Help")) / 2, 365);
        graphics.drawString(("Quit"), (GamePanel.SCREEN_WIDTH - metrics.stringWidth("Quit")) / 2, 515);
        graphics2D.draw(playbutton);
        graphics2D.draw(helpbutton);
        graphics2D.draw(quitbutton);
    }

    public Rectangle playbutton = new Rectangle((GamePanel.SCREEN_WIDTH/2 - 100), 150, 200, 100);
    public Rectangle helpbutton = new Rectangle((GamePanel.SCREEN_WIDTH/2 - 100), 300, 200, 100);
    public Rectangle quitbutton = new Rectangle((GamePanel.SCREEN_WIDTH/2 - 100), 450, 200, 100);
}
