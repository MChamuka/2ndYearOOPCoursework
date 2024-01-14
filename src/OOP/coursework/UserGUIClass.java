package OOP.coursework;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;


public class UserGUIClass extends JFrame {
    private String username;
    private String password;
    private boolean elementAvailable;
    private int elementAvailableIndex;
    private User user=new User(username,password);
    static final ShoppingManager manager=new WestminsterShoppingManager();
    ConsoleApplication consoleApplication=new ConsoleApplication();
    public int discount;
    public static boolean nonRegisteredUser;
    public UserGUIClass(ShoppingCart shoppingCart) {

        ShoppingManager manager= consoleApplication.manager;

        JFrame frame = new JFrame("TextField Example");
        frame.setSize(300, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel userLabel = new JLabel("Username:");
        panel.add(userLabel);

        JTextField userTextField = new JTextField();
        panel.add(userTextField);

        JLabel passwordLabel = new JLabel("Password:");
        panel.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        panel.add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add your login logic here
                new GUIClassA((WestminsterShoppingManager) manager);
                username = userTextField.getText();
                password = Arrays.toString(passwordField.getPassword());
                User user=new User(username,password);
                userAccountFinder();
            }
        });
        panel.add(loginButton);
        frame.add(panel);
        frame.setVisible(true);
    }
    public void userAccountFinder(){
        elementAvailable=false;
        for (int i=0;i<user.userNameList.size();i++) {
            if (username.equals(user.userNameList.get(i))) {
                elementAvailableIndex=i;
                elementAvailable=true;
            }
        }
        if(elementAvailable) {
            if (password.equals(user.passwordList.get(elementAvailableIndex))) {
                JOptionPane.showMessageDialog(UserGUIClass.this, "Hello " + username + ", welcome back");
                nonRegisteredUser = false;
            } else {
                JOptionPane.showMessageDialog(UserGUIClass.this, "Incorrect password");
                nonRegisteredUser = false;
            }

        }
        else {
            user.userNameList.add(this.username);
            user.passwordList.add(this.password);
            JOptionPane.showMessageDialog(UserGUIClass.this, "Welcome new User!");
            nonRegisteredUser = true;
        }
    }
}
