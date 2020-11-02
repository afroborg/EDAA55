import se.lth.cs.pt.window.SimpleWindow;

public class LineDrawing {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(500, 500, "LineDrawing");
		w.moveTo(0, 0);
		while (true) {
			w.waitForMouseClick();

			// getMouseX och getMouseY hämtar muspositionen på hela skärmen, inte i
			// fönstret?
			// int x = w.getMouseY();
			// int y = w.getMouseY();

			// ? Menas getClickedX och getClickedY ?
			int x = w.getClickedX();
			int y = w.getClickedY();

			w.lineTo(x, y);

		}
	}
}
