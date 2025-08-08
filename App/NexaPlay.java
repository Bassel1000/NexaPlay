import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import Snake.code.Snake;

public class NexaPlay {

    public static class Window extends JFrame {
        private final int appWidth;
        private final int appHeight;
        private final JPanel contentArea = new JPanel(new CardLayout());
        private final String CARD_STORE = "store";
        private final String CARD_LIBRARY = "library";
        private final JPanel libraryGrid = new JPanel(new GridLayout(0, 3, 16, 16));

        public Window(int width, int height) {
            this.appWidth = width;
            this.appHeight = height;
            setTitle("NexaPlay");
            setIconImage(Toolkit.getDefaultToolkit().getImage("NexaPlay Icon.png"));
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(width, height);
            setExtendedState(JFrame.MAXIMIZED_BOTH);
            Theme.applyRoot(this);
            setLayout(new BorderLayout());

            // Top bar
            JPanel topbar = new JPanel(new BorderLayout());
            Theme.applyPanel(topbar);
            topbar.setBorder(BorderFactory.createEmptyBorder(10, 16, 10, 16));
            JPanel left = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));
            Theme.applyPanel(left);
            JLabel title = Theme.heading("NexaPlay");
            JLabel subtitle = Theme.subtitle("Game Store & Launcher");
            JPanel titleWrap = new JPanel();
            titleWrap.setLayout(new BoxLayout(titleWrap, BoxLayout.Y_AXIS));
            Theme.applyPanel(titleWrap);
            titleWrap.add(title);
            titleWrap.add(subtitle);
            left.add(new JLabel(new ImageIcon(new ImageIcon("NexaPlay Icon.png").getImage().getScaledInstance(36,36, Image.SCALE_SMOOTH))));
            left.add(titleWrap);
            JPanel right = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 0));
            Theme.applyPanel(right);
            JTextField search = new JTextField();
            search.setPreferredSize(new Dimension(280, 30));
            search.setBackground(Theme.BG_ELEVATED);
            search.setForeground(Theme.TEXT_PRIMARY);
            search.setCaretColor(Theme.TEXT_PRIMARY);
            search.setBorder(BorderFactory.createEmptyBorder(6, 10, 6, 10));
            search.setText("Search (placeholder)");
            right.add(search);
            JButton logout = new JButton("Logout");
            Theme.stylePrimary(logout);
            logout.addActionListener(e -> {
                dispose();
                new Login(appWidth, appHeight).setVisible(true);
            });
            right.add(logout);
            topbar.add(left, BorderLayout.WEST);
            topbar.add(right, BorderLayout.EAST);
            add(topbar, BorderLayout.NORTH);

            // Sidebar
            JPanel sidebar = new JPanel();
            sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
            Theme.applyPanel(sidebar);
            sidebar.setBorder(BorderFactory.createEmptyBorder(16, 12, 16, 12));
            JButton storeBtn = new JButton("Store");
            JButton libraryBtn = new JButton("Library");
            Theme.stylePrimary(storeBtn);
            Theme.stylePrimary(libraryBtn);
            storeBtn.addActionListener(e -> showCard(CARD_STORE));
            libraryBtn.addActionListener(e -> showCard(CARD_LIBRARY));
            sidebar.add(storeBtn);
            sidebar.add(Box.createVerticalStrut(8));
            sidebar.add(libraryBtn);
            add(sidebar, BorderLayout.WEST);

            // Store grid
            JPanel storeGrid = new JPanel(new GridLayout(0, 3, 16, 16));
            Theme.applyPanel(storeGrid);
            JScrollPane storeScroll = new JScrollPane(storeGrid);
            storeScroll.getVerticalScrollBar().setUnitIncrement(18);
            storeScroll.setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16));

            // Library grid
            Theme.applyPanel(libraryGrid);
            JScrollPane libScroll = new JScrollPane(libraryGrid);
            libScroll.getVerticalScrollBar().setUnitIncrement(18);
            libScroll.setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16));

            contentArea.add(storeScroll, CARD_STORE);
            contentArea.add(libScroll, CARD_LIBRARY);
            add(contentArea, BorderLayout.CENTER);

            // Populate store with cards
            addGameCards(storeGrid);

            setVisible(true);
        }

        private void showCard(String name) {
            CardLayout cl = (CardLayout) contentArea.getLayout();
            cl.show(contentArea, name);
        }

        private void addToLibrary(JButton playButton) {
            JButton clone = new JButton(playButton.getText());
            Theme.stylePrimary(clone);
            // copy action listeners
            for (ActionListener l : playButton.getActionListeners()) {
                clone.addActionListener(l);
            }
            libraryGrid.add(clone);
            libraryGrid.revalidate();
            libraryGrid.repaint();
            showCard(CARD_LIBRARY);
        }

        private void addGameCards(JPanel storeGrid) {
            // Tic Tac Toe
            storeGrid.add(new GameCard(
                    "Tic Tac Toe",
                    "Tic Tac Toe Logo.jpeg",
                    "Play Tic Tac Toe",
                    () -> new TicTacToeGame(),
                    this::addToLibrary
            ));

            // Guess The Number
            storeGrid.add(new GameCard(
                    "Guess The Number",
                    "Guess the Number Logo.jpeg",
                    "Play Guess The Number",
                    () -> new GuessTheNumberGame(),
                    this::addToLibrary
            ));

            // Hangman
            storeGrid.add(new GameCard(
                    "Hangman",
                    "Hangman Logo.jpeg",
                    "Play Hangman",
                    () -> new HangmanGame(),
                    this::addToLibrary
            ));

            // Snake
            storeGrid.add(new GameCard(
                    "Snake",
                    "Snake Game Logo.jpeg",
                    "Play Snake",
                    () -> { JFrame ex = new Snake(); ex.setVisible(true); },
                    this::addToLibrary
            ));

            // Pong
            storeGrid.add(new GameCard(
                    "Pong",
                    "Pong Game Logo.jpeg",
                    "Play Pong",
                    () -> {
                        JFrame frame = new JFrame("Pong");
                        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        frame.getContentPane().add(new PongGame());
                        frame.pack();
                        frame.setLocationRelativeTo(null);
                        frame.setVisible(true);
                    },
                    this::addToLibrary
            ));
        }
    }

    public static void main(String[] args) {
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Rectangle bounds = env.getMaximumWindowBounds();
        new Window(bounds.width, bounds.height);
    }
}

