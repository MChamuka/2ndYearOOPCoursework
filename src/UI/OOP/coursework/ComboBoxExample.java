package UI.OOP.coursework;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComboBoxExample extends JFrame {
    private JComboBox<String> comboBox;

    public ComboBoxExample() {
        // Set up the JFrame
        setTitle("ComboBox Example");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a String array for items in the combo box
        String[] items = {"Item 1", "Item 2", "Item 3", "Item 4"};

        // Create a JComboBox with the array of items
        comboBox = new JComboBox<>(items);

        // Add an ActionListener to respond to item selection
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the selected item
                String selectedValue = comboBox.getSelectedItem().toString();

                // Display a message with the selected item
                JOptionPane.showMessageDialog(ComboBoxExample.this, "Selected: " + selectedValue);
            }
        });

        // Add the JComboBox to the JFrame
        add(comboBox);

        // Set the JFrame to be visible
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ComboBoxExample();
            }
        });
    }
}
