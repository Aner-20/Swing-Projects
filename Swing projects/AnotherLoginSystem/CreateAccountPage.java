package AnotherLoginSystem;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.*;
import java.util.EventObject;
import java.util.regex.*;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Element;

public class CreateAccountPage extends JFrame implements ActionListener {
    JPanel panel;
    JLabel firstNameLabel, lastNameLabel, cellNumberLabel, emailLabel, passwordLabel;
    JTextField fieldFirstName, fieldLastName, fieldCellNumber, fieldEmail;
    JPasswordField fieldPassword;
    JButton createAcccountButton;

    String newFirstName, newLastName, newCellNumber, newEmail, newPassword;
    boolean firstNameState, lastNameState, cellNumberState, emailState, passwordState;

    CreateAccountPage(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Create Account");
        this.setLayout(null);
        this.setSize(380, 450);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.white);

        panel = new JPanel();
        panel.setBackground(Color.white);
        panel.setBounds(40, 20, 300, 300);
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.weightx = 0;
        c.weighty = 1;
        c.insets = new Insets(2, 2, 2, 2);

        firstNameLabel = new JLabel("FirstName");
        c.gridx = 0;
        c.gridy = 0;
        panel.add(firstNameLabel, c);

        fieldFirstName = new JTextField(10);
        fieldFirstName.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                newFirstName = fieldFirstName.getText();
                validateFirstName(e, newFirstName, firstNameLabel);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                newFirstName = fieldFirstName.getText();
               validateFirstName(e, newFirstName, firstNameLabel);

            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                
            }
            
        });
        c.gridx = 1;
        c.gridy = 0;
        panel.add(fieldFirstName, c);

        lastNameLabel = new JLabel("LastName");
        c.gridx = 0;
        c.gridy = 1;
        panel.add(lastNameLabel, c);

        fieldLastName = new JTextField();
        fieldLastName.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                newLastName = fieldLastName.getText();
                validateLastName(e, newLastName, lastNameLabel);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                newLastName = fieldLastName.getText();
               validateLastName(e, newLastName, lastNameLabel);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                
            }
            
        });
        c.gridx = 1;
        c.gridy = 1;
        panel.add(fieldLastName, c);

        cellNumberLabel = new JLabel("Cell Number");
        c.gridx = 0;
        c.gridy = 2;
        panel.add(cellNumberLabel, c);

        fieldCellNumber = new JTextField();
        fieldCellNumber.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                newCellNumber = fieldCellNumber.getText();
                validateCellNumber(e, newCellNumber, cellNumberLabel);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                newCellNumber = fieldCellNumber.getText();
                validateCellNumber(e, newCellNumber, cellNumberLabel);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                
            }
            
        });
        c.gridx = 1;
        c.gridy = 2;
        panel.add(fieldCellNumber, c);

        emailLabel = new JLabel("Email");
        c.gridx = 0;
        c.gridy = 3;
        panel.add(emailLabel, c);

        fieldEmail = new JTextField();
        fieldEmail.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                newEmail = fieldEmail.getText();
                validateEmail(e, newEmail, emailLabel);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                newEmail = fieldEmail.getText();
                validateEmail(e, newEmail, emailLabel);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                
            }
            
        });
        c.gridx = 1;
        c.gridy = 3;
        panel.add(fieldEmail, c);

        passwordLabel = new JLabel("Password");
        c.gridx = 0;
        c.gridy = 4;
        panel.add(passwordLabel, c);

        fieldPassword = new JPasswordField();
        fieldPassword.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                newPassword = String.valueOf(fieldPassword.getPassword());
                validatePassword(e, newPassword, passwordLabel);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                newPassword = String.valueOf(fieldPassword.getPassword());
                validatePassword(e, newPassword, passwordLabel);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                
            }
            
        });
        c.gridx = 1;
        c.gridy = 4;
        panel.add(fieldPassword, c);

        createAcccountButton = new JButton("Create Account");
        createAcccountButton.addActionListener(this);
        createAcccountButton.setFocusable(false);
        createAcccountButton.setBounds(120, 340, 150, 40);


        this.add(panel);
        this.add(createAcccountButton);

        this.setVisible(true);
    }


    public void validateFirstName(DocumentEvent e, String input, JLabel nameLabel){
            if(input.isEmpty()){
                nameLabel.setForeground(Color.black);
            }

            else if(input.matches("^[a-zA-Z]*$")){
                firstNameState = true;
                nameLabel.setForeground(Color.green);
            }

            else if(!input.matches("^[a-z-A-Z]*$")){
                firstNameState = false;
                nameLabel.setForeground(Color.red);
            }
            
    }

    public void validateLastName(DocumentEvent e, String input, JLabel nameLabel){
            if(input.isEmpty()){
                nameLabel.setForeground(Color.black);
            }

            else if(input.matches("^[a-zA-Z]*$")){
                lastNameState = true;
                nameLabel.setForeground(Color.green);
            }

            else if(!input.matches("^[a-z-A-Z]*$")){
                lastNameState = false;
                nameLabel.setForeground(Color.red);
            }
            
    }

    public void validateCellNumber(DocumentEvent e, String cellNumber, JLabel cellLabel){
        if(cellNumber.isEmpty()){
            cellLabel.setForeground(Color.black);
        }

        else if(cellNumber.matches("\\d{10}")){
            cellNumberState = true;
            cellLabel.setForeground(Color.green);
        }

        else if(!cellNumber.matches("\\d{10}")){
            cellLabel.setForeground(Color.red);
        }

    }

    public void validateEmail(DocumentEvent e, String email, JLabel emailLabel){
        if(email.isEmpty()){
            emailLabel.setForeground(Color.black);
        }
        else if(email.matches("^[a-zA-Z0-9_+&*-]+(?:\\."+ 
        "[a-zA-Z0-9_+&*-]+)*@" + 
        "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
        "A-Z]{2,7}$")){
            emailState = true;
            emailLabel.setForeground(Color.green);
        }
        else if(!email.matches("^[a-zA-Z0-9_+&*-]+(?:\\."+ 
        "[a-zA-Z0-9_+&*-]+)*@" + 
        "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
        "A-Z]{2,7}$")){
            emailState = false;
            emailLabel.setForeground(Color.red);
        }
    }

    public void validatePassword(DocumentEvent e, String password, JLabel passwordLabel){
        
        if(password.isEmpty()){
            passwordLabel.setForeground(Color.black);
        }
        else if(password.matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,15})")){
            passwordState = true;
            passwordLabel.setForeground(Color.green);
        }
        else if(!password.matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,15})")){
            passwordState = false;
            passwordLabel.setForeground(Color.red);
        }
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == createAcccountButton){
            if(firstNameState == true && cellNumberState == true && emailState == true && passwordState == true){
                int answer = JOptionPane.showConfirmDialog(null, "Do you want to create a new account?", null, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null);
            if(answer == 0){
                this.dispose();
                Account.saveAccount(newFirstName, newLastName, newCellNumber, newEmail, newPassword);
                AccountPage accountPage = new AccountPage();
            }
            
         }
         
        }
    }    
}
