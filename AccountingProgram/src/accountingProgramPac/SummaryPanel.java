package accountingProgramPac;

import java.awt.BorderLayout;

import java.text.DecimalFormat;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/*
 * SummaryPanel class for handling the UI components and logic for displaying the summary
 */
public class SummaryPanel {

    private JTextArea summaryTextArea;

    public SummaryPanel(double[] sales, double[] expenses, double netSales, double tax) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00"); // Create a decimal format

        StringBuilder summaryBuilder = new StringBuilder(); // Create a string builder for building the summary
        summaryBuilder.append("Sales Summary:\n"); // Add a heading for the sales summary

        for (int i = 0; i < sales.length; i++)
            summaryBuilder.append("- Sale ").append(i + 1).append(": $").append(decimalFormat.format(sales[i])).append("\n"); // Add each sale to the summary

        summaryBuilder.append("\nExpenses Summary:\n"); // Add a heading for the expenses summary

        for (int i = 0; i < expenses.length; i++)
            summaryBuilder.append("- Expense ").append(i + 1).append(": $").append(decimalFormat.format(expenses[i])).append("\n"); // Add each expense to the summary

        summaryBuilder.append("\nNet Sales: $").append(decimalFormat.format(netSales)).append("\n"); // Add the net sales to the summary
        summaryBuilder.append("Tax: $").append(decimalFormat.format(tax)).append("\n"); // Add the tax to the summary

        if (netSales < 0)
            summaryBuilder.append("\nWarning: Problem detected. Management intervention required.\n"); // Add a warning message for negative net sales
        else if (netSales > 10000)
            summaryBuilder.append("\nThank you! Excellent sales today.\n"); // Add a message for excellent sales
        else if (netSales < 1000)
            summaryBuilder.append("\nWarning: Critical financial situation. Planning required.\n"); // Add a warning message for low net sales

        summaryTextArea = new JTextArea(15, 30); // Create a text area for the summary
        summaryTextArea.setEditable(false); // Set the summary text area as non-editable
        summaryTextArea.setText(summaryBuilder.toString()); // Set the summary text

    }

    public JPanel getPanel() {
        JPanel panel = new JPanel(new BorderLayout()); // Create a panel with a border layout
        panel.add(new JScrollPane(summaryTextArea)); // Add a scroll pane for the summary text area to the panel
        return panel; // Return the panel
    }

}
