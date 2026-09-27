//YUSHRA BINTE NAEEM
//23-51927-2

package frame;
import javax.swing.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;
import java.util.Scanner;
public class UserProfileSet extends JFrame {
    private JTextField fullNameField, userNameField, userNumberField, addressField, emailField;
    private JPasswordField passwordField, newPasswordField;
    private JButton saveButton, changePasswordButton;

    public UserProfileSet(String user,String email,String pass) {
        setTitle("User Profile Settings");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel fullNameLabel = new JLabel("Full Name:");
        fullNameLabel.setBounds(20, 20, 80, 25);
        add(fullNameLabel);

        fullNameField = new JTextField();
        fullNameField.setBounds(120, 20, 200, 25);
        add(fullNameField);

        JLabel userNameLabel = new JLabel("Username:");
        userNameLabel.setBounds(20, 50, 80, 25);
        add(userNameLabel);

        userNameField = new JTextField();
		userNameField.setText(user);
        userNameField.setBounds(120, 50, 200, 25);
        add(userNameField);

        JLabel userNumberLabel = new JLabel("Phone Number:");
        userNumberLabel.setBounds(20, 80, 100, 25);
        add(userNumberLabel);

        userNumberField = new JTextField();
        userNumberField.setBounds(120, 80, 200, 25);
        add(userNumberField);

        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setBounds(20, 110, 80, 25);
        add(addressLabel);

        addressField = new JTextField();
        addressField.setBounds(120, 110, 200, 25);
        add(addressField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(20, 140, 80, 25);
        add(emailLabel);

        emailField = new JTextField();
		emailField.setText(email);
        emailField.setBounds(120, 140, 200, 25);
        add(emailField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(20, 170, 80, 25);
        add(passwordLabel);

        passwordField = new JPasswordField();
		passwordField.setText(pass);
        passwordField.setBounds(120, 170, 200, 25);
        add(passwordField);

        //JLabel newPasswordLabel = new JLabel("New Password:");
        //newPasswordLabel.setBounds(20, 200, 100, 25);
       // add(newPasswordLabel);

        //newPasswordField = new JPasswordField();
       // newPasswordField.setBounds(120, 200, 200, 25);
        //add(newPasswordField);

        saveButton = new JButton("Save");
        saveButton.setBounds(120, 230, 80, 25);
        add(saveButton);

        changePasswordButton = new JButton("Change Password");
        changePasswordButton.setBounds(210, 230, 150, 25);
        add(changePasswordButton);

        setVisible(true);

        
        
    }

}
