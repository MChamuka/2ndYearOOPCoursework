package OOP.coursework;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

public class User {
    public ArrayList<String> userNameList= new ArrayList<>();
    public ArrayList<String> passwordList= new ArrayList<>();

    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;

        userNameList.add(username);
        passwordList.add(password);

        System.out.println(username);

    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
