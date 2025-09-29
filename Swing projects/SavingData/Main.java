package SavingData;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Main implements ActionListener{
    public static void main(String[] args) {
        new Main();
    }

    JTextArea textArea;
    JTextField textField;
    String playerName = "default";
    JButton btn1, btn2, btn3, btn4;
    int playerLevel = 1;
    int playerHp = 10;

    Main(){
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(500, 500);
        window.setLayout(null);
    

        textArea = new JTextArea();
        textArea.setBounds(50, 50, 300, 150);
        
        textField = new JTextField();
        textField.setBounds(50, 200, 200, 50);
        textField.addActionListener(this);

        btn1 = new JButton("Level up");
        btn1.setBounds(50, 250, 200, 50);
        btn1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                playerLevel++;
                updateText();
            }
            
        });

        btn2 = new JButton("Hp up");
        btn2.setBounds(50, 300, 200, 50);
        btn2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                playerHp++;
                updateText();
            }
            
        });

        btn3 = new JButton("Save");
        btn3.setBounds(50, 350, 200, 50);
        btn3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FileOutputStream fos = new FileOutputStream("save.dat");
                    BufferedOutputStream bos = new BufferedOutputStream(fos);
                    ObjectOutputStream oos = new ObjectOutputStream(bos);

                    DataStorage dStorage = new DataStorage();
                    dStorage.playerName = playerName;
                    dStorage.playerLevel = playerLevel;
                    dStorage.playerHp = playerHp;

                    oos.writeObject(dStorage);
                    oos.close();

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            
        });

        btn4 = new JButton("Load");
        btn4.setBounds(50, 400, 200, 50);
        btn4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FileInputStream fis = new FileInputStream("save.dat");
                    BufferedInputStream bis = new BufferedInputStream(fis);
                    ObjectInputStream ois = new ObjectInputStream(bis);
                    
                    DataStorage dStorage = (DataStorage)ois.readObject();

                    playerName = dStorage.playerName;
                    playerLevel = dStorage.playerLevel;
                    playerHp = dStorage.playerHp;

                    ois.close();

                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch(ClassNotFoundException ex){
                    ex.printStackTrace();
                }

                updateText();
            }
            
        });


        window.add(textArea);
        window.add(textField);
        window.add(btn1);
        window.add(btn2);
        window.add(btn3);
        window.add(btn4);
        updateText();
        window.setVisible(true);
        }

        public void updateText(){
            textArea.setText("Name: " + playerName + "\nLevel: " + playerLevel + "\nHp: " + playerHp);
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == textField){
            playerName = textField.getText();
            updateText();
        }
    };
    


}
