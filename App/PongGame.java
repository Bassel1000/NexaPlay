import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PongGame extends JPanel implements ActionListener {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int BALL_DIAMETER = 20;
    private static final int PADDLE_WIDTH = 10;
    private static final int PADDLE_HEIGHT = 100;
    private static final int PADDLE_SPEED = 10;

    private int ballX = WIDTH / 2 - BALL_DIAMETER / 2;
    private int ballY = HEIGHT / 2 - BALL_DIAMETER / 2;
    private int ballSpeedX = 0;
    private int ballSpeedY = 0;

    private int paddle1Y = HEIGHT / 2 - PADDLE_HEIGHT / 2;
    private int paddle2Y = HEIGHT / 2 - PADDLE_HEIGHT / 2;

    private boolean upPressed1 = false;
    private boolean downPressed1 = false;
    private boolean upPressed2 = false;
    private boolean downPressed2 = false;

    private int player1Score = 0;
    private int player2Score = 0;
    private boolean gameEnded = false;

    public PongGame() {
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        Timer timer = new Timer(1000 / 60, this);
        timer.start();

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (!gameEnded) {
                    if (e.getKeyCode() == KeyEvent.VK_W) {
                        upPressed1 = true;
                    } else if (e.getKeyCode() == KeyEvent.VK_S) {
                        downPressed1 = true;
                    } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                        upPressed2 = true;
                    } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                        downPressed2 = true;
                    }

                    if (ballSpeedX == 0 && ballSpeedY == 0) {
                        // Start the ball movement when any key is pressed
                        ballSpeedX = 5;
                        ballSpeedY = 5;
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    upPressed1 = false;
                } else if (e.getKeyCode() == KeyEvent.VK_S) {
                    downPressed1 = false;
                } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                    upPressed2 = false;
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    downPressed2 = false;
                }
            }
        });
        setFocusable(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (!gameEnded) {
            // Update ball position
            ballX += ballSpeedX;
            ballY += ballSpeedY;

            // Check for collisions with walls
            if (ballY <= 0 || ballY >= HEIGHT - BALL_DIAMETER) {
                ballSpeedY *= -1;
            }

            // Check for collisions with paddles
            if (ballX <= PADDLE_WIDTH && ballY >= paddle1Y && ballY <= paddle1Y + PADDLE_HEIGHT ||
                    ballX >= WIDTH - PADDLE_WIDTH - BALL_DIAMETER && ballY >= paddle2Y && ballY <= paddle2Y + PADDLE_HEIGHT) {
                ballSpeedX *= -1;
            }

            // Check for scoring
            if (ballX < 0) {
                player2Score++;
                resetBall();
            } else if (ballX > WIDTH - BALL_DIAMETER) {
                player1Score++;
                resetBall();
            }

            // Update paddle positions
            if (upPressed1 && paddle1Y > 0) {
                paddle1Y -= PADDLE_SPEED;
            }
            if (downPressed1 && paddle1Y < HEIGHT - PADDLE_HEIGHT) {
                paddle1Y += PADDLE_SPEED;
            }
            if (upPressed2 && paddle2Y > 0) {
                paddle2Y -= PADDLE_SPEED;
            }
            if (downPressed2 && paddle2Y < HEIGHT - PADDLE_HEIGHT) {
                paddle2Y += PADDLE_SPEED;
            }

            repaint();
        }
    }

    private void resetBall() {
        ballX = WIDTH / 2 - BALL_DIAMETER / 2;
        ballY = HEIGHT / 2 - BALL_DIAMETER / 2;
        ballSpeedX = 0;
        ballSpeedY = 0;

        if (player1Score >= 5 || player2Score >= 5) {
            gameEnded = true;
            JOptionPane.showMessageDialog(this, (player1Score > player2Score ? "Player 1" : "Player 2") + " wins!");
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw paddles
        g.setColor(Color.WHITE);
        g.fillRect(PADDLE_WIDTH, paddle1Y, PADDLE_WIDTH, PADDLE_HEIGHT);
        g.fillRect(WIDTH - PADDLE_WIDTH * 2, paddle2Y, PADDLE_WIDTH, PADDLE_HEIGHT);

        // Draw ball
        g.fillOval(ballX, ballY, BALL_DIAMETER, BALL_DIAMETER);

        // Draw scores
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawString("Player 1: " + player1Score, 20, 30);
        g.drawString("Player 2: " + player2Score, WIDTH - 200, 30);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Pong");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new PongGame());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
