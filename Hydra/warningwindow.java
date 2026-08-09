import javax.swing.*;

public class warningwindow {
    public static boolean showWarning() {
        int choice = JOptionPane.showConfirmDialog(
            null,
            "This is a joke program\n\n" +
            "It might look dangerous but " +
            "pressing ALT+F4 or CMD+Q(mac) will kill the program\n\n" +
            "Do you want to start?",
            "Warning",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE
        );

        return choice == JOptionPane.YES_OPTION;
    }
}