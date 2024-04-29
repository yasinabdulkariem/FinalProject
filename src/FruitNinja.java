import javax.swing.*;
import java.awt.event.*;
public class FruitNinja implements ActionListener{
    private FruitNinjaView window;

    public FruitNinja(){
        // Initialize the View, then create all the Fruit
        this.window = new FruitNinjaView(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        FruitNinja game = new FruitNinja();
    }
}