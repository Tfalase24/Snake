import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {

    static final int SCREEN_WIDTH = 600; // width of the screen
    static final int SCREEN_HEIGHT = 600; // height of the screen
    static final int UNIT_SIZE = 25; // how big we want each individual unit in the screen
    static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE; // how many objects we can fit on the screen
    static final int DELAY = 75; // this variable is used in conjunction with the Timer class it is the initial and in-between time delay (in milliseconds) when action events are sent to the listener

    final int x[] = new int[GAME_UNITS]; // size of the snake will never be bigger than the number of the objects on the screen
    final int y[] = new int[GAME_UNITS]; // when you initialize the array, it sets the un-declared values to the default value of the array type (int = 0, double = 0.0, boolean = false). This value is set to the game-units because at most, there will never be more values in the array that fills more than every square, as each individual part of the snake can only fill up the whole screen
    int bodyParts = 6;  // Initial number of body parts for the snake
    int appleEaten = 0;  // Initial number of apples eaten
    int appleX;  // starting apple x coordinate, this value isn't set to final as it needs to be able to change
    int appleY;  // starting apple y coordinate

    char direction = 'R'; // Initial direction of snake
    boolean running = false;  // a switch to determine the state of the game
    Timer timer; // The timer class fires action events at a specified timer interval
    Random random;

    GamePanel() { // Game panel constructor, when creating an instance of the GamePanel class these are the details I want it to have
        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true); // Focus is the mechanism that determines which of the components in a window will receive keyboard input events
        this.addKeyListener(new MyKeyAdapter()); // The listener interface for receiving keyboard events.
        startGame(); // As soon as the object is initialized, the game will start

    }

    public void startGame() {
        newApple();
        running = true;
        timer = new Timer(DELAY, this); // Fires one or more ActionEvents at specified intervals (DELAY)
        timer.start(); // An event listener is designed to process some kind of event -- it listens for an event, e.g. user's mouse click or a key press, and then responds accordingly
        // An event listener must be connected to an event object that defines the event
    }

    public void paintComponent(Graphics graphics) { // The Graphics class is the abstract base class for all graphics contexts that allow an application to draw onto components that are realized on various devices, as well as onto off-screen images.
        super.paintComponent(graphics);
        draw(graphics);
    }

    public void draw(Graphics graphics) { // This method is to draw aspects in the game within our desired situations (if-statement and for-loops). It is the instance of the graphics class that uses the functions that actually puts stuff on the screen  
        if (running) {
            for (int i = 0; i < SCREEN_HEIGHT / UNIT_SIZE; i++) {
                graphics.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);
                graphics.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);
            }
            graphics.setColor(Color.RED);
            graphics.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);

            for (int i = 0; i < bodyParts; i++) {
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
            graphics.drawString(("Score: " + appleEaten), (SCREEN_WIDTH - fontMetrics.stringWidth("Score: " + appleEaten)) / 2, graphics.getFont().getSize());
        } else {
            gameOver(graphics);
        }
    }

    public void newApple() {
        appleX = random.nextInt((int) (SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
        appleY = random.nextInt((int) (SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;

    }

    public void move() {
        for (int i = bodyParts; i > 0; i--) {
            x[i] = x[i - 1]; // This for loop runs for every element in the array, for each array it assigns it the value of the element one prior in the array.
            y[i] = y[i - 1]; // As the zero index is given a new value, the one index value becomes the zero index value, second index value becomes first index value etc...
        }
        switch (direction) {
            case 'U':
                y[0] = y[0] - UNIT_SIZE; // y[0] is the y coordinate of the head of the snake, it reassigns the value at zero index
                break;
            case 'D':
                y[0] = y[0] + UNIT_SIZE;
                break;
            case 'L':
                x[0] = x[0] - UNIT_SIZE; // x[0] is the x coordinate of the head of the snake, it reassigns the value at zero index
                break;
            case 'R':
                x[0] = x[0] + UNIT_SIZE;
                break;
        }
    }

    public void checkCollisions() {
        // checks if head collides with body
        for (int i = bodyParts; i > 0; i--) {
            if ((x[0] == x[i] && y[0] == y[i])) {
                running = false;
            }
        }
        // checks if head touches the border
        if (x[0] < 0 || x[0] > SCREEN_WIDTH || y[0] < 0 || y[0] > SCREEN_HEIGHT) {
            running = false;
        }
        if (!running) {
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

    public void gameOver(Graphics graphics) {
        // Game-over text
        graphics.setColor(Color.RED);
        graphics.setFont(new Font("Ink Free", Font.BOLD, 40));
        FontMetrics metrics = getFontMetrics(graphics.getFont());
        graphics.drawString("Game Over ... You Lose", (SCREEN_WIDTH - metrics.stringWidth("Game Over ... You Lose")) / 2, SCREEN_HEIGHT / 2);

        graphics.setColor(Color.RED);
        graphics.setFont(new Font("Ink Free", Font.BOLD, 24));
        FontMetrics fontMetrics = getFontMetrics(graphics.getFont());
        graphics.drawString(("Score: " + appleEaten), (SCREEN_WIDTH - fontMetrics.stringWidth("Score: " + appleEaten)) / 2, graphics.getFont().getSize());
    }

    @Override
    public void actionPerformed(ActionEvent e) { // When an action is performed, if it is running it will move, check if an apple is eaten, and check for any collisions. Then it will repaint the window
        if (running) {
            move();
            checkApple();
            checkCollisions();
        }
        repaint(); // The repaint method is a final method used whenever we want to call update method along with the call to paint method
        // Call to update method clears the current window, performs an update, and afterwards call paint method
        // This method runs every time interval
    }

    public class MyKeyAdapter extends KeyAdapter { // An abstract adapter class for receiving keyboard events. The methods in this class are empty. This class exists as convenience for creating listener objects

        @Override
        public void keyPressed(KeyEvent keyEvent) { //invoked when a key is pressed
            switch (keyEvent.getKeyCode()) { // KeyEvent is, an event which indicates that a keystroke occurred in a component, the event is passed to every KeyListener or KeyAdapter object which registered to receive such events using the components addKeyListener method
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