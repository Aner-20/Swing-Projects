package DIsplaySprites;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.function.BiFunction;

import javax.imageio.ImageIO;

import javax.swing.*;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;


public class SpriteSheetExample extends JPanel {
    BufferedImage spriteSheet;
    BufferedImage[] selectedRows;
    ArrayList<String> spritePaths;
    String spritePath;

    public SpriteSheetExample(){
        try {   
            File file = new File("DIsplaySprites/images.png");

            if (!file.exists()) {
                System.out.println("The file does not exist.");
                return;  // Exit the constructor if the file doesn't exist
            }

            spriteSheet = ImageIO.read(file);

            int spriteWidth = spriteSheet.getWidth() / 8; 
            int spriteHeight = spriteSheet.getHeight() / 8; 
            selectedRows = new BufferedImage[4];
            spritePaths = new ArrayList<>();

            int[] rows = {0, 2, 4, 6};

            for(int i = 0; i < rows.length; i++){
                selectedRows[i] = spriteSheet.getSubimage(0, rows[i] * spriteHeight, spriteSheet.getWidth(), spriteHeight);

                // Generate paths for sprites in this row
                for(int j = 0; j < 8; j++){
                    switch (rows[i]) {
                        case 0:
                            spritePath = "player_down_" + j + ".png"; 
                            break;

                        case 2:
                            spritePath = "player_left_" + j + ".png"; 
                            break;

                        case 4:
                            spritePath = "player_up_" + j + ".png"; 
                            break;

                        case 6:
                            spritePath = "player_right_" + j + ".png"; 
                            break;
                    
                        default:
                            break;
                        
                        
                    }
                    spritePaths.add(spritePath);
                }

            }

            for(String path : spritePaths){
                System.out.println(path);
            }

        } catch (Exception e) {
            System.out.println("Error loading the sprite sheet.");
            e.printStackTrace();
        }
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        if(selectedRows != null){
            for(int i = 0; i < selectedRows.length; i++){
                g2d.drawImage(selectedRows[i], 0, i * selectedRows[i].getHeight(), null);
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sprite Sheet Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        SpriteSheetExample panel = new SpriteSheetExample();

        frame.add(panel);
        frame.setVisible(true);
    }
}
