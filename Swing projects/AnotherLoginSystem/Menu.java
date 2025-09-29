package AnotherLoginSystem;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Menu extends JFrame implements ActionListener {
    JButton registerButton, loginButton, exitButton;
    static String fileString = "account.dat";
    Menu(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Main Menu");
        this.setLayout(null);
        this.setSize(350, 300);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.white);

        registerButton = new JButton("Register");
        registerButton.setBounds(120, 20, 100, 40);
        registerButton.setFocusable(false);
        registerButton.addActionListener(this);

        loginButton = new JButton("Login");
        loginButton.setBounds(120, 110, 100, 40);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);
        setButtonState();

        exitButton = new JButton("Exit");
        exitButton.setBounds(120, 200, 100, 40);
        exitButton.setFocusable(false);
        exitButton.addActionListener(this);

        this.add(registerButton);
        this.add(loginButton);
        this.add(exitButton);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == registerButton){
            this.dispose();
            CreateAccountPage createAccountPage = new CreateAccountPage();
        }
        if(e.getSource() == loginButton){
            this.dispose();
            LoginPage loginPage = new LoginPage();
        }

        if(e.getSource() == exitButton){
            System.exit(0);
        }
    }

    public void setButtonState(){
        Path path = Paths.get(fileString);
        if(Files.exists(path)){
            loginButton.setEnabled(true);
        }
        if(Files.notExists(path)){
            loginButton.setEnabled(false);
        }
    }
    
}
