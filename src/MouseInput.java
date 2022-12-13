import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput extends Component implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        switch (GamePanel.State){
            case MENU:
                if (mx >= ((GamePanel.SCREEN_WIDTH / 2) - 100) && mx <= ((GamePanel.SCREEN_WIDTH / 2) + 100)) {
                    if (my >= 150 && my <= 250) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                        GamePanel.State = GamePanel.STATE.GAME;
                    }
                }
                if (mx >= ((GamePanel.SCREEN_WIDTH / 2) - 100) && mx <= ((GamePanel.SCREEN_WIDTH / 2) + 100)) {
                    if (my >= 300 && my <= 400) {

                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                        GamePanel.State = GamePanel.STATE.GAMEOVER;
                    }
                }
                if (mx >= ((GamePanel.SCREEN_WIDTH / 2) - 100) && mx <= ((GamePanel.SCREEN_WIDTH / 2) + 100)) {
                    if (my >= 450 && my <= 550) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                        System.exit(0);
                    }
                }
            case GAMEOVER:
                if((mx >= (GamePanel.SCREEN_WIDTH / 2) - 75) && (mx <= (GamePanel.SCREEN_WIDTH / 2) + 75)) {
                    if (my >= 350 && my <= 426) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                        GameMode.newGame();
                    }
                }
                if ((mx >= (GamePanel.SCREEN_WIDTH / 2) - 75) && (mx <= (GamePanel.SCREEN_WIDTH / 2) + 75)) {
                    if (my >= 450 && my <= 526) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                        System.exit(0);
                    }
                }
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

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
