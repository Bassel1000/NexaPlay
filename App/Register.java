import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public class Register extends JFrame {
    private JTextField usernameField;
    private JTextField emailField;
    private JPasswordField passwordField;

    // This map will store registered users' data
    public static Map<String, String[]> users = new HashMap<>();

    public Register(int width, int height) {
        setTitle("Register");
        setSize(width, height); // Increased size to accommodate new field
        getContentPane().setBackground(new Color(0x1a223a));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage("NexaPlay Template logo.png"));
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(0x1a223a));
        panel.setLayout(new GridLayout(4, 2)); // Adjusted grid layout for new field

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setForeground(new Color(0xf5875c));
        panel.add(emailLabel);

        emailField = new JTextField();
        panel.add(emailField);

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

        JButton registerButton = new JButton("Register");
        registerButton.setBackground(new Color(0xf5875c));
        registerButton.setForeground(new Color(0x1a223a));
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                 // Check if email is valid
                if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                    JOptionPane.showMessageDialog(null, "Invalid email format!");
                    return;
                 }

                // Check if password is at least 8 characters
                if (password.length() < 8) {
                    JOptionPane.showMessageDialog(null, "Password must be at least 8 characters!");
                    return;
                }

                // Check if user already exists
                if (users.containsKey(username)) {
                    JOptionPane.showMessageDialog(null, "User already exists!");
                    return;
                }

                // Store the new user's data
                users.put(username, new String[]{email, password});

                JOptionPane.showMessageDialog(null, "Registration Successful!");
                new Login(width,height).setVisible(true);
                dispose();
            }
        });
        panel.add(registerButton);
        // New button for users who already have an account
        JButton loginButton = new JButton("Already have an account?");
        loginButton.setBackground(new Color(0xf5875c));
        loginButton.setForeground(new Color(0x1a223a));
        loginButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        new Login(width,height).setVisible(true); // Open the login window
        dispose(); // Close the registration window
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
                new Register(bounds.width, bounds.height).setVisible(true);
            }
        });
    }
}