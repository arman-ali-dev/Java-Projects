import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ClockWindow extends JFrame {

    JLabel heading;
    JLabel clockLabel;

    Font font = new Font("", Font.BOLD, 30);

    ClockWindow() {
        this.setBounds(500, 180, 550, 550);
        this.setTitle("Digital Clock");
        this.getContentPane().setBackground(Color.BLACK);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        createGUI();
        startClock();
    }

    public void createGUI() {
        heading = new JLabel("Digital CLock");

        heading.setFont(font);
        heading.setForeground(Color.WHITE);
        heading.setHorizontalAlignment(JLabel.CENTER);

        clockLabel = new JLabel("Clock");

        clockLabel.setFont(font);
        clockLabel.setForeground(Color.WHITE);
        clockLabel.setHorizontalAlignment(JLabel.CENTER);

        this.setLayout(new GridLayout(2, 1));
        this.add(heading);
        this.add(clockLabel);
    }

    public void startClock() {
        Timer timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("hh : mm : ss a");
                String time = sdf.format(date);

                clockLabel.setText(time);
            }
        });

        timer.start();
    }
}