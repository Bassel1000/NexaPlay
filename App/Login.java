import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public Login(int width, int height) {
        setTitle("Login");
        setSize(width, height);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage("NexaPlay Template logo.png"));
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(0x1a223a));
        panel.setLayout(new GridLayout(3, 2));

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setForeground(new Color(0xf5875c));
        panel.add(usernameLabel);

        usernameField = new JTextField();
        panel.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(new Color(0xf5875c));
        panel.add(passwordLabel);

        passwordField = new JPasswordField();
        panel.add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.setBackground(new Color(0xf5875c));
        loginButton.setForeground(new Color(0x1a223a));
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // Check if user exists from the registered users
                if (Register.users.containsKey(username)) {
                    String[] data = Register.users.get(username);
                    if (data[1].equals(password)) {
                        JOptionPane.showMessageDialog(null, "Login Successful!");
                        Window window = new NexaPlay.Window(width, height);
                        window.setVisible(true);  
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid Password!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "User does not exist!");
                }
                
            }
        });
        panel.add(loginButton);

        getContentPane().add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
                Rectangle bounds = env.getMaximumWindowBounds();
                new Login(bounds.width, bounds.height).setVisible(true);
            }
        });
    }
}