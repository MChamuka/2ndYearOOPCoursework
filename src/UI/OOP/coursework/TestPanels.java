/*package UI.OOP.coursework;

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

            // Add a ListSelectionListener to the table
            table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (!e.getValueIsAdjusting()) {
                        int selectedRow = table.getSelectedRow();
                        if (selectedRow != -1) {
                            // Row is selected, perform the desired action
                            System.out.println("Selected Row: " + selectedRow);

                            // Get data from the selected row
                            Object firstName = table.getValueAt(selectedRow, 0);
                            Object lastName = table.getValueAt(selectedRow, 1);
                            Object age = table.getValueAt(selectedRow, 2);

                            // Perform your action with the data
                            System.out.println("Data: " + firstName + " " + lastName + ", Age: " + age);
                        }
                    }
                }
            });

            // Create a JScrollPane to hold the table
            JScrollPane scrollPane = new JScrollPane(table);

            // Add the JScrollPane to the frame
            frame.add(scrollPane);

            // Set frame properties
            frame.setSize(400, 300);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
*/