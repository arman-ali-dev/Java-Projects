import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Window extends JFrame {
    Window() {
        Font mainFont = new Font("Segoe print", Font.BOLD, 18);

        // Form Panel

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(4, 1, 5, 5));
        formPanel.setOpaque(false);

        JLabel firstNameJLabel = new JLabel("First Name: ");
        firstNameJLabel.setFont(mainFont);

        JLabel lastNameLabel = new JLabel("Last Name: ");
        lastNameLabel.setFont(mainFont);

        JTextField firstNameField = new JTextField();
        firstNameField.setFont(mainFont);

        JTextField lastNameField = new JTextField();
        lastNameField.setFont(mainFont);

        formPanel.add(firstNameJLabel);
        formPanel.add(firstNameField);

        formPanel.add(lastNameLabel);
        formPanel.add(lastNameField);

        // Welcome Label

        JLabel welcomeLabel = new JLabel();
        welcomeLabel.setFont(mainFont);

        // Button Panel

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2, 5, 5));
        buttonPanel.setOpaque(false);

        JButton okBtn = new JButton("OK");
        okBtn.setFont(mainFont);

        okBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();

                welcomeLabel.setText("Welcome " + firstName + " " + lastName);
            }
        });

        JButton clearBtn = new JButton("Clear");
        clearBtn.setFont(mainFont);

        clearBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                firstNameField.setText("");
                lastNameField.setText("");
                welcomeLabel.setText("");
            }
        });

        buttonPanel.add(okBtn);
        buttonPanel.add(clearBtn);

        // Main Panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(128, 128, 255));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(welcomeLabel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        this.add(mainPanel);

        this.setBounds(550, 180, 550, 550);
        this.setMinimumSize(new Dimension(550, 550));
        this.setTitle("Welcome To Our Form");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);
    }
}