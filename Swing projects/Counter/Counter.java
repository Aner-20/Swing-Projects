package Counter;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import javax.swing.text.AttributeSet.ColorAttribute;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.*;
import java.util.concurrent.Flow;


public class Counter extends JFrame implements ActionListener, KeyListener{
    
    JLabel header;
    JLabel number;
    JPanel panel1;
    JPanel panel2;
    JButton decreaseButton;
    JButton resetButton;
    JButton increaseButton;

    static int count = 0;
    static String magenta = "Magenta";

    Counter(){
        panel1 = new JPanel();

        header = new JLabel();
        header.setText("Counter");
        header.setFont(new Font(null, Font.BOLD, 35));
        header.setOpaque(true);

        number = new JLabel();
        number.setText(Integer.toString(count));
        number.setFont(new Font(null, Font.BOLD, 45));
        number.setOpaque(true);

        panel2 = new JPanel();

        decreaseButton = new JButton();
        decreaseButton.addActionListener(this);
        decreaseButton.setText("Decrease");
        decreaseButton.setFocusable(false);
        decreaseButton.setFont(new Font(null, Font.PLAIN, 20));
        decreaseButton.setBackground(Color.cyan);

        resetButton = new JButton();
        resetButton.addActionListener(this);
        resetButton.setText("Reset");
        resetButton.setFocusable(false);
        resetButton.setFont(new Font(null, Font.PLAIN, 20));
        resetButton.setBackground(Color.CYAN);
        

        increaseButton = new JButton();
        increaseButton.addActionListener(this);
        increaseButton.setText("Increase");
        increaseButton.setFocusable(false);
        increaseButton.setFont(new Font(null, Font.PLAIN, 20));
        increaseButton.setBackground(Color.cyan);

        BoxLayout boxLayout = new BoxLayout(panel1, BoxLayout.Y_AXIS);
        panel1.setLayout(boxLayout);

        BoxLayout buttonsLayout = new BoxLayout(panel2, BoxLayout.X_AXIS);
        panel2.setLayout(buttonsLayout);

        // To center the items
        header.setAlignmentX(Component.CENTER_ALIGNMENT);
        number.setAlignmentX(Component.CENTER_ALIGNMENT);


        this.setTitle("Counter");
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        
        panel1.add(header);
        panel1.add(Box.createRigidArea(new Dimension(0, 20)));  // gap between header and number
        panel1.add(number);

        panel2.add(decreaseButton);
        panel2.add(Box.createRigidArea(new Dimension(10, 0)));
        panel2.add(resetButton);
        panel2.add(Box.createRigidArea(new Dimension(10, 0)));
        panel2.add(increaseButton);

        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 50));  // is necessary to view two or more boxLayout;
        this.add(panel1);
        this.add(panel2);


        this.addKeyListener(this);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == decreaseButton){
            count--;
            number.setText(Integer.toString(count));
        }

        else if(e.getSource() == resetButton){
            count = 0;
            number.setText(Integer.toString(count));
           
        }

        else if(e.getSource() == increaseButton){
            count++;
            number.setText(Integer.toString(count));
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
       
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case 107:
                count++;
                number.setText(Integer.toString(count));
                break;
            
            case 109:
                count--;
                number.setText(Integer.toString(count));
                break; 

            case 32:
                count = 0;
                number.setText(Integer.toString(count));
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //System.out.println("You released key char: " + e.getKeyChar());
        //System.out.println("You released key code: " + e.getKeyCode());
    }
}
