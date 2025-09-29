package ChangeBgColor;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.*;
import java.util.concurrent.Flow;
import java.util.Random;

public class ChangeBgColor extends JFrame implements ActionListener {

    JPanel panel;
    JLabel label;
    JButton button;
    static Random random = new Random();
    

    ChangeBgColor(){
        

        label = new JLabel();
        label.setText("Change Color");
        label.setFont(new Font(null, Font.BOLD, 20));
        label.setOpaque(true);
        label.setBounds(100, -20, 200, 100);
        label.setBackground(Color.white);

        button = new JButton();
        button.addActionListener(this);
        button.setText("Click me :)");
        button.setFocusable(false);
        button.setFont(new Font(null, Font.PLAIN, 20));
        button.setBackground(Color.BLACK);
        button.setForeground(Color.white);
        button.setBounds(102, 150, 130, 40);
        

       this.add(label);
       this.add(button);

        this.setTitle("Change Background Color");
        this.setSize(350, 320);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.white);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            int r = (int) (Math.random() * 256);
            int g = (int) (Math.random() * 256);
            int b = (int) (Math.random() * 256);
            this.getContentPane().setBackground(new Color(r, g, b));
            label.setBackground(new Color(r, g, b));

        }
    }
    
}
