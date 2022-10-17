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

    final int x [] = new int[GAME_UNITS]; // size of the snake will never be bigger than the number of the objects on the screen
    final int y [] = new int[GAME_UNITS];
    int bodyParts = 6;  // Initial number of body parts for the snake
    int appleEaten = 0;  // Initial number of apples eaten
    int appleX;  // starting apple x coordinate
    int appleY;  // starting apple y coordinate

    char direction = 'R'; // Initial direction of snake
    boolean running = false;  //
    Timer timer;
    Random random;

    GamePanel(){
        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();

    }

    public void startGame(){
        newApple();
        running = true;
        timer = new Timer(DELAY,this);
        timer.start();
    }

    public void paintComponent(Graphics graphics){ // The Graphics class is the abstract base class for all graphics contexts that allow an application to draw onto components that are realized on various devices, as well as onto off-screen images.
        super.paintComponent(graphics);
        draw(graphics);
    }

    public void draw(Graphics graphics){ // This method is to draw aspects in the game
        if(running){
        for(int i=0; i < SCREEN_HEIGHT / UNIT_SIZE; i++){
            graphics.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);
            graphics.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);
        }
        graphics.setColor(Color.RED);
        graphics.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);

        for(int i = 0; i < bodyParts; i++) {
            if (i == 0) {
                graphics.setColor(Color.GREEN);
                graphics.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
            } else {
                graphics.setColor(new Color(45, 180, 0));
                graphics.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
            }
        }
        graphics.setColor(Color.RED);
        graphics.setFont(new Font("Ink Free", Font.BOLD, 24));
        FontMetrics fontMetrics = getFontMetrics(graphics.getFont());
        graphics.drawString(("Score: " + appleEaten), (SCREEN_WIDTH - fontMetrics.stringWidth("Score: " + appleEaten)) / 2 , graphics.getFont().getSize() );
        } else {
            gameOver(graphics);
        }
    }

    public void newApple(){
        appleX = random.nextInt((int)(SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
        appleY = random.nextInt((int)(SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;

    }

    public void move(){
        for(int i = bodyParts; i > 0; i--){
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }
        switch(direction){
            case 'U':
                y[0] = y[0] - UNIT_SIZE; // y[0] is the y coordinate of the head of the snake
                break;
            case 'D':
                y[0] = y[0] + UNIT_SIZE;
                break;
            case 'L':
                x[0] = x[0] - UNIT_SIZE; // x[0] is the x coordinate of the head of the snake
                break;
            case 'R':
                x[0] = x[0] + UNIT_SIZE;
                break;
        }
    }

    public void checkCollisions(){
        // checks if head collides with body
        for(int i = bodyParts; i > 0; i--){
            if((x[0] == x[i] && y[0] == y[i])){
                running = false;
            }
        }
        // checks if head touches the border
        if(x[0] < 0 || x[0] > SCREEN_WIDTH || y[0] < 0 || y[0] > SCREEN_HEIGHT){
            running = false;
        }
        if(!running){
            timer.stop();
        }
    }

    public void checkApple(){
        if((x[0] == appleX && y[0] == appleY)){
            bodyParts++;
            appleEaten++;
            newApple();
        }

    }

    public void gameOver(Graphics graphics){
        // Game-over text
        graphics.setColor(Color.RED);
        graphics.setFont(new Font("Ink Free", Font.BOLD, 40));
        FontMetrics metrics = getFontMetrics(graphics.getFont());
        graphics.drawString("Game Over ... You Lose", (SCREEN_WIDTH - metrics.stringWidth("Game Over ... You Lose"))/2, SCREEN_HEIGHT / 2);

        graphics.setColor(Color.RED);
        graphics.setFont(new Font("Ink Free", Font.BOLD, 24));
        FontMetrics fontMetrics = getFontMetrics(graphics.getFont());
        graphics.drawString(("Score: " + appleEaten), (SCREEN_WIDTH - fontMetrics.stringWidth("Score: " + appleEaten)) / 2 , graphics.getFont().getSize());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(running){
            move();
            checkApple();
            checkCollisions();
        }
        repaint();

    }

    public class MyKeyAdapter extends KeyAdapter{

        @Override
        public void keyPressed(KeyEvent keyEvent){
            switch(keyEvent.getKeyCode()){
                case KeyEvent.VK_LEFT:
                    if(direction != 'R'){
                        direction = 'L';
                        break;
                    }
                case KeyEvent.VK_RIGHT:
                    if(direction != 'L'){
                        direction = 'R';
                        break;
                    }
                case KeyEvent.VK_UP:
                    if(direction != 'D'){
                        direction = 'U';
                        break;
                    }
                case KeyEvent.VK_DOWN:
                    if(direction != 'U'){
                        direction = 'D';
                        break;
                    }
            }
        }

    }
}
