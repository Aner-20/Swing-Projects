package LimitInput;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Limit extends JFrame implements KeyListener {

    JTextField textField;
    JLabel label;
    String str;
    Limit(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 300);
        this.setTitle("Limit input");
        this.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        textField = new JTextField();
        textField.setBounds(30, 40, 100, 40);
        textField.addKeyListener(this);

        this.add(textField);
        this.setVisible(true);
    }


    @Override
    public void keyTyped(KeyEvent e) {
        
        char input = e.getKeyChar();
        int num = Integer.parseInt(String.valueOf(input));
        int c = 32;
        str = textField.getText();
        //int numbers = Integer.parseInt(str);
        if(num >= 0 && num <= 9){
            //System.out.println(str.length());
            calculate(str);
            if(str.length() == 5){
                textField.setEditable(false);
            }
            //System.out.println(num * 2);
            //System.out.println("Ok");
        }
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
       if(e.getKeyCode() == 8 && str.length() == 5){
            textField.setEditable(true);
       }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getSource() == textField){
            System.out.println("You released key char: " + e.getKeyChar());
            System.out.println("You released key code: " + e.getKeyCode());
        }
    }
    
    public void calculate(String str){
         int numbers = Integer.parseInt(str);
    }
}
