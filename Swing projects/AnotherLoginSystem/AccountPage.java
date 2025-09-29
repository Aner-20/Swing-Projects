package AnotherLoginSystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.*;
import javax.swing.border.Border;

import AnotherLoginSystem.Account;

public class AccountPage extends JFrame implements ActionListener{

    JLabel label;
    JButton profileButton, deleteButton, logOutButton;
    JPanel panel1, panel2;

    AccountPage(){
        Account.loadAccount();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Account Page");
        this.setLayout(new BorderLayout(20, 40));
        this.setSize(350, 200);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        label = new JLabel("Welcome " + Account.firstName);
        panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());

        panel1.add(label);

        panel2 = new JPanel();
        panel2.setLayout(new FlowLayout());

        profileButton = new JButton("Profile");
        profileButton.setFocusable(false);
        profileButton.addActionListener(this);

        panel2.add(profileButton);

        deleteButton = new JButton("Delete");
        deleteButton.setFocusable(false);
        deleteButton.addActionListener(this);

        panel2.add(deleteButton);

        logOutButton = new JButton("Log out");
        logOutButton.setFocusable(false);
        logOutButton.addActionListener(this);

        panel2.add(logOutButton);

        this.add(panel1, BorderLayout.NORTH);
        this.add(panel2, BorderLayout.CENTER);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == profileButton){
            this.dispose();
            ProfilePage profilePage = new ProfilePage();
        }
        if(e.getSource() == deleteButton){
            int answer = JOptionPane.showConfirmDialog(null, "Do you want to delete your account?", null, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null);
            if(answer == 0){
                checkFile();
            } 
        
        }
        if(e.getSource() == logOutButton){
            this.dispose();
            Menu menu = new Menu();
        }  
    }
    public void checkFile(){
       File file = new File(Menu.fileString);
       if(file.exists()){
            file.delete();
            this.dispose();
            JOptionPane.showMessageDialog(null, "Your account has been deleted.", "title", JOptionPane.INFORMATION_MESSAGE);
            Menu menu = new Menu();
       }
    }
}
