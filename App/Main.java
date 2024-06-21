import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

public class Main {
    
    public static void main(String[] args) {
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Rectangle bounds = env.getMaximumWindowBounds();
        int width = bounds.width;
        int height = bounds.height;
        
        // Create an instance of the Register class
        Register registerPage = new Register(width, height);
        // Display the registration page
        registerPage.setVisible(true);
    }
}