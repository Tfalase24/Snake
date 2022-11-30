import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    GamePanel gamePanel;

    @Override
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        if(mx >= ((GamePanel.SCREEN_WIDTH/2) - 100) && mx <= ((GamePanel.SCREEN_WIDTH/2) + 100)){
            if (my >= 150 && my <= 250){
                System.out.println("this button works");
                GamePanel.State = GamePanel.STATE.GAME;
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
