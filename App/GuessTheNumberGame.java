import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuessTheNumberGame extends JFrame {
    private int randomNumber;
    private int attemptsLeft;
    private JTextField guessField;
    private JTextArea outputArea;

    public GuessTheNumberGame() {
        setTitle("Guess the Number Game");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Generate a random number between 1 and 20
        randomNumber = (int) (Math.random() * 20) + 1;
        attemptsLeft = 5;

        JPanel panel = new JPanel(new BorderLayout());

        JLabel titleLabel = new JLabel("Guess the Number Game");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titleLabel, BorderLayout.NORTH);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        panel.add(new JScrollPane(outputArea), BorderLayout.CENTER);

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

        appendToOutputArea("Welcome to Guess the Number Game! You have " + attemptsLeft + " attempts to guess the number.");
    }

    private void checkGuess() {
        String guessText = guessField.getText();
        try {
            int guess = Integer.parseInt(guessText);
            if (guess < 1 || guess > 20) {
                appendToOutputArea("Please enter a number between 1 and 20.");
                return;
            }
            attemptsLeft--;
            if (guess == randomNumber) {
                appendToOutputArea("Congratulations! You guessed the number " + randomNumber + "!");
                guessField.setEditable(false);
            } else {
                if (attemptsLeft == 0) {
                    appendToOutputArea("Game over! The correct number was " + randomNumber + ".");
                    guessField.setEditable(false);
                } else {
                    String message = "Incorrect guess. ";
                    if (guess < randomNumber) {
                        message += "Try a higher number.";
                    } else {
                        message += "Try a lower number.";
                    }
                    message += " Attempts left: " + attemptsLeft;
                    appendToOutputArea(message);
                }
            }
        } catch (NumberFormatException ex) {
            appendToOutputArea("Invalid input. Please enter a valid number.");
        }
        guessField.setText("");
    }

    private void appendToOutputArea(String text) {
        outputArea.append(text + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GuessTheNumberGame();
            }
        });
    }
}
