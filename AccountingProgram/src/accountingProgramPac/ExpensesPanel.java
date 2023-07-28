package accountingProgramPac;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
/*
 * ExpensesPanel class for handling the UI components and logic for entering expenses
 */
public class ExpensesPanel {

    private JTextArea expensesTextArea;

    public ExpensesPanel() {
        expensesTextArea = new JTextArea(10, 30); // Create a text area for entering expenses
    }

    public JPanel getPanel() {
        JPanel panel = new JPanel(new BorderLayout()); // Create a panel with a border layout
        panel.setBorder(BorderFactory.createTitledBorder("Enter Expenses")); // Set a titled border for the panel

        JScrollPane scrollPane = new JScrollPane(expensesTextArea); // Create a scroll pane for the expenses text area
        panel.add(scrollPane); // Add the scroll pane to the panel

        return panel; // Return the panel
    }

    public double[] getExpenses() {
        String expensesText = expensesTextArea.getText(); // Get the entered expenses text
        String[] lines = expensesText.split("\\n"); // Split the text into new lines
        double[] expenses = new double[lines.length]; // Create an array to store the expenses

        for (int i = 0; i < lines.length; i++) {
            try {
                expenses[i] = Double.parseDouble(lines[i]); // Parse each line as a double and store it in the expenses array
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid expenses value: " + lines[i], "Input Error", JOptionPane.ERROR_MESSAGE);
            } finally {
                expensesTextArea.setText("");
            }
        }

        return expenses; // Return the expenses array
    }

}
