import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Index {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setTitle("Form");
        frame.setBounds(500, 180, 550, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        frame.setLayout(new  BorderLayout());
        
        JLabel heading = new JLabel("My Form");
        Font font = new Font("", Font.BOLD, 30);
      
        heading.setFont(font);
        heading.setHorizontalAlignment(JLabel.CENTER);

        frame.add(heading, BorderLayout.NORTH);



        JPanel mainPanel = new JPanel();
        JLabel nameLabel, passwordLabel;



        mainPanel.setLayout(new GridLayout(3, 2));

        nameLabel = new JLabel("Enter Your Name: ");
        nameLabel.setFont(font);

        passwordLabel = new JLabel("Enter Your Passowrd: ");
        passwordLabel.setFont(font);


        JTextField textField = new JTextField();
        textField.setFont(font);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setFont(font);

        JButton submitBtn = new JButton("Submit");
        submitBtn.setFont(font);
        
        JButton resetBtn = new JButton("Reset");
        resetBtn.setFont(font);


        mainPanel.add(nameLabel);
        mainPanel.add(textField);

        mainPanel.add(passwordLabel);
        mainPanel.add(passwordField);

        mainPanel.add(submitBtn);
        mainPanel.add(resetBtn);

        frame.add(mainPanel, BorderLayout.CENTER);


        frame.setVisible(true);
       
    }
}
