import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    Graphics graphics;

    GameFrame(){

        this.add(new GamePanel());
        this.setTitle("SSSS I'm a SNAKEEEEE");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);


    }
}
