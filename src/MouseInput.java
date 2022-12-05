import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput extends Component implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

        int mx = e.getX();
        int my = e.getY();

        if(GamePanel.State == GamePanel.STATE.GAMEOVER){
            if(mx >= ((GamePanel.SCREEN_WIDTH / 2) - 100) && mx <= ((GamePanel.SCREEN_WIDTH / 2) + 100)){
                if (my >= 240 && my <= 340) {
                    System.out.println(GamePanel.State);
                    GamePanel.State = GamePanel.STATE.MENU;
                }
            }
        }

        if (GamePanel.State == GamePanel.STATE.MENU) {
            if (mx >= ((GamePanel.SCREEN_WIDTH / 2) - 100) && mx <= ((GamePanel.SCREEN_WIDTH / 2) + 100)) {
                if (my >= 150 && my <= 250) {
                    System.out.println("This button should start the game");
                    GamePanel.State = GamePanel.STATE.GAME;
                    GamePanel.running = true;
                }
            }
        }
        if (mx >= ((GamePanel.SCREEN_WIDTH / 2) - 100) && mx <= ((GamePanel.SCREEN_WIDTH / 2) + 100)) {
            if (my >= 300 && my <= 400) {
                GamePanel.State = GamePanel.STATE.GAMEOVER;
                GamePanel.running = true;
                System.out.println("This button is working to change the state from MENU to GAMEOVER");

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
