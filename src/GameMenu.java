import java.awt.*;

public class GameMenu {

    public void startScreen(Graphics graphics){
        graphics.setColor(Color.WHITE);
        graphics.setFont(new Font("Ink Free", Font.BOLD, 50));
        FontMetrics metrics = graphics.getFontMetrics(graphics.getFont());
        graphics.drawString(("Welcome to Snake"), (GamePanel.SCREEN_WIDTH - metrics.stringWidth("Welcome to Snake")) / 2, graphics.getFont().getSize());
    }
}
