import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {
    Boolean isXTurn = true;
    String[] buttonTextBoard = new String[9];
    JButton[] buttons = new JButton[9];
    JPanel mainPanel;

    int[][] winningPattern = {
            { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 },
            { 0, 3, 6 }, { 1, 4, 7 }, { 2, 5, 8 },
            { 0, 4, 8 }, { 2, 4, 6 }
    };

    Window() {
        createMainPanel();
        this.setBounds(510, 180, 550, 550);
        this.setTitle("Tic Tac Toe - Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void createMainPanel() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 3, 5, 5));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Button Panel
        createButtonUI();
        this.add(mainPanel);
    }

    public void createButtonUI() {
        for (int i = 0; i < 9; i++) {
            buttonTextBoard[i] = "";
            buttons[i] = new JButton();
            JButton btn = buttons[i];

            Font btnFont = new Font("Arial", Font.BOLD, 60);

            btn.putClientProperty("index", i);

            btn.setFont(btnFont);
            btn.setBackground(Color.BLACK);
            btn.setForeground(Color.WHITE);

            btn.setFocusable(false);
            btn.setContentAreaFilled(false);
            btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
            btn.setOpaque(true);

            // Logic

            btn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    btn.setText(isXTurn ? "X" : "O");

                    int index = (int) btn.getClientProperty("index");
                    buttonTextBoard[index] = isXTurn ? "X" : "O";

                    Boolean result = checkWin();

                    if (result) {
                        String winner = isXTurn ? "X" : "O";
                        winningPopUp(winner);
                        resetGame();
                        return;
                    }

                    btn.setEnabled(false);
                    checkGameTie();
                    // Player Turn
                    isXTurn = !isXTurn;
                }
            });

            mainPanel.add(btn);
        }
    }

    public Boolean checkWin() {
        for (int i = 0; i < winningPattern.length; i++) {
            String pos1 = buttonTextBoard[winningPattern[i][0]];
            String pos2 = buttonTextBoard[winningPattern[i][1]];
            String pos3 = buttonTextBoard[winningPattern[i][2]];

            if (!pos1.isEmpty() && !pos2.isEmpty() && !pos3.isEmpty()) {
                if (pos1.equals(pos2) && pos2.equals(pos3)) {
                    return true;
                }
            }
        }

        return false;
    }

    public void checkGameTie() {
        for (String txt : buttonTextBoard) {
            if (txt.isEmpty()) {
                return; // Game Is Still Playable
            }
        }

        gameTieMessage();
        resetGame();
    }

    public void winningPopUp(String player) {
        JOptionPane.showMessageDialog(this, "Player " + player + " Wins", "Game Over", JOptionPane.INFORMATION_MESSAGE);
    }

    public void gameTieMessage() {
        JOptionPane.showMessageDialog(this, "Game Tie", "Game Over", JOptionPane.INFORMATION_MESSAGE);
    }

    public void resetGame() {
        for (JButton btn : buttons) {
            btn.setText("");
            btn.setEnabled(true);
        }
        for (int i = 0; i < 9; i++) {
            buttonTextBoard[i] = "";
        }

        isXTurn = true;
    }
}
