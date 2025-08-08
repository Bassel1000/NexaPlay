import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

public class Main {
    
    public static void main(String[] args) {
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Rectangle bounds = env.getMaximumWindowBounds();
        int width = bounds.width;
        int height = bounds.height;
        
    // Start at the Login screen (users can navigate to Register from there)
    Login loginPage = new Login(width, height);
    loginPage.setVisible(true);
    }
}