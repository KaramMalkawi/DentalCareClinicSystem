package accountingProgramPac;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/*
 * SalesPanel class for handling the UI components and logic for entering sales transactions
 */
public class SalesPanel {

    private JTextArea salesTextArea;

    public SalesPanel() {
        salesTextArea = new JTextArea(10, 30); // Create a text area for entering sales
    }

    public JPanel getPanel() {
        JPanel panel = new JPanel(new BorderLayout()); // Create a panel with a border layout
        panel.setBorder(BorderFactory.createTitledBorder("Enter Sales Transactions")); // Set a titled border for the panel

        JScrollPane scrollPane = new JScrollPane(salesTextArea); // Create a scroll pane for the sales text area
        panel.add(scrollPane); // Add the scroll pane to the panel

        return panel; // Return the panel
    }

    public double[] getSales() {
        String salesText = salesTextArea.getText(); // Get the entered sales text
        String[] lines = salesText.split("\\n"); // Split the text by new lines
        double[] sales = new double[lines.length]; // Create an array to store the sales

        for (int i = 0; i < lines.length; i++) {
            try {
                sales[i] = Double.parseDouble(lines[i]); // Parse each line as a double and store it in the sales array
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid sales value: " + lines[i], "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        return sales; // Return the sales array
    }

}
