import se.lth.cs.pt.square.Square;
import se.lth.cs.pt.window.SimpleWindow;

public class DrawThreeSquares {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "DrawSquare");
		Square sq = new Square(250, 250, 100);
		// Square sq = null;
		sq.draw(w);
		sq.move(10, 20);
		sq.draw(w);
		sq.move(-20, 30);
		sq.draw(w);
	}
}
