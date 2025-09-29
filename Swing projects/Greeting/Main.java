package Greeting;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Clock.MyFrame;

public class Main {

    JFrame frame;
    String user = "Andrea";
    JLabel greeting;
    Date date = new Date();
    Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
    Main(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Greeting");
        frame.setLayout(new FlowLayout());
        frame.setSize(400, 150);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        greeting = new JLabel();
        greeting.setFont(new Font("Verdana", Font.PLAIN, 30));
        //greeting.setText("Good Morning " + user);
        greeting.setOpaque(true);  // to view background

        
        frame.add(greeting);
        //frame.getContentPane().setBackground(Color.green);
        setTime(frame);
        frame.setVisible(true);
    }

    public void setTime(JFrame frame){
        //calendar.setTime(date);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        
        if(hour >= 0 && hour <= 6){
            greeting.setText("Good night " + user);
            greeting.setForeground(new Color(0xfffa65));
            greeting.setBackground(new Color(0x130f40));
            frame.getContentPane().setBackground(new Color(0x130f40));
            
        }
        else if(hour >= 6 && hour <= 12){
            greeting.setText("Good morning " + user);
            greeting.setForeground(new Color(0xdff9fb));
            greeting.setBackground(new Color(0x1e90ff));
            frame.getContentPane().setBackground(new Color(0x1e90ff));
            
        }
        else if(hour >= 12 && hour <= 18){
            greeting.setText("Good afternoon " + user);
            greeting.setForeground(new Color(0xffa502));
            greeting.setBackground(new Color(0x3742fa));
            frame.getContentPane().setBackground(new Color(0x3742fa));
            
        }
        else if(hour >= 18 && hour <= 24){
            greeting.setText("Good evening " + user);
            greeting.setForeground(new Color(0xfbc531));
            greeting.setBackground(new Color(0x273c75));
            frame.getContentPane().setBackground(new Color(0x273c75));
            
        }
        
    }

    public static void main(String[] args){
        Main frame = new Main();
    }
}
