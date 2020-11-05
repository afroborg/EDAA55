import se.lth.cs.pt.square.Square;
import se.lth.cs.pt.window.SimpleWindow;

public class SquareClicks {
    public static void main(String[] args) {
        final int STEPS = 10;
        final int HEIGHT = 600, WIDTH = 600;
        final int SIZE = WIDTH / 5;

        SimpleWindow w = new SimpleWindow(HEIGHT, WIDTH, "SquareClicks");
        Square sq = new Square(HEIGHT / 2 - SIZE, WIDTH / 2 - SIZE, SIZE);
        sq.draw(w);

        while (true) {
            w.waitForMouseClick();

            int mouseX = w.getClickedX();
            int mouseY = w.getClickedY();
            int prevX = sq.getX();
            int prevY = sq.getY();

            for (int i = 0; i < STEPS; i++) {
                sq.move((mouseX - prevX) / STEPS, (mouseY - prevY) / STEPS);
                sq.draw(w);
            }
        }
    }
}
