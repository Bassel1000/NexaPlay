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
    setSize(width, height);
    Theme.applyRoot(this);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setIconImage(Toolkit.getDefaultToolkit().getImage("NexaPlay Template logo.png"));
    setLocationRelativeTo(null);

    JPanel panel = new JPanel(new GridBagLayout());
    Theme.applyPanel(panel);
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(8, 8, 8, 8);
    gbc.fill = GridBagConstraints.HORIZONTAL;

    JLabel head = Theme.heading("Create your account");
    JLabel sub = Theme.subtitle("Join NexaPlay to discover and play games");
    JPanel headWrap = new JPanel();
    headWrap.setLayout(new BoxLayout(headWrap, BoxLayout.Y_AXIS));
    Theme.applyPanel(headWrap);
    headWrap.add(head);
    headWrap.add(sub);
    gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2; gbc.weightx = 1;
    panel.add(headWrap, gbc);

    gbc.gridwidth = 1; gbc.gridy++; gbc.weightx = 0;
    JLabel emailLabel = new JLabel("Email:");
    emailLabel.setForeground(Theme.ACCENT);
    panel.add(emailLabel, gbc);

    gbc.gridx = 1; gbc.weightx = 1;
    emailField = new JTextField();
    emailField.setBackground(Theme.BG_ELEVATED);
    emailField.setForeground(Theme.TEXT_PRIMARY);
    emailField.setCaretColor(Theme.TEXT_PRIMARY);
    emailField.setBorder(BorderFactory.createEmptyBorder(8, 10, 8, 10));
    panel.add(emailField, gbc);

    gbc.gridx = 0; gbc.gridy++; gbc.weightx = 0;
    JLabel usernameLabel = new JLabel("Username:");
    usernameLabel.setForeground(Theme.ACCENT);
    panel.add(usernameLabel, gbc);

    gbc.gridx = 1; gbc.weightx = 1;
    usernameField = new JTextField();
    usernameField.setBackground(Theme.BG_ELEVATED);
    usernameField.setForeground(Theme.TEXT_PRIMARY);
    usernameField.setCaretColor(Theme.TEXT_PRIMARY);
    usernameField.setBorder(BorderFactory.createEmptyBorder(8, 10, 8, 10));
    panel.add(usernameField, gbc);

    gbc.gridx = 0; gbc.gridy++; gbc.weightx = 0;
    JLabel passwordLabel = new JLabel("Password:");
    passwordLabel.setForeground(Theme.ACCENT);
    panel.add(passwordLabel, gbc);

    gbc.gridx = 1; gbc.weightx = 1;
    passwordField = new JPasswordField();
    passwordField.setBackground(Theme.BG_ELEVATED);
    passwordField.setForeground(Theme.TEXT_PRIMARY);
    passwordField.setCaretColor(Theme.TEXT_PRIMARY);
    passwordField.setBorder(BorderFactory.createEmptyBorder(8, 10, 8, 10));
    panel.add(passwordField, gbc);

    gbc.gridx = 0; gbc.gridy++; gbc.gridwidth = 2;
    JButton registerButton = new JButton("Register");
    Theme.stylePrimary(registerButton);
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
    panel.add(registerButton, gbc);
        // New button for users who already have an account
    gbc.gridy++; gbc.gridwidth = 2;
    JButton loginButton = new JButton("Already have an account?");
    Theme.stylePrimary(loginButton);
        loginButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        new Login(width,height).setVisible(true); // Open the login window
        dispose(); // Close the registration window
    }
});
panel.add(loginButton, gbc);

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