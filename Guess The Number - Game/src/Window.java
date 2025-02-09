import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {
    Font mainFont = new Font("Sans-serif ", Font.BOLD, 18);
    Font numberFont = new Font("Sans-serif", Font.BOLD, 46);
    JPanel mainPanel, topPanel;
    int randomNumber;
    JTextField numberField;
    JLabel resultLabel, scoreLabel, highScoreLabel;
    JButton guessButton;
    int score = 10;
    int highScore = 0;

    Window() {
        createMainPanel();

        this.setBounds(510, 180, 550, 550);
        this.setMinimumSize(new Dimension(550, 550));
        this.setTitle("Guess The Number - Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void createMainPanel() {
        mainPanel = new JPanel();
        mainPanel.setOpaque(true);

        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        mainPanel.setBackground(new Color(173, 173, 173));

        // Generate Random Number
        generateRandomNumber();

        // Top Panel
        topPanel();

        // Middle Panel
        createMiddlePanel();

        // Button Panel
        createButtonPanel();

        this.add(mainPanel);
    }

    public void topPanel() {
        topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(6, 1, 0, 0));
        topPanel.setBackground(new Color(255, 255, 255, 0));

        JLabel heading = new JLabel("Guess The Number");
        heading.setForeground(new Color(33, 37, 41));
        Font headingFont = new Font("Arial", Font.BOLD, 26);
        heading.setFont(headingFont);

        heading.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel rulePara = new JLabel("Between 1 and 10.");
        rulePara.setHorizontalAlignment(SwingConstants.CENTER);

        resultLabel = new JLabel();
        resultLabel.setFont(mainFont);
        resultLabel.setForeground(Color.RED);
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);

        rulePara.setFont(mainFont);

        topPanel.add(heading);
        topPanel.add(rulePara);
        topPanel.add(resultLabel);

        mainPanel.add(topPanel, BorderLayout.NORTH);
    }

    public void createMiddlePanel() {
        JPanel middlePanel = new JPanel();
        middlePanel.setLayout(new GridLayout(2, 2, 5, 5));

        scoreLabel = new JLabel("Score: 10");
        scoreLabel.setFont(mainFont);
        scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);

        highScoreLabel = new JLabel("High Score: 0");
        highScoreLabel.setFont(mainFont);
        highScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel hideNumberBox = new JLabel("?");
        hideNumberBox.setBackground(Color.WHITE);

        hideNumberBox.setOpaque(true);
        hideNumberBox.setFont(numberFont);

        hideNumberBox.setHorizontalAlignment(SwingConstants.CENTER);

        numberField = new JTextField();
        numberField.setFont(numberFont);
        numberField.setHorizontalAlignment(SwingConstants.CENTER);

        middlePanel.add(scoreLabel);
        middlePanel.add(highScoreLabel);
        middlePanel.add(hideNumberBox);
        middlePanel.add(numberField);

        mainPanel.add(middlePanel, BorderLayout.CENTER);
    }

    public void createButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2, 10, 0));

        guessButton = new JButton("Guess");
        guessButton.setFont(mainFont);
        guessButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        guessButton.setForeground(Color.WHITE);

        guessButton.setBackground(new Color(60, 53, 162));

        guessButton.setFocusPainted(false);
        guessButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        guessButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkWin();
            }
        });

        JButton againButton = new JButton("Again");
        againButton.setFont(mainFont);
        againButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        againButton.setForeground(Color.WHITE);

        againButton.setBackground(Color.red);

        againButton.setFocusPainted(false);
        againButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        againButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetGame();
            }
        });

        buttonPanel.add(guessButton);
        buttonPanel.add(againButton);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
    }

    public void checkWin() {
        String numberText = numberField.getText();

        if (numberText.isEmpty()) {
            resultLabel.setText("Enter a Number!");
            mainPanel.revalidate();
            mainPanel.repaint();
            return;
        }

        resultLabel.setForeground(Color.WHITE);

        long enteredNumber = Long.parseLong(numberText);

        if (enteredNumber > 10 || enteredNumber <= 0) {
            resultLabel.setText("Enter between 1 and 10");
        } else if (enteredNumber == randomNumber) {
            resultLabel.setText("Correct Number!");
            mainPanel.setBackground(new Color(43, 180, 3));
            score--;
            scoreLabel.setText("Score: " + score);
            if (score > highScore) {
                highScore = score;
                highScoreLabel.setText("High Score: " + highScore);
            }
            guessButton.setEnabled(false);
            return;
        } else if (enteredNumber > randomNumber) {
            resultLabel.setText("Number Is Higher");
        } else if (enteredNumber < randomNumber) {
            resultLabel.setText("Number Is Lower");
        }

        mainPanel.setBackground(new Color(255, 77, 0));
        score--;
        scoreLabel.setText("Score: " + score);
        if (score <= 0) {
            resultLabel.setText("Game Over!");
            guessButton.setEnabled(false);
        }

        mainPanel.revalidate();
        mainPanel.repaint();
    }

    public void generateRandomNumber() {
        randomNumber = 1 + (int) (Math.random() * 10); // 2.3456 -> 2 + 1 = 3
        System.out.println(randomNumber);
    }

    public void resetGame() {
        generateRandomNumber();
        score = 10;
        scoreLabel.setText("Score: " + score);
        mainPanel.setBackground(new Color(173, 173, 173));
        resultLabel.setText("");
        numberField.setText("");
        guessButton.setEnabled(true);

        mainPanel.revalidate();
        mainPanel.repaint();
    }
}
