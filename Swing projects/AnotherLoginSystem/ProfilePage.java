package AnotherLoginSystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.*;
import javax.swing.*;



public class ProfilePage extends JFrame implements ActionListener {
    JPanel panel1, panel2;
    JLabel firstNameLabel, lastNameLabel, cellNumberLabel, emailLabel;
    JButton backButton, changeButton;

    String[] options = {"First Name", "Last Name", "Cell Number", "Email"};

    ProfilePage(){
        Account.loadAccount();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Profile Page");
        this.setLayout(new BorderLayout());
        this.setSize(380, 450);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.white);

        panel1 = new JPanel();
        panel1.setBackground(Color.white);
        panel1.setPreferredSize(new Dimension(380, 300));
        panel1.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.weightx = 0;
        c.weighty = 1;
        c.insets = new Insets(2, 2, 2, 2);

        firstNameLabel = new JLabel("First Name: " + Account.firstName);
        c.gridx = 0;
        c.gridy = 0;
        panel1.add(firstNameLabel, c);

        lastNameLabel = new JLabel("Last Name: " + Account.lastName);
        c.gridx = 0;
        c.gridy = 1;
        panel1.add(lastNameLabel, c);

        cellNumberLabel = new JLabel("Cell Number: " + Account.cellNumber);
        c.gridx = 0;
        c.gridy = 2;
        panel1.add(cellNumberLabel, c);

        emailLabel = new JLabel("Email: " + Account.email);
        c.gridx = 0;
        c.gridy = 3;
        panel1.add(emailLabel, c);


        panel2 = new JPanel();
        panel2.setBackground(Color.white);
        panel2.setPreferredSize(new Dimension(380, 100));
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER));

        backButton = new JButton("Back");
        backButton.addActionListener(this);
        backButton.setFocusable(false);

        changeButton = new JButton("Change");
        changeButton.addActionListener(this);
        changeButton.setFocusable(false);

        panel2.add(backButton);
        panel2.add(changeButton);

        this.add(panel1, BorderLayout.NORTH);
        this.add(panel2, BorderLayout.SOUTH);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backButton){
            this.dispose();
            AccountPage accountPage = new AccountPage();
        }
        
        if(e.getSource() == changeButton){
            int choice = JOptionPane.showOptionDialog(null, "What do want to change", null, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, 0);
            switch(choice){
                case 0:
                    String updatedFirstName = JOptionPane.showInputDialog("Insert a new first name");
                    checkFirstName(updatedFirstName);
                    break;
                case 1:
                    String updatedLastName = JOptionPane.showInputDialog("Insert a new last name");
                    
                    checkLastName(updatedLastName);
                    break;
                case 2:
                    String updatedCellNumber = JOptionPane.showInputDialog("Insert a new cell number");
                    
                    checkCellNumber(updatedCellNumber);
                    break;
                case 3:
                    String updatedEmail = JOptionPane.showInputDialog("Insert a new email");
                    
                    checkEmail(updatedEmail);
                    break;

            }
        }
    }

    public void checkFirstName(String firstName){
        if(firstName == null);
        
        else if(firstName.isEmpty()){
            JOptionPane.showMessageDialog(null, "The name field cannot be empty", null, JOptionPane.ERROR_MESSAGE);
        }

        else if(firstName.matches("^[a-zA-Z]*$")){
            firstNameLabel.setText("First Name: " + firstName);
            JOptionPane.showMessageDialog(null, "The inserted name is valid", null, JOptionPane.INFORMATION_MESSAGE);
            Account.saveAccount(firstName, Account.lastName, Account.cellNumber, Account.email, Account.password);
        }

        else if(!firstName.matches("^[a-z-A-Z]*$")){
            JOptionPane.showMessageDialog(null, "The inserted name is invalid", null, JOptionPane.ERROR_MESSAGE);
        }
    }

    public void checkLastName(String lastName){
        if(lastName == null);
        
        else if(lastName.isEmpty()){
            JOptionPane.showMessageDialog(null, "The name field cannot be empty", null, JOptionPane.ERROR_MESSAGE);
        }

        else if(lastName.matches("^[a-zA-Z]*$")){
            lastNameLabel.setText("Last Name: " + lastName);
            Account.saveAccount(Account.firstName, lastName, Account.cellNumber, Account.email, Account.password);
            JOptionPane.showMessageDialog(null, "The inserted name is valid", null, JOptionPane.INFORMATION_MESSAGE);
        }

        else if(!lastName.matches("^[a-z-A-Z]*$")){
            JOptionPane.showMessageDialog(null, "The inserted name is invalid", null, JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void checkCellNumber(String cellNumber){
        if(cellNumber == null);

        else if(cellNumber.isEmpty()){
            JOptionPane.showMessageDialog(null, "The cell number field cannot be empty", null, JOptionPane.ERROR_MESSAGE);
        }

        else if(cellNumber.matches("\\d{10}")){
            cellNumberLabel.setText("Cell Number: " + cellNumber);
            Account.saveAccount(Account.firstName, Account.lastName, cellNumber, Account.email, Account.password);
            JOptionPane.showMessageDialog(null, "The cell number is valid", null, JOptionPane.INFORMATION_MESSAGE);
        }

        else if(!cellNumber.matches("\\d{10}")){
            JOptionPane.showMessageDialog(null, "The cell number is invalid", null, JOptionPane.ERROR_MESSAGE);
        }
    }

    public void checkEmail(String email){
        if(email == null);

        else if(email.isEmpty()){
            JOptionPane.showMessageDialog(null, "The email field cannot be empty", null, JOptionPane.ERROR_MESSAGE);
        }
        else if(email.matches("^[a-zA-Z0-9_+&*-]+(?:\\."+ 
        "[a-zA-Z0-9_+&*-]+)*@" + 
        "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
        "A-Z]{2,7}$")){
            emailLabel.setText("Email: "  + email);
            Account.saveAccount(Account.firstName, Account.lastName, Account.cellNumber, email, Account.password);
            JOptionPane.showMessageDialog(null, "The email is valid", null, JOptionPane.INFORMATION_MESSAGE);
        }
        else if(!email.matches("^[a-zA-Z0-9_+&*-]+(?:\\."+ 
        "[a-zA-Z0-9_+&*-]+)*@" + 
        "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
        "A-Z]{2,7}$")){
            JOptionPane.showMessageDialog(null, "The email is invalid", null, JOptionPane.ERROR_MESSAGE);
        }
    }
}
