package TemperatureConverter;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.event.*;
import java.awt.*;


public class Converter extends JFrame implements ActionListener {

    int Celsius;
    int Fahrenheit;
    String[] temperatures = {"Celsius", "Fahrenheit"};
    JComboBox comboBox1;
    JComboBox comboBox2;
    JTextField textField1;
    JTextField textField2;

    Converter(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Temperature Converter");
        this.setLayout(null);
        this.setSize(400, 200);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        comboBox1 = new JComboBox(temperatures);
        comboBox1.addActionListener(this);
        comboBox1.setBounds(50, 20, 100, 40);
        comboBox1.setEditable(true);

        textField1 = new JTextField();
        textField1.setHorizontalAlignment(JTextField.CENTER);
        textField1.setBounds(70,80, 50, 40);
        textField1.setFont(new Font(null, Font.PLAIN, 25));
        textField1.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e){
                //warn();
                System.out.println("Hello");
            }
            public void removeUpdate(DocumentEvent e){
                warn();
            }
            public void insertUpdate(DocumentEvent e){
                warn();
            }

            public void warn(){
                try {
                    int input = Integer.parseInt(textField1.getText());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Type a number!", "Wrong input", JOptionPane.ERROR_MESSAGE);
                    ;
                }
            }
        }
        );
        

        comboBox2 = new JComboBox(temperatures);
        comboBox2.addActionListener(this);
        comboBox2.setBounds(250, 20, 100, 40);
        comboBox2.setSelectedIndex(1);
        comboBox2.setEditable(true);

        textField2 = new JTextField();
        textField2.setHorizontalAlignment(JTextField.CENTER);
        textField2.setBounds(270,80, 50, 40);
        textField2.setFont(new Font(null, Font.PLAIN, 25));

        this.add(comboBox1);
        this.add(comboBox2);
        this.add(textField1);
        this.add(textField2);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == comboBox1){
            System.out.println("1: " + comboBox1.getSelectedItem());
        }

        

        if(e.getSource() == comboBox2){
            System.out.println("2: " + comboBox2.getSelectedItem());
        }
    }
    
}
