package OddEvenGame;

import javax.swing.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.*;

public class OddEvenGame extends JFrame implements ActionListener {
    
    JLabel label;
    JTextField textField;
    JButton button;
    JLabel message;
    JPanel panel;
    static int number;

    OddEvenGame(){

        panel = new JPanel();

        label = new JLabel();
        label.setText("Number");
        label.setFont(new Font(null, Font.PLAIN, 25));
        label.setOpaque(true);
        label.setBackground(Color.green);

        textField = new JTextField();
        textField.setPreferredSize(new Dimension(20, 50));
        textField.setFont(new Font("Consolas", Font.PLAIN, 20));
        textField.setHorizontalAlignment(JTextField.CENTER);

        button = new JButton();
        button.addActionListener(this);
        button.setText("Check");
        button.setFocusable(false);
        button.setFont(new Font(null, Font.PLAIN, 20));
        

        message = new JLabel();
        message.setText("The number # is odd");
        message.setFont(new Font(null, Font.PLAIN, 25));
        message.setOpaque(true);
        message.setBackground(Color.green);
        message.setVisible(false);

        BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(boxLayout);

        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        textField.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        message.setAlignmentX(Component.CENTER_ALIGNMENT);


        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(0, 40)));
        panel.add(textField);
        panel.add(Box.createRigidArea(new Dimension(0, 40)));
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(0, 30)));
        panel.add(message);
        panel.setBackground(Color.green);
        
        this.setTitle("Odd Even Game");
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 50));
        this.getContentPane().setBackground(Color.GREEN);
        this.add(panel);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == button){
            try {
                //System.out.println(textField.getText());
                number = Integer.parseInt(textField.getText());
                if (number % 2 == 0){
                    message.setVisible(true);
                    message.setText("The number " + number + " is even");
                }
                else if (number % 2 != 0){
                    message.setVisible(true);
                    message.setText("The number " + number + " is odd");
                }

            } catch (Exception E) {
                //System.out.println("Type a number");
                message.setVisible(true);
                message.setText("Type a number");
                
            }
       }
    }
    
}
