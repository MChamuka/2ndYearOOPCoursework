package OOP.coursework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserGUIClass extends JFrame {
    public UserGUIClass(ShoppingCart shoppingCart) {

        // Create the main frame
        JFrame frame = new JFrame("TextField Example");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel to hold the components
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        // Create a JLabel for text field
        JLabel userLabel = new JLabel("Username:");
        panel.add(userLabel);

        // Create a JTextField with 10 columns
        JTextField userTextField = new JTextField();
        userTextField.setColumns(10); // Set the size
        panel.add(userTextField);

        // Create a JLabel for password field
        JLabel passwordLabel = new JLabel("Password:");
        panel.add(passwordLabel);

        // Create a JPasswordField with 10 columns
        JPasswordField passwordField = new JPasswordField();
        passwordField.setColumns(10); // Set the size
        panel.add(passwordField);

        // Create a JButton
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add your login logic here
                String username = userTextField.getText();
                char[] password = passwordField.getPassword();
                // Perform authentication or other actions as needed
                // For simplicity, let's just print the entered values
                System.out.println("Username: " + username);
                System.out.println("Password: " + new String(password));
            }
        });
        panel.add(loginButton);

        // Add the panel to the frame
        frame.add(panel);

        // Make the frame visible
        frame.setVisible(true);
    }
}
