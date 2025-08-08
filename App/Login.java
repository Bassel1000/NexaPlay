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
    Theme.applyRoot(this);

    JPanel panel = new JPanel(new GridBagLayout());
    Theme.applyPanel(panel);
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(8, 8, 8, 8);
    gbc.fill = GridBagConstraints.HORIZONTAL;

    JLabel header = Theme.heading("Welcome back");
    JLabel sub = Theme.subtitle("Sign in to NexaPlay");
    JPanel headWrap = new JPanel();
    headWrap.setLayout(new BoxLayout(headWrap, BoxLayout.Y_AXIS));
    Theme.applyPanel(headWrap);
    headWrap.add(header);
    headWrap.add(sub);
    gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2; gbc.weightx = 1;
    panel.add(headWrap, gbc);

    gbc.gridwidth = 1; gbc.weightx = 0; gbc.gridy++;
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

    gbc.gridx = 0; gbc.gridy++; gbc.gridwidth = 2; gbc.weightx = 1;
    JButton loginButton = new JButton("Login");
    Theme.stylePrimary(loginButton);
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
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid Password!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "User does not exist!");
                }
                
            }
        });
        panel.add(loginButton, gbc);

        // Add Register navigation button
        gbc.gridy++; gbc.gridwidth = 2; gbc.weightx = 1;
        JButton registerNavButton = new JButton("Create an account");
        Theme.stylePrimary(registerNavButton);
        registerNavButton.addActionListener(evt -> {
            new Register(width, height).setVisible(true);
            dispose();
        });
        panel.add(registerNavButton, gbc);

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