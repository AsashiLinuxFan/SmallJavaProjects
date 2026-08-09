import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;

public class CPS {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Timer setup");
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setSize(500, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(2, 1));

        JPanel upper = new JPanel();
        upper.setLayout(new GridLayout(1, 2));

        JLabel seconds = new JLabel("Enter time (in seconds):");
        upper.add(seconds);

        JTextField secondsRegistered = new JTextField();
        upper.add(secondsRegistered);

        JButton start = new JButton("Start");
        frame.add(upper);
        frame.add(start);

        start.addActionListener(e -> {

            JFrame timer = new JFrame("Timer");
            timer.setLocationRelativeTo(null);
            timer.setResizable(false);
            timer.setSize(500, 600);
            timer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            timer.setLayout(new BorderLayout());

            double time = 0;

            try {
                time = Double.parseDouble(secondsRegistered.getText());
            } catch (NumberFormatException ex) {
                System.out.println("Invalid number");
                return;
            }

            JLabel timerT = new JLabel(String.valueOf(time), SwingConstants.CENTER);
            timerT.setFont(new Font("Arial", Font.BOLD, 48));
            timer.add(timerT, BorderLayout.CENTER);

            timer.setVisible(true);

            // BigDecimal setup
            final BigDecimal[] t = {BigDecimal.valueOf(time)};
            BigDecimal step = BigDecimal.valueOf(0.037);

            Thread countdownThread = new Thread(() -> {

                while (t[0].compareTo(BigDecimal.ZERO) > 0) {
                    try {
                        Thread.sleep(36);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }

                    t[0] = t[0].subtract(step);

                    BigDecimal current = t[0].max(BigDecimal.ZERO);

                    SwingUtilities.invokeLater(() ->
                        timerT.setText(current.toPlainString())
                    );
                }

                SwingUtilities.invokeLater(() ->
                    timerT.setText("ITS TIME!")
                );
            });

            countdownThread.start();
        });

        frame.setVisible(true);
    }
}
