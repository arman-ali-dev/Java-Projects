package src;

import java.awt.*;

public class Turtle {
    private int x = 350, y = 300;
    private int angle = 0;
    private boolean penDown = true;
    private Color penColor = Color.BLACK;
    private final TurtlePanel panel;

    public Turtle(TurtlePanel panel) {
        this.panel = panel;
        panel.setTurtleState(x, y, angle); // Set initial turtle position

        // Load turtle.png from inside LBUGraphics.jar
        Image img = Toolkit.getDefaultToolkit().createImage(
                getClass().getClassLoader().getResource("uk/ac/leedsbeckett/oop/turtle.png"));
        panel.setTurtleImage(img); // Pass image to panel
    }

    public void move(int distance) {
        int steps = Math.abs(distance);
        int direction = distance >= 0 ? 1 : -1;

        for (int i = 0; i < steps; i++) {
            int oldX = x;
            int oldY = y;

            x += (int) Math.round(Math.cos(Math.toRadians(angle)) * direction);
            y -= (int) Math.round(Math.sin(Math.toRadians(angle)) * direction);

            if (penDown && i > 0) {
                panel.addLine(new Line(oldX, oldY, x, y, penColor));
            }

            panel.setTurtleState(x, y, angle);

            try {
                Thread.sleep(5); // Slow animation
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void reverse(int distance) {
        move(-distance);
    }

    public void turnLeft() {
        angle = (angle + 90) % 360;
        panel.setTurtleState(x, y, angle);
    }

    public void turnRight() {
        angle = (angle + 270) % 360;
        panel.setTurtleState(x, y, angle);
    }

    public void penUp() {
        penDown = false;
    }

    public void penDown() {
        penDown = true;
    }

    public void setPenColor(Color color) {
        this.penColor = color;
    }

    public void reset() {
        x = 350;
        y = 300;
        angle = 0;
        penDown = true;
        panel.clearLines();
        panel.setTurtleState(x, y, angle);
    }

    public void clear() {
        panel.clearLines();
    }
}
