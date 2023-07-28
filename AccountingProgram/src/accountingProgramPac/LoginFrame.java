package accountingProgramPac;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/*
 * LoginFrame class for handling the login process
 */
class LoginFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginFrame() {
        setTitle("Login"); // Set the title of the frame
        setSize(300, 150); // Set the size of the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set the default close operation
        setLocationRelativeTo(null); // Center the frame on the screen

        JPanel panel = new JPanel(new GridLayout(2, 2)); // Create a panel with a 2x2 grid layout
        panel.add(new JLabel("Username:")); // Add a label for the username
        usernameField = new JTextField(); // Create a text field for entering the username
        panel.add(usernameField); // Add the username text field to the panel
        panel.add(new JLabel("Password:")); // Add a label for the password
        passwordField = new JPasswordField(); // Create a password field for entering the password
        panel.add(passwordField); // Add the password field to the panel

        JButton loginButton = new JButton("Login"); // Create a login button
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText(); // Get the entered username
                String password = new String(passwordField.getPassword()); // Get the entered password

                if (isValidUser(username, password)) { // Check if the user is valid
                    dispose(); // Close the login frame
                    SalesExpensesFrame salesExpensesFrame = new SalesExpensesFrame(); // Create an instance of the sales and expenses frame
                    salesExpensesFrame.setVisible(true); // Display the sales and expenses frame
                } else {
                    JOptionPane.showMessageDialog(LoginFrame.this, "Invalid username or password", "Login Error", JOptionPane.ERROR_MESSAGE); // Show an error message for invalid login
                }
            }
        });

        add(panel, BorderLayout.CENTER); // Add the panel to the frame's center
        add(loginButton, BorderLayout.SOUTH); // Add the login button to the frame's south
    }

    private boolean isValidUser(String username, String password) {
        // Add your username and password validation logic here
        return username.equals("admin") && password.equals("admin"); // Return true if the username and password are "admin"
    }
}
