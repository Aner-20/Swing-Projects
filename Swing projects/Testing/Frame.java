package Testing;

import javax.swing.*;

import java.awt.FlowLayout;
import java.awt.event.*;
import java.util.ArrayList;

import Testing.Button;

public class Frame extends JFrame implements ActionListener{
    String text;
    int id;
    Button btn1, btn2, btn3;
    ArrayList <Button> buttons = new ArrayList<Button>();
    Frame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 300);
        this.setTitle(null);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        btn1 = new Button("Button", 1);
        btn1.setBounds(0, 0, 60, 40);
        btn2 = new Button("Button 2", 2);
        btn2.setBounds(30, 30, 60, 40);
        btn3 = new Button("Button 3", 3);
        btn3.setBounds(70, 70, 60, 40);

        buttons.add(btn1);
        buttons.add(btn2);
        buttons.add(btn3);

        buttons.forEach(button -> {
            button.setText("Click");
            button.setFocusable(false);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    System.out.println(button.idButton);
                    switch(button.idButton){
                        case 1:
                            System.out.println("First");
                            break;
                        case 2:
                            System.out.println("Second");
                            break;
                        case 3:
                            removeButton(button.idButton);
                            System.out.println("Third");
                            break;
                    }
                }
            });
        });

        this.add(btn1);
        this.add(btn2);
        this.add(btn3);
        this.setVisible(true);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
       
       };

       public void removeButton(int id){
            if(id == 3){
                btn3.setOpaque(true);
                this.remove(btn3);

            }
       }
    }

        
    
