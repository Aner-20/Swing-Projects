package OperationsGame;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Random;

public class Game implements ActionListener{
    JLabel livesText, scoreText, operation;
    JPanel infoPanel, gamePanel, buttonPanel;
    JTextField field;
    JButton checkButton;
    int lives = 3;
    int score = 0;
    Font myFont = new Font("Roboto", Font.PLAIN, 30);
    Random random = new Random();
    int num1 = random.nextInt(9) + 1;
    int num2 = random.nextInt(9) + 1;
    int sum = num1 + num2;

    Game(){
        JFrame frame = new JFrame("Math Game");
        frame.setResizable(false);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 325);
        frame.setLocationRelativeTo(null);

        infoPanel = new JPanel();
        BoxLayout infoLayout = new BoxLayout(infoPanel, BoxLayout.X_AXIS);
        infoPanel.setLayout(infoLayout);
        
        livesText = new JLabel();
        livesText.setText("Lives: " + String.valueOf(lives));
        livesText.setOpaque(true);
        livesText.setFont(myFont);

        scoreText = new JLabel();
        scoreText.setText("Score: " + String.valueOf(score));
        scoreText.setOpaque(true);
        scoreText.setFont(myFont);

        infoPanel.add(livesText);
        infoPanel.add(Box.createRigidArea(new Dimension(230, -100)));
        infoPanel.add(scoreText);

        gamePanel = new JPanel();
        gamePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 40));

        operation = new JLabel();
        operation.setText(String.valueOf(num1) + "+" + String.valueOf(num2) + " =");
        operation.setFont(myFont);
        operation.setOpaque(true);

        field = new JTextField();
        field.setFont(myFont);
        field.setPreferredSize(new Dimension(60, 40));
        field.setHorizontalAlignment(JTextField.CENTER);
        
        gamePanel.add(operation);
        gamePanel.add(field);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.setPreferredSize(new Dimension(500, 300));

        checkButton = new JButton();
        checkButton.addActionListener(this);
        checkButton.setFont(myFont);
        checkButton.setText("Check");
        checkButton.setFocusable(false);
        
        buttonPanel.add(checkButton);

        frame.add(infoPanel);
        frame.add(gamePanel);
        frame.add(buttonPanel);
        frame.setVisible(true);
    }

    public static void main(String[] args){
        Game frame = new Game();
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == checkButton){
            try {
                int input = Integer.parseInt(field.getText());
                
                if(input == sum){
                    score++;
                    JOptionPane.showMessageDialog(null, "The answer is correct", null, JOptionPane.PLAIN_MESSAGE);
                    field.setText("");

                    num1 = random.nextInt(9) + 1;
                    num2 = random.nextInt(9) + 1;
                    sum = num1 + num2;

                    operation.setText(String.valueOf(num1) + "+" + String.valueOf(num2) + " =");
                    scoreText.setText("Score: " + String.valueOf(score));

                }
                else if(input != sum){
                    lives--;
                    JOptionPane.showMessageDialog(null, "Wrong answer", null, JOptionPane.ERROR_MESSAGE);
                    livesText.setText("Lives: " + String.valueOf(lives));
                    field.setText("");
                }
                if(lives == 0){
                    JOptionPane.showMessageDialog(null, "You lose", null, JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }
                if(score == 10){
                    JOptionPane.showMessageDialog(null, "You win!", null, JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }
            } catch (Exception E) {
                JOptionPane.showMessageDialog(null, "Type a number!", "Wrong input", JOptionPane.ERROR_MESSAGE);
                field.setText(null);
            }
        }

    }
}
