import se.lth.cs.pt.window.SimpleWindow;

import java.util.Random;

public class Turtle5 {
    public static void main(String[] args) {
        int height = 600, width = 400, maxSteps = 1000;
        SimpleWindow w = new SimpleWindow(width, height, "Turtle5");
        Turtle t = new Turtle(w, width / 2, height / 2);
        t.penDown();

        Random rand = new Random();
        for (int i = 1; i < maxSteps; i++) {
            t.forward(rand.nextInt(10) + 1);
            t.left(rand.nextInt(360) - 180);
        }
    }
}
