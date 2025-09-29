package ClickSquare;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.Random;

import ClickSquare.Canvas;

public class Box extends Rectangle {
    Color color;
    int xPosition;
    int yPosition;
    static int score;
    static Random random = new Random();
    Box(int x, int y, int width, int height, Color color){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }


    public void mousePressed(MouseEvent e){
        xPosition = e.getX();
        yPosition = e.getY();
        
        System.out.println("Xposition: " + xPosition + " yPosition; " + yPosition);
        System.out.println("Thisx: " + this.x  + " thisy: " + this.y);
        if(xPosition - this.x < 50 &&  xPosition - this.x > -50 
        && yPosition - this.y < 50 && yPosition - this.y > -50){
            score++;
            System.out.println(score);
        }
        
    }
    public void draw(Graphics g){
        g.setColor(this.color);
        this.x = random.nextInt(350);
        this.y = random.nextInt(350);
        g.fillRect(this.x, this.y, this.width, this.height);
    }
}
