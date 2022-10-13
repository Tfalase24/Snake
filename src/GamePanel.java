import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {

    static final int SCREEN_WIDTH = 600; // size of the screen
    static final int SCREEN_HEIGHT = 600; // height of the screen
    static final int UNIT_SIZE = 25; // how big we want the objects in the game
    static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT)/UNIT_SIZE; // how many objects we can fit on the screen
    static final int DELAY = 75;

    GamePanel(){

    }

    public void startGame(){

    }

    public void paintComponent(Graphics graphics){ // The Graphics class is the abstract base class for all graphics contexts that allow an application to draw onto components that are realized on various devices, as well as onto off-screen images.

    }

    public void draw(Graphics graphics){

    }

    public void move(){

    }

    public void checkApple(){

    }

    public void gameOver(Graphics graphics){

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public class MyKeyAdapter extends KeyAdapter{

        @Override
        public void keyPressed(KeyEvent keyEvent){

        }

    }
}
