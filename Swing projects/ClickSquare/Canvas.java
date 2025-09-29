package ClickSquare;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;
import java.util.Random;
import ClickSquare.Box;
import javax.swing.*;

public class Canvas extends JPanel{

    final int CANVAS_WIDTH = 400;
    final int CANVAS_HEIGHT = 400;
    public int xStrPosition = 20;
    public int yStrPosition = 40;
    static Random random = new Random();
    boolean state = true;
    
    Box rectangle;
    Canvas(){
        this.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
        this.setBackground(Color.black);
        rectangle = new Box(0, 0,50, 50, Color.white);
        this.addMouseListener(new ML());
    }

    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;
        rectangle.draw(g);
        
        g2D.drawString("Hello", xStrPosition, yStrPosition);

    }

    public class ML extends MouseAdapter{
        @Override
        public void mousePressed(MouseEvent e){
            if(state == true){
                rectangle.mousePressed(e);
                repaint();
                if(Box.score == 10){
                    state = false;
                }
            }
            
        }
    }

}
