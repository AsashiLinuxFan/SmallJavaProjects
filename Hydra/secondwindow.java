import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class secondwindow {
    public static void createwindows() {
        JFrame frame = new JFrame("Hydra");
        frame.setSize(400, 400);
        frame.setLayout(new BorderLayout());
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel text = new JLabel("Cut a head, two more appear");
        text.setHorizontalAlignment(SwingConstants.CENTER);  
        text.setVerticalAlignment(SwingConstants.CENTER);  
        text.setFont(new Font("Georgia", Font.BOLD, 20)); 
        frame.add(text, BorderLayout.CENTER);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                for (int i = 0; i != 2; i++) {
                    secondwindow.createwindows();
                }
            }
        });

        // RANDOM LOCATION
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int)(Math.random() * (screen.width - frame.getWidth()));
        int y = (int)(Math.random() * (screen.height - frame.getHeight()));
        frame.setLocation(x, y);

        frame.setVisible(true);
    }
}
