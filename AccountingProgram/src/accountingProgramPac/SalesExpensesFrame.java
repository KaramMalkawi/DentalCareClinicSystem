package accountingProgramPac;

import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * SalesExpensesFrame class for handling the main frame for entering sales and expenses
 */
public class SalesExpensesFrame extends JFrame {

    private SalesPanel salesPanel;
    private ExpensesPanel expensesPanel;

    public SalesExpensesFrame() {
        setTitle("Sales and Expenses"); // Set the title of the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set the default close operation
        setLocationRelativeTo(null); // Center the frame on the screen

        salesPanel = new SalesPanel(); // Create an instance of the sales panel
        expensesPanel = new ExpensesPanel(); // Create an instance of the expenses panel

        JButton calculateButton = new JButton("Calculate"); // Create a calculate button
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double[] sales = salesPanel.getSales(); // Get the entered sales transactions
                double[] expenses = expensesPanel.getExpenses(); // Get the entered expenses

                double netSales = calculateNetSales(sales, expenses); // Calculate the net sales
                double tax = calculateTax(netSales); // Calculate the tax

                displaySummary(sales, expenses, netSales, tax); // Display the summary
            }
        });

        JPanel panel = new JPanel(new BorderLayout()); // Create a panel with a border layout
        panel.add(salesPanel.getPanel(), BorderLayout.NORTH); // Add the sales panel to the north
        panel.add(expensesPanel.getPanel(), BorderLayout.CENTER); // Add the expenses panel to the center
        panel.add(calculateButton, BorderLayout.SOUTH); // Add the calculate button to the south

        add(panel); // Add the panel to the frame
        pack(); // Pack the components in the frame
    }

    private double calculateNetSales(double[] sales, double[] expenses) {
        double totalSales = 0.0; // Initialize the total sales

        for (double sale : sales) {
            totalSales += sale; // Add each sale to the total sales
        }

        double totalExpenses = 0.0; // Initialize the total expenses

        for (double expense : expenses) {
            totalExpenses += expense; // Add each expense to the total expenses
        }

        return totalSales - totalExpenses; // Calculate and return the net sales
    }

    private double calculateTax(double netSales) {
        return netSales * 0.16; // Calculate and return the tax amount
    }

    private void displaySummary(double[] sales, double[] expenses, double netSales, double tax) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00"); // Create a decimal format

        SummaryPanel summaryPanel = new SummaryPanel(sales, expenses, netSales, tax); // Create an instance of the summary panel

        JOptionPane.showMessageDialog(null, summaryPanel.getPanel(), "Summary", JOptionPane.PLAIN_MESSAGE); // Show the summary panel in a dialog
    }

}
