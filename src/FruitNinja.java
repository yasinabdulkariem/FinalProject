import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class FruitNinja implements ActionListener, MouseListener, MouseMotionListener{
    private FruitNinjaView window;
    private int score;
    private boolean isBombClicked;
    private static final int SLEEP_TIME = 110;
    private ArrayList<Fruit> fruits;

    public FruitNinja(){
        // Initialize the View, then create all the Fruit
        this.window = new FruitNinjaView(this);
        score = 0;
        fruits = new ArrayList<>();
        isBombClicked = false;

        for (int i = 0; i < 5; i++)
        {
            fruits.add(new Fruit (window, i,(int) (Math.random() * 1000), 0, (int) (Math.random() * 5 + 5)));
        }

        Timer clock = new Timer(SLEEP_TIME, this);
        clock.start();

        window.addMouseListener(this);
        window.addMouseMotionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < fruits.size(); i++){
            fruits.get(i).fruitDrop();
            //check if hit the bottom
            //remove if hit the bottom
        }
        // Update game state
        window.repaint(); // Repaint the game view to update its state

        // Check for game over conditions
        if (isGameOver()) {
            endGame();
        }
    }
    public void addFruit(Fruit fruit) {
        fruits.add(fruit);
    }
    public void removeFruit(Fruit fruit) {
        fruits.remove(fruit);
    }

    public void removeAllFruits() {
        fruits.clear(); // Clear the list of fruits
        this.window.repaint(); // Repaint the view to reflect the changes
    }
    public ArrayList<Fruit> getFruits(){
        return fruits;
    }
//    public void handlePlayerInput(int x, int y) {
//        // Check for collision with fruits
//        Fruit slicedFruit = checkCollision(x, y);
//        if (slicedFruit != null) {
//            // Fruit is sliced, update score
//            score += 10;
//            // Remove the sliced fruit from the view
//            removeFruit(slicedFruit);
//        }
//    }
//    public addMouseListener(new MouseAdapter() {
//        @Override
//        public void mouseClicked(MouseEvent e) {
//            handleMouseClick(e.getX(), e.getY());
//        }
//    }
    private void handleMouseClick(int x, int y) {
        // Check if any fruit was clicked
        for (Fruit fruit : fruits) {
            if (fruit.contains(x, y)) {
                fruits.remove(fruit); // Remove the clicked fruit
                break; // Exit loop since only one fruit can be clicked at a time
            }
        }
        this.window.repaint(); // Repaint the panel after updating the fruits
        if (isGameOver()) {
            endGame();
        }
    }
    // Method to check for collision with fruits
    public Fruit checkCollision(int mx, int my) {
        for (Fruit fruit : fruits) {
            if (fruit.contains(mx, my)) {
                return fruit;
            }
        }
        return null; // No collision detected
    }

    // Getter method for the score
    public int getScore() {
        return score;
    }


    public void setBombClicked(boolean bombClicked) {
        this.isBombClicked = bombClicked;
    }

    public void endGame() {
        // Reset the game state
        score = 0; // Reset the score
        removeAllFruits(); // Remove all fruits from the view
        window.repaint(); // Repaint the view to reflect the changes
    }
    public boolean isGameOver() {
        // Check if a bomb was clicked
        for (Fruit fruit: fruits)
        {
            if(isBombClicked || fruit.hitBottom())
            {
                return true;
            }
        }
        return false;
    }
    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }
    public void mouseClicked(MouseEvent e) {
        int xMouse = e.getX();
        int yMouse = e.getY();
        if(fruits.contains()){
            removeAllFruits();
        }
        window.repaint();
    }
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    // This method gets called every time you click and drag
    public void mouseDragged(MouseEvent e) {
    }

    // This method gets called everytime you move the mouse, EVEN IF YOU DON'T CLICK
    public void mouseMoved(MouseEvent e) {
    }
    public static void main(String[] args) {
        FruitNinja game = new FruitNinja();
    }
}