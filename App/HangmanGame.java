import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;

public class HangmanGame extends JFrame {
    private String[] words = {"HELLO", "WORLD", "JAVA", "PROGRAMMING", "COMPUTER", "SCIENCE", "ENGINEERING"};
    private String wordToGuess;
    private char[] hiddenWord;
    private int attemptsLeft;
    private JTextField guessField;
    private JTextArea outputArea;
    private JLabel imageLabel;
    private int incorrectGuesses;

    public HangmanGame() {
        setTitle("Hangman Game");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Choose a random word from the array
        wordToGuess = words[new Random().nextInt(words.length)];
        hiddenWord = new char[wordToGuess.length()];
        Arrays.fill(hiddenWord, '_');
        attemptsLeft = 5;
        incorrectGuesses = 0;

        JPanel panel = new JPanel(new BorderLayout());

        JLabel titleLabel = new JLabel("Hangman Game");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titleLabel, BorderLayout.NORTH);

        imageLabel = new JLabel();
        ImageIcon imageIcon = new ImageIcon("hangman0.png");
        imageLabel.setIcon(imageIcon);
        panel.add(imageLabel, BorderLayout.CENTER);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        panel.add(new JScrollPane(outputArea), BorderLayout.EAST);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        JLabel guessLabel = new JLabel("Enter your guess:");
        inputPanel.add(guessLabel);

        guessField = new JTextField(10);
        inputPanel.add(guessField);

        JButton guessButton = new JButton("Guess");
        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkGuess();
            }
        });
        inputPanel.add(guessButton);

        panel.add(inputPanel, BorderLayout.SOUTH);

        getContentPane().add(panel);
        setVisible(true);

        appendToOutputArea("Welcome to Hangman! You have " + attemptsLeft + " attempts left.");
    }

    private void checkGuess() {
        String guessText = guessField.getText().toUpperCase();
        if (guessText.length() != 1) {
            appendToOutputArea("Please enter only one letter as your guess.");
            return;
        }
        char guess = guessText.charAt(0);
        boolean found = false;
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == guess && hiddenWord[i] != guess) {
                hiddenWord[i] = guess;
                found = true;
            }
        }
        if (!found) {
            incorrectGuesses++;
            updateHangmanImage();
            attemptsLeft--;
        }
        if (attemptsLeft == 0 || Arrays.equals(hiddenWord, wordToGuess.toCharArray())) {
            endGame();
        } else {
            displayGameState();
        }
        guessField.setText("");
    }
    

    private void updateHangmanImage() {
        ImageIcon imageIcon = new ImageIcon("hangman" + incorrectGuesses + ".png");
        imageLabel.setIcon(imageIcon);
    }

    private void displayGameState() {
        StringBuilder gameState = new StringBuilder();
        gameState.append("Word: ");
        for (char c : hiddenWord) {
            gameState.append(c).append(" ");
        }
        gameState.append("\nAttempts left: ").append(attemptsLeft);
        appendToOutputArea(gameState.toString());
    }

    private void endGame() {
        if (attemptsLeft == 0) {
            appendToOutputArea("Game over! The word was: " + wordToGuess);
        } else {
            appendToOutputArea("Congratulations! You guessed the word: " + wordToGuess);
        }
        guessField.setEditable(false);
    }

    private void appendToOutputArea(String text) {
        outputArea.append(text + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HangmanGame();
            }
        });
    }
}
