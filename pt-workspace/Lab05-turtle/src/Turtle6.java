import java.awt.Color;
import java.util.Random;

import se.lth.cs.pt.window.SimpleWindow;

public class Turtle6 {
    public static void main(String[] args) {
        Random rand = new Random();
        int height = 600, width = 400;

        SimpleWindow w = new SimpleWindow(width, height, "Turtle6");
        Turtle t1 = new Turtle(w, 100, 100);
        Turtle t2 = new Turtle(w, 200, 100);
        t1.penDown();
        t2.penDown();

        while (Math.hypot(t1.getX() - t2.getX(), t1.getY() - t2.getY()) >= 50) {
            t1.forward(rand.nextInt(10) + 1);
            t1.left(rand.nextInt(360) - 180);

            t2.forward(rand.nextInt(10) + 1);
            t2.left(rand.nextInt(360) - 180);

            SimpleWindow.delay(10);
        }

        // Draws line between the two turtles
        w.setLineColor(Color.RED);
        w.setLineWidth(3);

        w.lineTo(t1.getX(), t1.getY());
    }
}
