package src;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

public class TurtlePanel extends JPanel {
    private Image turtleImage;

    private final java.util.List<Line> lines = new ArrayList<>();

    // Turtle's current position and direction
    private int turtleX = 350;
    private int turtleY = 300;
    private int turtleAngle = 0;

    public void setTurtleImage(Image image) {
        this.turtleImage = image;
    }

    // Add a drawn line
    public void addLine(Line line) {
        lines.add(line);
        repaint();
    }

    // Clear all lines
    public void clearLines() {
        lines.clear();
        repaint();
    }

    // Update turtle's current state
    public void setTurtleState(int x, int y, int angle) {
        this.turtleX = x;
        this.turtleY = y;
        this.turtleAngle = angle;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        // Draw lines (optional)
        for (Line l : lines) {
            g2d.setColor(l.color);
            g2d.drawLine(l.x1, l.y1, l.x2, l.y2);
        }

        // Draw turtle image or triangle
        g2d.setColor(Color.BLUE);
        AffineTransform old = g2d.getTransform();
        g2d.translate(turtleX, turtleY);
        g2d.rotate(Math.toRadians(-turtleAngle));

        if (turtleImage != null) {
            g2d.drawImage(turtleImage, -15, -15, 30, 30, this); // centered image
        } else {
            int[] xPoints = { 0, -7, 7 };
            int[] yPoints = { -10, 7, 7 };
            g2d.fillPolygon(xPoints, yPoints, 3); // fallback triangle
        }

        g2d.setTransform(old);
    }

}
