package src;

import javax.swing.*;
import java.awt.*;
import uk.ac.leedsbeckett.oop.LBUGraphics;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Turtle Drawing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 700);

        LBUGraphics turtle = new LBUGraphics() {
            @Override
            public void processCommand(String input) {
                input = input.trim().toLowerCase();
                String[] parts = input.split(" ");

                try {
                    switch (parts[0]) {
                        case "penup" -> drawOff();
                        case "pendown" -> drawOn();
                        case "left" -> left();
                        case "right" -> right();
                        case "move" -> forward(Integer.parseInt(parts[1]));
                        case "reverse" -> forward(-Integer.parseInt(parts[1]));
                        case "reset" -> reset();
                        case "new" -> clear();
                        case "red" -> setPenColour(Color.RED);
                        case "blue" -> setPenColour(Color.BLUE);
                        case "green" -> setPenColour(Color.GREEN);
                        case "black" -> setPenColour(Color.BLACK);
                        default -> JOptionPane.showMessageDialog(this, "Invalid command: " + input);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Error: Invalid or missing parameter.");
                }
            }
        };

        // ✅ Setup command input field and button
        JTextField commandField = new JTextField(40);
        JButton submitBtn = new JButton("Submit");

        // ✅ Input panel
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Command:"));
        inputPanel.add(commandField);
        inputPanel.add(submitBtn);

        // ✅ Info area for available commands + command history
        JTextArea commandInfo = new JTextArea();
        commandInfo.setEditable(false);
        commandInfo.setBackground(Color.BLACK);
        commandInfo.setForeground(Color.GREEN);
        commandInfo.setFont(new Font("Monospaced", Font.PLAIN, 12));

        commandInfo.setText("""
                ✅ Available Commands:
                ------------------------
                penup           → lift pen
                pendown         → drop pen
                left / right    → turn direction
                move X          → move forward by X
                reverse X       → move backward by X
                red / blue / green / black → set pen color
                reset           → reset turtle
                new             → clear canvas
                ------------------------
                💬 Command History:
                """);

        JScrollPane scrollPane = new JScrollPane(commandInfo);
        scrollPane.setPreferredSize(new Dimension(300, 600));

        // ✅ Frame layout
        frame.setLayout(new BorderLayout());
        frame.add(turtle, BorderLayout.CENTER); // LBUGraphics drawing panel
        frame.add(scrollPane, BorderLayout.WEST); // Command info
        frame.add(inputPanel, BorderLayout.SOUTH); // Command input
        frame.setVisible(true);

        // ✅ Submit action: send input to turtle.processCommand()
        submitBtn.addActionListener(e -> {
            String input = commandField.getText().trim();
            if (!input.isEmpty()) {
                commandInfo.append("\n> " + input);
                turtle.processCommand(input);
            }

            commandField.setText("");
            commandField.requestFocus();
        });
    }
}
