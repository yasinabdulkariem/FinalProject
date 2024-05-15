import javax.swing.*;
import java.awt.*;
public class Fruit {
    private FruitNinjaView grid;
    private int x, y, dx, dy;

    private int gridWidth;
    private int gridHeight;
    private int fruitType;
    private Image[] fruitImages;

    public Fruit() {
        // Initialize fruit with default values
        this.grid = null;
        this.x = 0;
        this.y = 0;
        this.dx = 0;
        this.dy = 0;
        this.gridWidth = 0;
        this.gridHeight = 0;
        this.fruitType = 0;
        this.fruitImages = new Image[5];
    }
    public Fruit(FruitNinjaView grid, int fruitType, int x, int y, int dy){
        this.grid = grid;
        this.gridWidth = grid.getWidth();
        this.gridHeight = grid.getHeight();
        this.fruitType = fruitType;
        this.x = x;
        this.y = y;
        this.dy = dy;
        this.fruitImages = new Image[5];

        fruitImages[0] = new ImageIcon("Resources/apple.png").getImage();
        fruitImages[1] = new ImageIcon("Resources/banana.png").getImage();
        fruitImages[2] = new ImageIcon("Resources/pineapple.png").getImage();
        fruitImages[3] = new ImageIcon("Resources/pomegranate.png").getImage();
        fruitImages[4] = new ImageIcon("Resources/watermelon.png").getImage();
    }

    public void fruitDrop(){
        x += dx;
        y += dy;

        // Check if the fruit has reached the bottom of the screen
        if (y > gridHeight) {
            // Remove the fruit from the screen

        }
    }

    public boolean hitBottom()
    {
        if (y > gridHeight){
            return true;
        }
        return false;
    }
    public boolean contains(int mx, int my) {
        // Implement logic to check if the point (mx, my) is within the boundaries of the fruit
        Image fruitImage = fruitImages[fruitType];
        if (fruitImage != null) {
            int fruitWidth = fruitImage.getWidth(null);
            int fruitHeight = fruitImage.getHeight(null);
            return (mx >= x && mx <= x + fruitWidth && my >= y && my <= y + fruitHeight);
        }
        return false;
    }
    public void drawCut(){

    }

    public void draw(Graphics g){
        Image fruitImage = fruitImages[fruitType];
        if (fruitImage != null) {
            g.drawImage(fruitImage, x, y, grid);
        }
    }
}
