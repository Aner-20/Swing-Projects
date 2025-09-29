package Rps;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Game extends JFrame implements ActionListener {

    JLabel label;
    JPanel panel;
    Font font = new Font("New Times Roman", Font.PLAIN, 25);
    JButton rockButton, paperButton, scissorsButton;
    JButton[] functionButtons = new JButton[3];
    String[] items = {"Rock", "Paper", "Scissors"};
    Random random = new Random();
    String player = "";
    String computer = "";

    Game(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Rock Paper Scissors Game");
        this.setLayout(new FlowLayout());
        this.setSize(500, 250);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        label = new JLabel();
        label.setText("Click one of the buttons to start the game.");
        label.setBounds(40, 0, 400, 50);
        label.setFont(font);
        label.setOpaque(true);

        rockButton = new JButton("Rock");
        paperButton = new JButton("Paper");
        scissorsButton = new JButton("Scissors");

        functionButtons[0] = rockButton;
        functionButtons[1] = paperButton;
        functionButtons[2] = scissorsButton;

        for(int i = 0; i < 3; i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(font);
            functionButtons[i].setFocusable(false);
        }

        panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 50));
        panel.add(rockButton);
        panel.add(paperButton);
        panel.add(scissorsButton);

        this.add(label);
        this.add(panel);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == rockButton){
        player = "Rock";
        int randomItem = random.nextInt(items.length);
        computer = items[randomItem];
        checkWinner(player, computer);
        
       }
       if(e.getSource() == paperButton){
        player = "Paper";
        int randomItem = random.nextInt(items.length);
        computer = items[randomItem];
        checkWinner(player, computer);
        
       }
       if(e.getSource() == scissorsButton){
        player = "Scissors";
        int randomItem = random.nextInt(items.length);
        computer = items[randomItem];
        checkWinner(player, computer);
        
       }
    }
    public void checkWinner(String player, String computer){
        //System.out.println("Player: " + player);
        //System.out.println("Foe: " + computer);
        switch (player) {
            case "Rock":
                if(computer.equals("Rock")){
                    JOptionPane.showMessageDialog(null, "Tie", null, JOptionPane.PLAIN_MESSAGE);
                    System.exit(0);
                }
                
                else if(computer.equals("Paper")){
                    JOptionPane.showMessageDialog(null, "You lose", null, JOptionPane.PLAIN_MESSAGE);
                    System.exit(0);
                }
                else if(computer.equals("Scissors")){
                    JOptionPane.showMessageDialog(null, "You win", null, JOptionPane.PLAIN_MESSAGE);
                    System.exit(0);
                }
                break;
            case "Paper":
                if(computer.equals("Paper")){
                    JOptionPane.showMessageDialog(null, "Tie", null, JOptionPane.PLAIN_MESSAGE);
                    System.exit(0);
                }
                else if(computer.equals("Scissors")){
                    JOptionPane.showMessageDialog(null, "You lose", null, JOptionPane.PLAIN_MESSAGE);
                    System.exit(0);
                }
                else if(computer.equals("Rock")){
                    JOptionPane.showMessageDialog(null, "You win", null, JOptionPane.PLAIN_MESSAGE);
                    System.exit(0);
                }
                break;
            case "Scissors":
                if(computer.equals("Scissors")){
                    JOptionPane.showMessageDialog(null, "Tie", null, JOptionPane.PLAIN_MESSAGE);
                    System.exit(0);
                }
                else if(computer.equals("Rock")){
                    JOptionPane.showMessageDialog(null, "You lose", null, JOptionPane.PLAIN_MESSAGE);
                    System.exit(0);
                }
                else if(computer.equals("Paper")){
                    JOptionPane.showMessageDialog(null, "You win", null, JOptionPane.PLAIN_MESSAGE);
                    System.exit(0);
                }
                break;
        }
    }
}
