package TodoList;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.*;


public class Frame extends JFrame implements ActionListener {

    JTextField textField;
    JButton addButton;
    JButton deleteButton;
    JLabel label;
    HashMap <String, Integer> items = new HashMap<String, Integer>();
    ArrayList <JButton> buttons = new ArrayList<JButton>();
    JPanel panel1, panel2;
    GridBagConstraints c, c1, c2;
    
    int xLabel = 0;
    int yLabel = 0;
    int xButton = 1;
    int yButton = 0;
    int id;

    Frame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(350, 300);
        this.setTitle("Todo List");
        this.setLayout(new BorderLayout(30, 0));
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        textField = new JTextField();
        textField.setPreferredSize(new Dimension(120, 30));
        
        addButton = new JButton("Delete");
        addButton.addActionListener(this);
        addButton.setFocusable(false);
        addButton.setText("Add");

        panel1 = new JPanel();
        panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panel1.setPreferredSize(new Dimension(70, 70));
        panel1.add(textField);
        panel1.add(addButton);


        panel2 = new JPanel();
        panel2.setLayout(new GridBagLayout());
        c = new GridBagConstraints();

        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(2, 2, 2, 2);
        
        JScrollPane scrollPane = new JScrollPane(panel2);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);


        this.add(panel1, BorderLayout.NORTH);
        this.add(scrollPane);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String name = "";
        if(e.getSource() == addButton){
            yLabel++;
            yButton++;
            name = textField.getText();
            items.put(name, id);
            System.out.println(items);
            id++;
            
            label = new JLabel();
            label.setText(name);
            label.setFont(new Font(null, Font.PLAIN, 20));
            panel2.add(label, new GridBagConstraints(0, yLabel, 1, 1,1, 1, GridBagConstraints.NORTH, GridBagConstraints.NORTH, new Insets(10, 0, 0, 0), 0, 0));

            deleteButton = new JButton("Delete");
            buttons.add(deleteButton);
            buttons.forEach(button -> {
                
                button.setFocusable(false);
                button.putClientProperty("id", Integer.valueOf(id));
                button.setFont(new Font(null, Font.PLAIN, 20));
                button.addActionListener(this);
            });
            panel2.add(deleteButton, new GridBagConstraints(1, yButton, 1, 1,2, 1, GridBagConstraints.NORTH, GridBagConstraints.NORTH, new Insets(10, 0, 0, 0), 0, 0));
            
            this.setVisible(true);
        }

        buttons.forEach(button -> {
            if(e.getSource() == button){
                Object property = button.getClientProperty("id");
                if(property instanceof Integer){
                    int id = ((Integer) property);
                    if(id == 0){
                        System.out.println("Hello");
                    }
                }
            }
        });

    }
    
    
   
}
