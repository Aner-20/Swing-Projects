package GuessingGame;

import javax.swing.*;
import javax.swing.text.TabSet;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class Game extends JFrame implements ActionListener {

    JLabel label;
    JTextField textField;
    JButton startButton;
    JButton checkButton;
    Font font = new Font("New Times Roman", Font.PLAIN, 25);
    Random random = new Random();
    Thread countThread;
    int number = random.nextInt(19) + 1;
    int guessedNumber;
    int attempts;
    ArrayList<Integer> guesses = new ArrayList<Integer>();

    Game(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Number Guessing Game");
        this.setLayout(null);
        this.setSize(500, 250);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        label = new JLabel();
        label.setText("Guess a number between 1 and 20");
        label.setFont(font);
        label.setOpaque(true);
        label.setBounds(50, 0, 500, 50);

        textField = new JTextField();
        textField.setFont(font);
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setBounds(200, 80, 80, 40);

        startButton = new JButton();
        startButton.setFocusable(false);
        startButton.setFont(font);
        startButton.setText("Start");
        startButton.setBounds(40, 140, 120, 40);
        startButton.addActionListener(this);

        checkButton = new JButton();
        checkButton.setFocusable(false);
        checkButton.setFont(font);
        checkButton.setText("Check");
        checkButton.setBounds(320, 140, 120, 40);
        checkButton.setEnabled(false);
        checkButton.addActionListener(this);
        

        this.add(label); 
        this.add(textField); 
        this.add(startButton);  
        this.add(checkButton);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == startButton){
            System.out.println(number);
            checkButton.setEnabled(true);
            int seconds = 20;
            int answer = JOptionPane.showConfirmDialog(null, "Do you want to start the game?", null, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null);
            if(answer == 0){
                startButton.setEnabled(false);
                countDown(seconds);
            }
        }
        
        if(e.getSource() == checkButton){
           
            try {
                guessedNumber = Integer.parseInt(textField.getText());
                if(guessedNumber == number){
                    attempts++;
                    JOptionPane.showMessageDialog(null, "It took you " + attempts + " attempts to guess the number.", null, JOptionPane.PLAIN_MESSAGE);
                    System.exit(0);
                }
                else if(guessedNumber > number){
                    attempts++;
                    guesses.add(guessedNumber);
                    System.out.println(guesses.toString().replace("[", "").replace("]", ""));
                    JOptionPane.showMessageDialog(null, "The guessed number is too high.\nPrevious attempts: " + guesses.toString().replace("[", "").replace("]", "") + " ", null, JOptionPane.PLAIN_MESSAGE);
                    textField.setText(null);
                }6
                else if(guessedNumber < number){
                    attempts++;
                    guesses.add(guessedNumber);
                    System.out.println(guesses.toString().replace("[", "").replace("]", ""));
                    JOptionPane.showMessageDialog(null, "The guessed number is too low.\nPrevious attempts: " + guesses.toString().replace("[", "").replace("]", "") + " ", null, JOptionPane.PLAIN_MESSAGE);
                    textField.setText(null);
                }
                
            } catch (Exception E) {
                attempts++;
                JOptionPane.showMessageDialog(null, "Type a number!", "Wrong input", JOptionPane.ERROR_MESSAGE);
                textField.setText(null);
            }
        }
    }
    public void countDown(int seconds){
         countThread = new Thread(new Runnable() {
                @Override
                public void run(){
                    for(int i = seconds; i >= 0; i--){
                        try {
                            Thread.sleep(1000);
                            System.out.println(i);
                        } catch (Exception E) {
                            //E.printStackTrace();
                        }
                    }
                    
                    System.exit(0);
                }
            });
            countThread.start();
    }
    
}
