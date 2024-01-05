package UI.OOP.coursework;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class TableRowClickListenerExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Table Row Click Listener Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Create sample data for the table
            Object[][] data = {
                    {"John", "Doe", 25},
                    {"Jane", "Smith", 30},
                    {"Bob", "Johnson", 22}
            };

            // Create column names
            String[] columnNames = {"First Name", "Last Name", "Age"};

            // Create a DefaultTableModel with the data and column names
            DefaultTableModel model = new DefaultTableModel(data, columnNames);

            // Create a JTable with the DefaultTableModel
            JTable table = new JTable(model);

            // Create a JLabel to display the output
            JLabel outputLabel = new JLabel("Output will be displayed here.");

            // Add a ListSelectionListener to the table
            table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (!e.getValueIsAdjusting()) {
                        int selectedRow = table.getSelectedRow();
                        if (selectedRow != -1) {
                            // Get data from the selected row
                            Object firstName = table.getValueAt(selectedRow, 0);
                            Object lastName = table.getValueAt(selectedRow, 1);
                            Object age = table.getValueAt(selectedRow, 2);

                            // Display output on the JLabel
                            String output = "Selected Row: " + selectedRow + ", Data: " + firstName + " " + lastName + ", Age: " + age;
                            outputLabel.setText(output);
                        }
                    }
                }
            });

            // Create a JScrollPane to hold the table
            JScrollPane scrollPane = new JScrollPane(table);

            // Create a JPanel to hold the table and output label
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            panel.add(scrollPane);
            panel.add(outputLabel);

            // Add the JPanel to the frame
            frame.add(panel);

            // Set frame properties
            frame.setSize(400, 300);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
