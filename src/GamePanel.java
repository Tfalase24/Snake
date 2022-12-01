import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {

    final static int SCREEN_WIDTH = 600;
    final static int SCREEN_HEIGHT = 600;
    final static int UNIT_SIZE = 25;
    final static int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE;
    final int DELAY = 75;

    final static int x[] = new int[GAME_UNITS];
    final static int y[] = new int[GAME_UNITS];
    static int bodyParts = 6;
    static int appleEaten = 0;
    static int appleX;
    static int appleY;
    static char direction = 'R';
    static boolean running = false;
    static Timer timer;
    Random random;
    Graphics graphics;
    GameMenu menu = new GameMenu();
    GameOver gameOver = new GameOver();
    OnePlayer onePlayer = new OnePlayer();
    public static STATE State = STATE.MENU;

    public void setRunning(boolean running) {
        this.running = running;
    }

    public boolean isRunning() {
        return running;
    }

    public Random getRandom() {
        return random;
    }

    public char getDirection() {
        return direction;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    public int getBodyParts() {
        return bodyParts;
    }

    public void setBodyParts(int bodyParts) {
        this.bodyParts = bodyParts;
    }

    public int getAppleX() {
        return appleX;
    }

    public void setAppleX(int appleX) {
        this.appleX = appleX;
    }

    public int getAppleY() {
        return appleY;
    }

    public void setAppleY(int appleY) {
        this.appleY = appleY;
    }

    public int getAppleEaten() {
        return appleEaten;
    }

    public void setAppleEaten(int appleEaten) {
        this.appleEaten = appleEaten;
    }

    public int getSCREEN_WIDTH() {
        return SCREEN_WIDTH;
    }

    public int getSCREEN_HEIGHT() {
        return SCREEN_HEIGHT;
    }

    public int getUNIT_SIZE() {
        return UNIT_SIZE;
    }

    public STATE getState() {
        return State;
    }

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
            onePlayer.OnePlayerMode(graphics);
            while(!running) {
                startGame();
            }
        } else {
            if(State == STATE.GAMEOVER)
            gameOver.gameOver(graphics);
        }
    }

    public void startGame() {
        newApple();
        running = true;
      /*  timer = new Timer(DELAY, this);
        timer.start();*/
    }

    public void newApple() {
        appleX = random.nextInt((int) (SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
        appleY = random.nextInt((int) (SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;

    }

    public void checkCollisions() {

        for (int i = bodyParts; i > 0; i--) {
            if ((x[0] == x[i] && y[0] == y[i])) {
                State = STATE.GAMEOVER;
            }
        }
        if (x[0] < 0 || x[0] > SCREEN_WIDTH || y[0] < 0 || y[0] > SCREEN_HEIGHT) {
            State = STATE.GAMEOVER;
        }
        if (State == STATE.GAMEOVER) {
            timer.stop();
        }
    }

    public void checkApple() {
        if ((x[0] == appleX && y[0] == appleY)) {
            bodyParts++;
            appleEaten++;
            newApple();
        }

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            onePlayer.move();
            checkApple();
            checkCollisions();
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