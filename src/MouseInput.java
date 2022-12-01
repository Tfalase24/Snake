import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;

public class MouseInput extends Component implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    GamePanel gamePanel;

    @Override
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        if (mx >= ((GamePanel.SCREEN_WIDTH / 2) - 100) && mx <= ((GamePanel.SCREEN_WIDTH / 2) + 100)) {
            if (my >= 150 && my <= 250) {
                GamePanel.State = GamePanel.STATE.GAME;
            }
        }
        if (mx >= ((GamePanel.SCREEN_WIDTH / 2) - 100) && mx <= ((GamePanel.SCREEN_WIDTH / 2) + 100)) {
            if (my >= 300 && my <= 400) {
                GamePanel.State = GamePanel.STATE.GAMEOVER;
            }
        }
        if (mx >= ((GamePanel.SCREEN_WIDTH / 2) - 100) && mx <= ((GamePanel.SCREEN_WIDTH / 2) + 100)) {
            if (my >= 450 && my <= 550) {
                System.exit(0);
            }
        }
    }
                @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
