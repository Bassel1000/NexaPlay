import javax.swing.*;
import java.awt.*;
import Snake.code.Snake;
public class NexaPlay {

    public static class Window extends JFrame {
        public Window(int width, int height) {
            setSize(width, height);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setTitle("NexaPlay");
            setIconImage(Toolkit.getDefaultToolkit().getImage("NexaPlay Template logo.png"));
            getContentPane().setBackground(new Color(0x1a223a));

    

            // Create the tabbed pane and panels
            JTabbedPane tabbedPane = new JTabbedPane();
            tabbedPane.setFont(new Font("Arial", Font.BOLD, 20)); // Set the font of the tabs
            tabbedPane.setBackground(new Color(0xf5875c)); // Set the background color of the tabs
            tabbedPane.setForeground(new Color(0x1a223a)); // Set the text color of the tabs
            tabbedPane.setPreferredSize(new Dimension(width, height)); // Set the preferred size of the tabbed pane

            JPanel storePanel = new JPanel();
            storePanel.setBackground(new Color(0x1a223a));
            storePanel.setForeground(new Color(0xf5875c));       
            JPanel libraryPanel = new JPanel();
            libraryPanel.setForeground(new Color(0xf5875c));
            libraryPanel.setBackground(new Color(0x1a223a));

            // Create the image buttons
            JButton button1 = new JButton("Tic Tac Toe");
            button1.setFont(new Font("Arial", Font.BOLD, 20)); // Set the font
            button1.setForeground(new Color(0xf5875c)); // Set the text color
            button1.setBackground(new Color(0x1a223a)); // Set the background color
            button1.setIcon(new ImageIcon("Tic Tac Toe Logo.jpeg")); // Set the image
            button1.setPreferredSize(new Dimension(300, 300)); // Set the preferred size
            button1.setBorderPainted(false); // Remove the border
            button1.addActionListener(e -> {
                
                // Open a new window
                JFrame newWindow = new JFrame();
                newWindow.setExtendedState(JFrame.MAXIMIZED_BOTH);
                newWindow.getContentPane().setBackground(new Color(0x1a223a));
                newWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                newWindow.setTitle("Tic Tac Toe");
                newWindow.setLayout(new FlowLayout());
                

                // Create the image label
                JLabel imageLabel = new JLabel();
                ImageIcon imageIcon = new ImageIcon("Tic Tac Toe Logo.jpeg");
                Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
                imageIcon = new ImageIcon(image);
                imageLabel.setIcon(imageIcon);
                newWindow.add(imageLabel);

                // Create the text label
                JLabel textLabel = new JLabel("Tic Tac Toe");
                textLabel.setFont(new Font("Arial", Font.BOLD, 40));
                textLabel.setForeground(new Color(0xf5875c));
                newWindow.add(textLabel);
                
 
            
                // Create the first 300x300 image
                JLabel imageLabel2 = new JLabel();
                ImageIcon imageIcon2 = new ImageIcon("Tic Tac Toe Image1.jpeg");
                Image image2 = imageIcon2.getImage().getScaledInstance(354, 362, Image.SCALE_DEFAULT);
                imageIcon2 = new ImageIcon(image2);
                imageLabel2.setIcon(imageIcon2);
                newWindow.add(imageLabel2);

                // Create the second 300x300 image
                JLabel imageLabel3 = new JLabel();
                ImageIcon imageIcon3 = new ImageIcon("Tic Tac Toe Image2.jpeg");
                Image image3 = imageIcon3.getImage().getScaledInstance(356, 360, Image.SCALE_DEFAULT);
                imageIcon3 = new ImageIcon(image3);
                imageLabel3.setIcon(imageIcon3);
                newWindow.add(imageLabel3);

                // Create the third 300x300 image
                JLabel imageLabel4 = new JLabel();
                ImageIcon imageIcon4 = new ImageIcon("Tic Tac Toe Image3.jpeg");
                Image image4 = imageIcon4.getImage().getScaledInstance(356, 362, Image.SCALE_DEFAULT);
                imageIcon4 = new ImageIcon(image4);
                imageLabel4.setIcon(imageIcon4);
                newWindow.add(imageLabel4);

                JButton Playbutton = new JButton("Play Tic Tac Toe");
                Playbutton.setIcon(new ImageIcon("Tic Tac Toe Logo.jpeg")); // Set the image
                Playbutton.setPreferredSize(new Dimension(200, 200)); // Set the preferred size
                Playbutton.setVerticalTextPosition(SwingConstants.BOTTOM); // Position the text below the imag
                Playbutton.setPreferredSize(new Dimension(200, 200));
                Playbutton.setFont(new Font("Arial", Font.BOLD, 20)); // Set the font
                Playbutton.setForeground(new Color(0x1a223a)); // Set the text color
                Playbutton.setBackground(new Color(0xf5875c)); // Set the background color
                Playbutton.addActionListener(event -> {

                    // Open the Tic Tac Toe game
                    new TicTacToeGame();

                });
                

                // Create the purchase button
                JButton AddtoLibraryButton = new JButton("Add to Library");
                AddtoLibraryButton.setPreferredSize(new Dimension(200, 50));
                AddtoLibraryButton.setFont(new Font("Arial", Font.BOLD, 20)); // Set the font
                AddtoLibraryButton.setForeground(new Color(0x1a223a)); // Set the text color
                AddtoLibraryButton.setBackground(new Color(0xf5875c)); // Set the background color
                AddtoLibraryButton.addActionListener(event -> {

                    // Add the game to the library panel
                    libraryPanel.add(Playbutton); // Replace button1 with the appropriate button for the game
                    libraryPanel.revalidate();
                    libraryPanel.repaint();

                });
                newWindow.add(AddtoLibraryButton);

                newWindow.setVisible(true);
            });
            storePanel.add(button1);

            // Create the image buttons
            JButton button2 = new JButton("Guess The Number");
            button2.setFont(new Font("Arial", Font.BOLD, 20)); // Set the font
            button2.setForeground(new Color(0xf5875c)); // Set the text color
            button2.setBackground(new Color(0x1a223a)); // Set the background color
            button2.setIcon(new ImageIcon("Guess the Number Logo.jpeg")); // Set the image
            button2.setPreferredSize(new Dimension(300, 300)); // Set the preferred size
            button2.setBorderPainted(false); // Remove the border
            button2.addActionListener(e -> {

                // Open a new window
                JFrame newWindow = new JFrame();
                newWindow.setExtendedState(JFrame.MAXIMIZED_BOTH);
                newWindow.getContentPane().setBackground(new Color(0x1a223a));
                newWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                newWindow.setTitle("Guess The Number");
                newWindow.setLayout(new FlowLayout());

                // Create the image label
                JLabel imageLabel = new JLabel();
                ImageIcon imageIcon = new ImageIcon("Guess the Number Logo.jpeg");
                Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
                imageIcon = new ImageIcon(image);
                imageLabel.setIcon(imageIcon);
                newWindow.add(imageLabel);

                // Create the text label
                JLabel textLabel = new JLabel("Guess The Number");
                textLabel.setFont(new Font("Arial", Font.BOLD, 40));
                textLabel.setForeground(new Color(0xf5875c));
                newWindow.add(textLabel);

                // Create the first 300x300 image
                JLabel imageLabel2 = new JLabel();
                ImageIcon imageIcon2 = new ImageIcon("Guess_The_Number_1.png");
                Image image2 = imageIcon2.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
                imageIcon2 = new ImageIcon(image2);
                imageLabel2.setIcon(imageIcon2);
                newWindow.add(imageLabel2);

                // Create the second 300x300 image
                JLabel imageLabel3 = new JLabel();
                ImageIcon imageIcon3 = new ImageIcon("Guess_The_Number_2.png");
                Image image3 = imageIcon3.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
                imageIcon3 = new ImageIcon(image3);
                imageLabel3.setIcon(imageIcon3);
                newWindow.add(imageLabel3);

                // Create the third 300x300 image
                JLabel imageLabel4 = new JLabel();
                ImageIcon imageIcon4 = new ImageIcon("Guess_The_Number_3.png");
                Image image4 = imageIcon4.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
                imageIcon4 = new ImageIcon(image4);
                imageLabel4.setIcon(imageIcon4);
                newWindow.add(imageLabel4);

                JButton Playbutton = new JButton("Play Guess The Number");
                Playbutton.setIcon(new ImageIcon("Guess the Number Logo.jpeg")); // Set the image
                Playbutton.setPreferredSize(new Dimension(200, 200)); // Set the preferred size
                Playbutton.setVerticalTextPosition(SwingConstants.BOTTOM); // Position the text below the imag
                Playbutton.setPreferredSize(new Dimension(200, 200));
                Playbutton.setFont(new Font("Arial", Font.BOLD, 20)); // Set the font
                Playbutton.setForeground(new Color(0x1a223a)); // Set the text color
                Playbutton.setBackground(new Color(0xf5875c)); // Set the background color
                Playbutton.addActionListener(event -> {

                    // Open the Guess The Number game
                    new GuessTheNumberGame();
                });

                // Create the purchase button
                JButton AddtoLibraryButton = new JButton("Add to Library");
                AddtoLibraryButton.setPreferredSize(new Dimension(200, 50));
                AddtoLibraryButton.setFont(new Font("Arial", Font.BOLD, 20)); // Set the font
                AddtoLibraryButton.setForeground(new Color(0x1a223a)); // Set the text color
                AddtoLibraryButton.setBackground(new Color(0xf5875c)); // Set the background color
                AddtoLibraryButton.addActionListener(event -> {
                    // Add the game to the library panel
                    libraryPanel.add(Playbutton); // Replace button1 with the appropriate button for the game
                    libraryPanel.revalidate();
                    libraryPanel.repaint();

                });
                newWindow.add(AddtoLibraryButton);

                newWindow.setVisible(true);
            });
            storePanel.add(button2);
            
            JButton button3 = new JButton("Hangman");
            button3.setFont(new Font("Arial", Font.BOLD, 20)); // Set the font
            button3.setForeground(new Color(0xf5875c)); // Set the text color
            button3.setBackground(new Color(0x1a223a)); // Set the background color
            button3.setIcon(new ImageIcon("Hangman Logo.jpeg")); // Set the image
            button3.setPreferredSize(new Dimension(300, 300)); // Set the preferred size
            button3.setBorderPainted(false); // Remove the border
            button3.addActionListener(e -> {
                
                // Open a new window
                JFrame newWindow = new JFrame();
                newWindow.setExtendedState(JFrame.MAXIMIZED_BOTH);
                newWindow.getContentPane().setBackground(new Color(0x1a223a));
                newWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                newWindow.setTitle("Hangman");
                newWindow.setLayout(new FlowLayout());
                

                // Create the image label
                JLabel imageLabel = new JLabel();
                ImageIcon imageIcon = new ImageIcon("Hangman Logo.jpeg");
                Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
                imageIcon = new ImageIcon(image);
                imageLabel.setIcon(imageIcon);
                newWindow.add(imageLabel);

                // Create the text label
                JLabel textLabel = new JLabel("Hangman");
                textLabel.setFont(new Font("Arial", Font.BOLD, 40));
                textLabel.setForeground(new Color(0xf5875c));
                newWindow.add(textLabel);
                
 
            
                // Create the first 300x300 image
                JLabel imageLabel2 = new JLabel();
                ImageIcon imageIcon2 = new ImageIcon("Hangman Image1.png");
                Image image2 = imageIcon2.getImage().getScaledInstance(354, 362, Image.SCALE_DEFAULT);
                imageIcon2 = new ImageIcon(image2);
                imageLabel2.setIcon(imageIcon2);
                newWindow.add(imageLabel2);

                // Create the second 300x300 image
                JLabel imageLabel3 = new JLabel();
                ImageIcon imageIcon3 = new ImageIcon("Hangman Image2.png");
                Image image3 = imageIcon3.getImage().getScaledInstance(356, 360, Image.SCALE_DEFAULT);
                imageIcon3 = new ImageIcon(image3);
                imageLabel3.setIcon(imageIcon3);
                newWindow.add(imageLabel3);

                // Create the third 300x300 image
                JLabel imageLabel4 = new JLabel();
                ImageIcon imageIcon4 = new ImageIcon("Hangman Image3.png");
                Image image4 = imageIcon4.getImage().getScaledInstance(356, 362, Image.SCALE_DEFAULT);
                imageIcon4 = new ImageIcon(image4);
                imageLabel4.setIcon(imageIcon4);
                newWindow.add(imageLabel4);

                JButton Playbutton = new JButton("Play Hangman");
                Playbutton.setIcon(new ImageIcon("Hangman Logo.jpeg")); // Set the image
                Playbutton.setPreferredSize(new Dimension(200, 200)); // Set the preferred size
                Playbutton.setVerticalTextPosition(SwingConstants.BOTTOM); // Position the text below the imag
                Playbutton.setPreferredSize(new Dimension(200, 200));
                Playbutton.setFont(new Font("Arial", Font.BOLD, 20)); // Set the font
                Playbutton.setForeground(new Color(0x1a223a)); // Set the text color
                Playbutton.setBackground(new Color(0xf5875c)); // Set the background color
                Playbutton.addActionListener(event -> {

                    // Open the Hangman game
                    new HangmanGame();
                    
                });
                
                JButton AddtoLibraryButton = new JButton("Add to Library");
                AddtoLibraryButton.setPreferredSize(new Dimension(200, 50));
                AddtoLibraryButton.setFont(new Font("Arial", Font.BOLD, 20)); // Set the font
                AddtoLibraryButton.setForeground(new Color(0x1a223a)); // Set the text color
                AddtoLibraryButton.setBackground(new Color(0xf5875c)); // Set the background color
                AddtoLibraryButton.addActionListener(event -> {
                    // Add the game to the library panel
                    libraryPanel.add(Playbutton); // Replace button1 with the appropriate button for the game
                    libraryPanel.revalidate();
                    libraryPanel.repaint();

                });
                newWindow.add(AddtoLibraryButton);

                newWindow.setVisible(true);
            });

            storePanel.add(button3);

            JButton button4 = new JButton("Snake Game");
            button4.setFont(new Font("Arial", Font.BOLD, 20)); // Set the font
            button4.setForeground(new Color(0xf5875c)); // Set the text color
            button4.setBackground(new Color(0x1a223a)); // Set the background color
            button4.setIcon(new ImageIcon("Snake Game Logo.jpeg")); // Set the image
            button4.setPreferredSize(new Dimension(300, 300)); // Set the preferred size
            button4.setBorderPainted(false); // Remove the border
            button4.addActionListener(e -> {
                
                // Open a new window
                JFrame newWindow = new JFrame();
                newWindow.setExtendedState(JFrame.MAXIMIZED_BOTH);
                newWindow.getContentPane().setBackground(new Color(0x1a223a));
                newWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                newWindow.setTitle("Snake Game");
                newWindow.setLayout(new FlowLayout());
                

                // Create the image label
                JLabel imageLabel = new JLabel();
                ImageIcon imageIcon = new ImageIcon("Snake Game Logo.jpeg");
                Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
                imageIcon = new ImageIcon(image);
                imageLabel.setIcon(imageIcon);
                newWindow.add(imageLabel);

                // Create the text label
                JLabel textLabel = new JLabel("Snake Game");
                textLabel.setFont(new Font("Arial", Font.BOLD, 40));
                textLabel.setForeground(new Color(0xf5875c));
                newWindow.add(textLabel);
                
 
            
                // Create the first 300x300 image
                JLabel imageLabel2 = new JLabel();
                ImageIcon imageIcon2 = new ImageIcon("Snake Game Image1.png");
                Image image2 = imageIcon2.getImage().getScaledInstance(354, 362, Image.SCALE_DEFAULT);
                imageIcon2 = new ImageIcon(image2);
                imageLabel2.setIcon(imageIcon2);
                newWindow.add(imageLabel2);

                // Create the second 300x300 image
                JLabel imageLabel3 = new JLabel();
                ImageIcon imageIcon3 = new ImageIcon("Snake Game Image2.png");
                Image image3 = imageIcon3.getImage().getScaledInstance(356, 360, Image.SCALE_DEFAULT);
                imageIcon3 = new ImageIcon(image3);
                imageLabel3.setIcon(imageIcon3);
                newWindow.add(imageLabel3);

                // Create the third 300x300 image
                JLabel imageLabel4 = new JLabel();
                ImageIcon imageIcon4 = new ImageIcon("Snake Game Image3.png");
                Image image4 = imageIcon4.getImage().getScaledInstance(356, 362, Image.SCALE_DEFAULT);
                imageIcon4 = new ImageIcon(image4);
                imageLabel4.setIcon(imageIcon4);
                newWindow.add(imageLabel4);

                JButton Playbutton = new JButton("Play Snake Game");
                Playbutton.setIcon(new ImageIcon("Snake Game Logo.jpeg")); // Set the image
                Playbutton.setPreferredSize(new Dimension(200, 200)); // Set the preferred size
                Playbutton.setVerticalTextPosition(SwingConstants.BOTTOM); // Position the text below the imag
                Playbutton.setPreferredSize(new Dimension(200, 200));
                Playbutton.setFont(new Font("Arial", Font.BOLD, 20)); // Set the font
                Playbutton.setForeground(new Color(0x1a223a)); // Set the text color
                Playbutton.setBackground(new Color(0xf5875c)); // Set the background color
                Playbutton.addActionListener(event -> {

                    // Open the Snake Game
                    JFrame ex = new Snake();
                    ex.setVisible(true);
                                 
                });
                
                JButton AddtoLibraryButton = new JButton("Add to Library");
                AddtoLibraryButton.setPreferredSize(new Dimension(200, 50));
                AddtoLibraryButton.setFont(new Font("Arial", Font.BOLD, 20)); // Set the font
                AddtoLibraryButton.setForeground(new Color(0x1a223a)); // Set the text color
                AddtoLibraryButton.setBackground(new Color(0xf5875c)); // Set the background color
                AddtoLibraryButton.addActionListener(event -> {
                    // Add the game to the library panel
                    libraryPanel.add(Playbutton); // Replace button1 with the appropriate button for the game
                    libraryPanel.revalidate();
                    libraryPanel.repaint();

                });
                newWindow.add(AddtoLibraryButton);

                newWindow.setVisible(true);
            });

            storePanel.add(button4);

            JButton button5 = new JButton("Pong Game");
            button5.setFont(new Font("Arial", Font.BOLD, 20)); // Set the font
            button5.setForeground(new Color(0xf5875c)); // Set the text color
            button5.setBackground(new Color(0x1a223a)); // Set the background color
            button5.setIcon(new ImageIcon("Pong Game Logo.jpeg")); // Set the image
            button5.setPreferredSize(new Dimension(300, 300)); // Set the preferred size
            button5.setBorderPainted(false); // Remove the border
            button5.addActionListener(e -> {
                
                // Open a new window
                JFrame newWindow = new JFrame();
                newWindow.setExtendedState(JFrame.MAXIMIZED_BOTH);
                newWindow.getContentPane().setBackground(new Color(0x1a223a));
                newWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                newWindow.setTitle("Pong Game");
                newWindow.setLayout(new FlowLayout());
                

                // Create the image label
                JLabel imageLabel = new JLabel();
                ImageIcon imageIcon = new ImageIcon("Pong Game Logo.jpeg");
                Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
                imageIcon = new ImageIcon(image);
                imageLabel.setIcon(imageIcon);
                newWindow.add(imageLabel);

                // Create the text label
                JLabel textLabel = new JLabel("Pong Game");
                textLabel.setFont(new Font("Arial", Font.BOLD, 40));
                textLabel.setForeground(new Color(0xf5875c));
                newWindow.add(textLabel);
                
 
            
                // Create the first 300x300 image
                JLabel imageLabel2 = new JLabel();
                ImageIcon imageIcon2 = new ImageIcon("Pong Game Image1.png");
                Image image2 = imageIcon2.getImage().getScaledInstance(354, 362, Image.SCALE_DEFAULT);
                imageIcon2 = new ImageIcon(image2);
                imageLabel2.setIcon(imageIcon2);
                newWindow.add(imageLabel2);

                // Create the second 300x300 image
                JLabel imageLabel3 = new JLabel();
                ImageIcon imageIcon3 = new ImageIcon("Pong Game Image2.png");
                Image image3 = imageIcon3.getImage().getScaledInstance(356, 360, Image.SCALE_DEFAULT);
                imageIcon3 = new ImageIcon(image3);
                imageLabel3.setIcon(imageIcon3);
                newWindow.add(imageLabel3);

                // Create the third 300x300 image
                JLabel imageLabel4 = new JLabel();
                ImageIcon imageIcon4 = new ImageIcon("Pong Game Image3.png");
                Image image4 = imageIcon4.getImage().getScaledInstance(356, 362, Image.SCALE_DEFAULT);
                imageIcon4 = new ImageIcon(image4);
                imageLabel4.setIcon(imageIcon4);
                newWindow.add(imageLabel4);

                JButton Playbutton = new JButton("Play Pong Game");
                Playbutton.setIcon(new ImageIcon("Pong Game Logo.jpeg")); // Set the image
                Playbutton.setPreferredSize(new Dimension(200, 200)); // Set the preferred size
                Playbutton.setVerticalTextPosition(SwingConstants.BOTTOM); // Position the text below the imag
                Playbutton.setPreferredSize(new Dimension(200, 200));
                Playbutton.setFont(new Font("Arial", Font.BOLD, 20)); // Set the font
                Playbutton.setForeground(new Color(0x1a223a)); // Set the text color
                Playbutton.setBackground(new Color(0xf5875c)); // Set the background color
                Playbutton.addActionListener(event -> {

                    // Open the Pong Game
                    JFrame frame = new JFrame("Pong");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.getContentPane().add(new PongGame());
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                                 
                });
                
                JButton AddtoLibraryButton = new JButton("Add to Library");
                AddtoLibraryButton.setPreferredSize(new Dimension(200, 50));
                AddtoLibraryButton.setFont(new Font("Arial", Font.BOLD, 20)); // Set the font
                AddtoLibraryButton.setForeground(new Color(0x1a223a)); // Set the text color
                AddtoLibraryButton.setBackground(new Color(0xf5875c)); // Set the background color
                AddtoLibraryButton.addActionListener(event -> {
                    // Add the game to the library panel
                    libraryPanel.add(Playbutton); // Replace button1 with the appropriate button for the game
                    libraryPanel.revalidate();
                    libraryPanel.repaint();

                });
                newWindow.add(AddtoLibraryButton);

                newWindow.setVisible(true);
            });

            storePanel.add(button5);

            

            // Add panels to the tabbed pane
            tabbedPane.addTab("Store", storePanel);
            tabbedPane.addTab("Library", libraryPanel);

            // Add action listeners to the buttons
           

            // Add the buttons and tabbed pane to the frame
            setLayout(new FlowLayout());
            
            add(tabbedPane);

            setVisible(true);
        }
    }


    public static void main(String[] args) {
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Rectangle bounds = env.getMaximumWindowBounds();
        new Window(bounds.width, bounds.height);
    }
}

