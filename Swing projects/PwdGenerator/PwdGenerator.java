package PwdGenerator;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;


public class PwdGenerator extends JFrame implements ActionListener {

    static Random random = new Random();
    static String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static String lowerCaseLetters = upperCaseLetters.toLowerCase();
    static String digits = "0123456789";
    static String symbols = "!£$%&/()=[]{}@#-_-+*|,;.:§°^?";
    static String sum = upperCaseLetters + lowerCaseLetters + digits + symbols;

    JLabel labelLength;
    JTextField textField;
    JTextField textField2;
    JButton button;
    
    PwdGenerator(){

        labelLength = new JLabel();
        labelLength.setText("Length");
        labelLength.setOpaque(true);
        labelLength.setBounds(80,15, 100,100);
        labelLength.setFont(new Font(null, Font.PLAIN, 30));

        textField = new JTextField();
        textField.setBounds(240, 45, 100, 40);
        textField.setFont(new Font("Consolas", Font.PLAIN, 20));
        textField.setHorizontalAlignment(JTextField.CENTER);

        textField2 = new JTextField();
        textField2.setBounds(70, 120, 300, 40);
        textField2.setFont(new Font("Consolas", Font.PLAIN, 20));
        textField2.setHorizontalAlignment(JTextField.LEFT);
        textField2.setEditable(false);

        button = new JButton();
        button.addActionListener(this);
        button.setText("Generate");
        button.setFocusable(false);
        button.setFont(new Font("Consolas", Font.PLAIN, 20));
        button.setBounds(120, 180, 200, 50);
        
        this.add(labelLength);
        this.add(textField);
        this.add(textField2);
        this.add(button);
        this.setTitle("Password Generator");
        this.setSize(450, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            try {
                int length = Integer.parseInt(textField.getText());
                char[] password = new char[length];
                password[0] = upperCaseLetters.charAt(random.nextInt(upperCaseLetters.length()));
                password[1] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
                password[2] = digits.charAt(random.nextInt(digits.length()));
                password[3] = symbols.charAt(random.nextInt(symbols.length()));
                
                for(int i = 0; i < length; i++){
                    password[i] = sum.charAt(random.nextInt(sum.length()));

                }
                String result = String.valueOf(password);
                System.out.println(result);
                System.out.println(result instanceof String);

                textField2.setText(result);
                textField2.setEditable(true);

            } catch (Exception E) {
                System.out.println("Type a number");
            }
        }
    }
    
}
