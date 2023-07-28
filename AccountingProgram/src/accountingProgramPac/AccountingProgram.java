package accountingProgramPac;

import javax.swing.*;

public class AccountingProgram {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                LoginFrame loginFrame = new LoginFrame(); // Create an instance of the login frame
                loginFrame.setVisible(true); // Display the login frame
            }
        });
    }
}
