import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Window extends JFrame {
    private JPanel mainPanel;
    private Font mainFont = new Font("Segoe print", Font.BOLD, 18);
    private JTextField inputTextField;
    private JPanel parentTaskPanel;

    Window() {
        // Main Panel
        mainPanel = new JPanel();
        mainPanel.setBackground(new Color(128, 128, 255));
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        this.add(mainPanel);
        // Form Panel
        createFormPanel();

        // Create Task Panel
        createTaskPanel();

        // Button Panel
        createButtonPanel();

        this.setBounds(520, 180, 550, 550);
        this.setTitle("To-Do List App");
        this.setMinimumSize(new Dimension(550, 550));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void createFormPanel() {
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(2, 1, 5, 5));

        formPanel.setOpaque(false);

        JLabel inputLabel = new JLabel("Enter Your Task: ");
        inputLabel.setFont(mainFont);

        inputTextField = new JTextField();
        inputTextField.setFont(mainFont);

        // Remove The Error
        inputTextField.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                inputTextField.setText("");
                inputTextField.setFont(mainFont);
                inputTextField.setForeground(Color.BLACK);
            }
        });

        formPanel.add(inputLabel);
        formPanel.add(inputTextField);
        mainPanel.add(formPanel, BorderLayout.NORTH);
    }

    public void createTaskPanel() {
        parentTaskPanel = new JPanel();
        parentTaskPanel.setLayout(new BoxLayout(parentTaskPanel, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(parentTaskPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        parentTaskPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        mainPanel.add(scrollPane, BorderLayout.CENTER);
    }

    public void createButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 1));

        JButton addBtn = new JButton("Add");
        addBtn.setFont(mainFont);

        addBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String taskText = inputTextField.getText();

                if (taskText.length() != 0) {
                    JPanel taskPanel = new JPanel();
                    taskPanel.setLayout(new BoxLayout(taskPanel, BoxLayout.X_AXIS));
                    taskPanel.setBackground(new Color(255, 255, 255));
                    taskPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                    taskPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));

                    JCheckBox checkBox = new JCheckBox();
                    checkBox.setPreferredSize(new Dimension(30, 40));
                    checkBox.setBackground(new Color(255, 255, 255, 0));
                    checkBox.setMaximumSize(new Dimension(30, 40));

                    checkBox.setContentAreaFilled(false);

                    JLabel taskLabel = new JLabel(taskText);

                    taskLabel.setFont(mainFont);
                    taskLabel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
                    taskLabel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));

                    checkBox.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {

                            taskLabel.setText(checkBox.isSelected() ? "<html><strike>" + taskText + "</strike></html>"
                                    : taskText);

                            taskPanel.repaint();
                            taskPanel.revalidate();
                            taskLabel.revalidate();
                            taskLabel.repaint();
                        }
                    });

                    JButton deleteBtn = new JButton("X");

                    deleteBtn.setContentAreaFilled(false);
                    deleteBtn.setFocusable(false);
                    deleteBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));

                    deleteBtn.setOpaque(true);
                    deleteBtn.setFont(mainFont);
                    deleteBtn.setBackground(new Color(255, 69, 58));
                    deleteBtn.setForeground(new Color(255, 255, 255));
                    deleteBtn.setMaximumSize(new Dimension(50, 40));

                    deleteBtn.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            parentTaskPanel.remove(taskPanel);
                            parentTaskPanel.revalidate();
                            parentTaskPanel.repaint();
                        }
                    });

                    taskPanel.add(checkBox);
                    taskPanel.add(taskLabel);
                    taskPanel.add(deleteBtn);

                    inputTextField.setText("");
                    parentTaskPanel.add(taskPanel);
                    parentTaskPanel.revalidate();
                } else

                {

                    inputTextField.setText("enter something here!");
                    Font errorFont = new Font("Arial", Font.BOLD, 14);
                    inputTextField.setForeground(Color.RED);
                    inputTextField.setFont(errorFont);
                }
            }
        });

        buttonPanel.add(addBtn);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
    }

}