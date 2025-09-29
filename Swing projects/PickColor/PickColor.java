package PickColor;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.FlowView;
import javax.swing.text.FlowView.FlowStrategy;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.concurrent.Flow;


public class PickColor extends JFrame implements ActionListener {

    JPanel panel;
    JButton button1, button2, button3, button4, button5, button6;

    PickColor(){

        
        button1 = new JButton("Red");
        button1.setFocusable(false);
        button1.addActionListener(this);

        button2 = new JButton("Blue");
        button2.setFocusable(false);
        button2.addActionListener(this);

        button3 = new JButton("Green");
        button3.setFocusable(false);
        button3.addActionListener(this);

        button4 = new JButton("Yellow");
        button4.setFocusable(false);
        button4.addActionListener(this);

        button5 = new JButton("Orange");
        button5.setFocusable(false);
        button5.addActionListener(this);

        button6 = new JButton("Pink");
        button6.setFocusable(false);
        button6.addActionListener(this);


        panel = new JPanel();
        //panel.setBounds(0, 200, 200, 200);
        GridBagLayout GridBagLayout = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        panel.setLayout(GridBagLayout);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(button1);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(Box.createHorizontalStrut(50), gbc);
        panel.add(button2);


        this.add(panel);
        this.setTitle("Pick Color");
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
    }
    
}
