package AnotherLoginSystem;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Testing.Button;

public class LoginPage extends JFrame implements ActionListener {

    JPanel panel;
    JLabel emaiLabel, passwordLabel;
    JTextField emailField, passwordField;
    JButton logInButton;
    String email, password;
    Border emptyBorder;

    LoginPage(){
        Account.loadAccount();
        System.out.println("Email: " + Account.email);
        System.out.println("Password: " + Account.password);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Login Page");
        this.setLayout(null);
        this.setSize(350, 300);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        panel = new JPanel();
        panel.setBounds(50, 30, 250, 150);
        panel.setLayout(new GridBagLayout());
        panel.setBackground(Color.white);
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.weightx = 0;
        c.weighty = 1;
        c.insets = new Insets(2, 2, 2, 2);

        emaiLabel = new JLabel("Email");
        c.gridx = 0;
        c.gridy = 0;
        panel.add(emaiLabel, c);

        emailField = new JTextField(10);
        c.gridx = 1;
        c.gridy = 0;
        panel.add(emailField, c);

        passwordLabel = new JLabel("Password");
        c.gridx = 0;
        c.gridy = 1;
        panel.add(passwordLabel, c);

        passwordField = new JTextField(10);
        c.gridx = 1;
        c.gridy = 1;
        panel.add(passwordField, c);

        logInButton = new JButton("Log In");
        logInButton.setBounds(130, 180, 100, 40);
        logInButton.addActionListener(this);
        emptyBorder = BorderFactory.createEmptyBorder();
        logInButton.setBorder(emptyBorder);
        logInButton.setContentAreaFilled(false);
        logInButton.getModel().addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                ButtonModel model = (ButtonModel) e.getSource();
                if(model.isPressed()){
                    logInButton.setBackground(Color.white);
                }
                else if(model.isRollover()){
                    logInButton.setForeground(Color.blue);
                }
                else{
                    logInButton.setForeground(Color.black);
                }
            }
            
        });
        logInButton.setBackground(Color.white);

        logInButton.setFocusable(false);

        this.add(panel);
        this.add(logInButton);
        this.getContentPane().setBackground(Color.white);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        email = emailField.getText();
        password = passwordField.getText();
        if(e.getSource() == logInButton){
            checkAccount();
        }
    }

    public void checkAccount(){
        
        int answer = JOptionPane.showConfirmDialog(null, "Do you want to log in?", null, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null);
        if(answer == 0){
            if(email.equals(Account.email) && password.equals(Account.password)){
                this.dispose();
                AccountPage accountPage = new AccountPage();
            }
            else{
                JOptionPane.showMessageDialog(null, "Email and password aren't correct", null, JOptionPane.ERROR_MESSAGE);
                emailField.setText("");
                passwordField.setText("");
            }
        }
        else if(answer == 1){
            emailField.setText("");
            passwordField.setText("");
        }
    }
}
