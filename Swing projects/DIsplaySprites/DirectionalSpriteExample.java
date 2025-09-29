package DIsplaySprites;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DirectionalSpriteExample extends JPanel {

    BufferedImage spriteSheet;
    BufferedImage singleSprite;
    int spriteWidth, spriteHeight;

    enum Direction{
        UP, DOWN, LEFT, RIGHT
    }

    public DirectionalSpriteExample(String filePath, int row, int col){
        try {
            File file = new File(filePath);

            if (!file.exists()) {
                System.out.println("The file does not exist.");
                return;  // Exit the constructor if the file doesn't exist
            }

            // load the sprite sheet
            spriteSheet = ImageIO.read(file);

            spriteWidth = spriteSheet.getWidth() / 8;
            spriteHeight = spriteSheet.getHeight() / 8;

            // Extract the specific sprite from the sprite sheet
            singleSprite = spriteSheet.getSubimage(col * spriteWidth, row * spriteHeight, spriteWidth, spriteHeight);

        } catch (Exception e) {
            System.out.println("Error loading the sprite sheet.");
            e.printStackTrace();
        }
    }

    // Method to extract a single sprite from the sprite sheet
    //public BufferedImage getSprite(int row, int column){
    //    return spriteSheet.getSubimage(column * spriteWidth, row * spriteHeight, spriteWidth, spriteHeight);
    //}

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        if (singleSprite != null) {
            g2d.drawImage(singleSprite, 200, 200, null); // Draw the current sprite at (0, 0)
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Directional Sprite Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        int row = 4;
        int col = 5;
        DirectionalSpriteExample panel = new DirectionalSpriteExample("DIsplaySprites/images.png", row, col);

        frame.add(panel);
        frame.setVisible(true);
    }
}
