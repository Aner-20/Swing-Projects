package TextAdventure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Game implements ActionListener {
    
    HashMap<Integer, String> textOptions = new HashMap<Integer, String>();
    HashMap<Integer, String> options = new HashMap<Integer, String>();
    int textNode = 1;
    int nextTextNode; 

    JFrame frame = new JFrame();
    JLabel text;
    JPanel panel;
    JButton[] optionButtons = new JButton[4];
    JButton optionButton1, optionButton2, optionButton3, optionButton4;
    Font textFont = new Font("MV Boli", Font.PLAIN, 18);
    Font buttonsFont = new Font("MV Boli", Font.PLAIN, 14);
   

    Game(){
        textOptions.put(1, "There is someone that you want to meet");
        textOptions.put(2, "My name is Jack, nice to meet you");
        textOptions.put(3, "I'm 22 years old");
        textOptions.put(4, "I'm from London");

        options.put(1, "What's your name?");
        options.put(2, "How old are you?");
        options.put(3, "Where are you from?");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 350);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        GUI();

        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < 4; i++){
            if(e.getSource() == optionButtons[i]){
                if(e.getSource() == optionButtons[0]){
                    textNode += 1;
                    
                }
                if(e.getSource() == optionButtons[1]){
                    textNode += 2;
                    
                }
                if(e.getSource() == optionButtons[2]){
                   textNode += 3;
                }
                if(e.getSource() == optionButtons[3]){
                    textNode += 4;
                }
                showTextNode(textNode);
            }
        }
    }

    public void GUI(){
        text = new JLabel();
        text.setText(textOptions.get(1));
        text.setBounds(140, 30, 600, 50);
        text.setFont(textFont);
        text.setOpaque(false);
        frame.add(text);

        panel = new JPanel();
        panel.setBounds(150, 120, 400,100);
        panel.setLayout(new GridLayout(2, 2, 10, 10));

        optionButton1 = new JButton();
        optionButton1.setText(options.get(1));

        optionButton2 = new JButton();
        optionButton2.setText("");
        optionButton2.setEnabled(false);

        optionButton3 = new JButton();
        optionButton3.setText("");
        optionButton3.setEnabled(false);

        optionButton4 = new JButton();
        optionButton4.setText("");
        optionButton4.setEnabled(false);

        optionButtons[0] = optionButton1;
        optionButtons[1] = optionButton2;
        optionButtons[2] = optionButton3;
        optionButtons[3] = optionButton4;

        for(int i = 0; i < 4; i++){
           optionButtons[i].addActionListener(this);
           optionButtons[i].setFont(buttonsFont);
           optionButtons[i].setFocusable(false);
        }

        panel.add(optionButtons[0]);
        panel.add(optionButtons[1]);
        panel.add(optionButtons[2]);
        panel.add(optionButtons[3]);
        frame.add(panel);
    }

    public void showTextNode(int textNode){
        switch(textNode){
            case 2:
                text.setText(textOptions.get(textNode));
                optionButton1.setText(options.get(textNode));
                optionButton2.setEnabled(true);
                optionButton2.setText(options.get(textNode + 1));
                break;
            case 3:
                text.setText(textOptions.get(textNode));
                break;
            case 4:
                text.setText(textOptions.get(textNode));
                break;
            case 6:
                JOptionPane.showMessageDialog(null, "You win!", null, JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
                break;
        }
        
        
    }
    
}



