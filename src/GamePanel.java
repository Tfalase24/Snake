import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener, GameFunctionality {


    static int appleX;
    static int appleY;
    static char direction = 'R';
    static boolean running = false;
    static Timer timer;
    static Random random;
    GameMenu menu = new GameMenu();
    GameOver gameOver = new GameOver();
    OnePlayer onePlayer = new OnePlayer();
    public static STATE State = STATE.MENU;

    public enum STATE{
        MENU,
        GAME,
        GAMEOVER
    }

    GamePanel() {
        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        this.addMouseListener(new MouseInput());
        timer = new Timer(DELAY, this);
        timer.start();
        }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        draw(graphics);
    }

    public void draw(Graphics graphics) {
        if(State == STATE.MENU){
            menu.startScreen(graphics);
        }
        else if (State == STATE.GAME) {
            while(!running) {
                startGame();
            }
            onePlayer.drawMode(graphics);
        } else {
            if(State == STATE.GAMEOVER)
            gameOver.gameOver(graphics);
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            running = false;
        }
    }

    public void startGame() {
        newApple();
        running = true;
    }

    public static void newApple() {
        appleX = random.nextInt((int) (SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
        appleY = random.nextInt((int) (SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;
        if(OnePlayer.appleEaten % 6 == 0 && OnePlayer.appleEaten != 0){

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (GamePanel.State == STATE.GAME) {
            onePlayer.gameMove();
            onePlayer.eatApple();
            onePlayer.checkCollisions();
        }
        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent keyEvent) {
            switch (keyEvent.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if (direction != 'R') {
                        direction = 'L';
                        break;
                    }
                case KeyEvent.VK_RIGHT:
                    if (direction != 'L') {
                        direction = 'R';
                        break;
                    }
                case KeyEvent.VK_UP:
                    if (direction != 'D') {
                        direction = 'U';
                        break;
                    }
                case KeyEvent.VK_DOWN:
                    if (direction != 'U') {
                        direction = 'D';
                        break;
                    }
            }
        }

    }
}