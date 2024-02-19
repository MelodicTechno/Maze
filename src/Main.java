import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;
import java.io.Serial;

public class Main extends JFrame{
    @Serial
    private static final long serialVersionUID = 1L;

    public Main() {
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        Maze maze = new Maze();
        cp.add(maze);
        super.setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Maze");
        setVisible(true);
        System.out.println("everything is done");
    }
    public static void main(String[] args) {
        // 更改界面风格
        try {
            UIManager.setLookAndFeel( new FlatLightLaf() );
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize theme. Using fallback." );
        }
        SwingUtilities.invokeLater(Main::new);
    }
}
