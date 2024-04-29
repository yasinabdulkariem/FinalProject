import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class FruitNinjaView extends JFrame{
    private final int WINDOW_WIDTH = 1000;
    private final int WINDOW_HEIGHT = 800;
    private final int TITLE_BAR_HEIGHT = 23;
    private FruitNinja f;
    public FruitNinjaView(FruitNinja f) {
        // TODO: initialize the View's instance variables.
//        bubbles = new ImageIcon("Resources/bubbles.jpg").getImage();
//        this.aquariumImage = aquariumImage;
//        this.fishImages = fishImages;
        this.f = f;

        // Set up the window and the buffer strategy.
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Fruit Ninja");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
        createBufferStrategy(2);
    }

    public void paint(Graphics g) {
        BufferStrategy bf = this.getBufferStrategy();
        if (bf == null)
            return;
        Graphics g2 = null;
        try {
            g2 = bf.getDrawGraphics();
            myPaint(g2);
        }
        finally {
            g2.dispose();
        }
        bf.show();
        Toolkit.getDefaultToolkit().sync();
    }

    public void myPaint(Graphics g) {
        // TODO: Write the paint method.

    }
}
