package TextAdventure;

import java.awt.Font;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Menu extends JFrame implements ActionListener {

    JButton startButton, exitButton;

    Menu(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);
        this.setTitle("Text adventure");
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        startButton = new JButton();
        startButton.addActionListener(this);
        startButton.setText("Start");
        startButton.setFocusable(false);
        startButton.setFont(new Font("Comic Sans", Font.BOLD, 25));
        startButton.setBounds(150, 50, 100, 50);

        exitButton = new JButton();
        exitButton.addActionListener(this);
        exitButton.setText("Exit");
        exitButton.setFocusable(false);
        exitButton.setFont(new Font("Comic Sans", Font.BOLD, 25));
        exitButton.setBounds(150, 150, 100, 50);

        this.add(startButton);
        this.add(exitButton);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == startButton){
            this.dispose();
            Game game = new Game();
        }
        if(e.getSource() == exitButton){
            System.exit(0);
        }
    }
    
}
