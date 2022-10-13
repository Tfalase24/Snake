import javax.swing.*;

public class GameFrame extends JFrame {

    GameFrame(){

        this.add(new GamePanel());
        this.setTitle("SSSS I'm a SNAKEEEEE");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack(); // Takes the JFRAME and makes sure components fit snuggly around all of the components that have been added to the JFrame
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }
}
