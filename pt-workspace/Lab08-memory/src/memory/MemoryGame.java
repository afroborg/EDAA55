package memory;

import javax.swing.JOptionPane;

import se.lth.cs.pt.window.SimpleWindow;

public class MemoryGame {
	public static void main(String[] args) {
		play();
	}

	private static void play() {
		String[] frontFileNames = { "can.jpg", "flopsy_mopsy_cottontail.jpg", "friends.jpg", "mother_ladybird.jpg",
				"mr_mcgregor.jpg", "mrs_rabbit.jpg", "mrs_tittlemouse.jpg", "radishes.jpg" };

		MemoryBoard board = new MemoryBoard(frontFileNames.length / 2, "back.jpg", frontFileNames);
		MemoryWindow window = new MemoryWindow(board);
		int tries = 0;

		while (!board.hasWon()) {
			window.drawBoard();
			int[] c1 = registerClick(window, board);
			int[] c2 = registerClick(window, board);

			SimpleWindow.delay(800);

			if (!board.same(c1[0], c1[1], c2[0], c2[1])) {
				board.turnCard(c1[0], c1[1]);
				board.turnCard(c2[0], c2[1]);
			}

			tries++;
		}

		window.close();

		int replay = JOptionPane.showConfirmDialog(null, "Det tog dig " + tries
				+ " försök att klara memory.\nVill du spela igen?", "Du vann!",
				JOptionPane.YES_NO_OPTION);

		if (replay == 0) {
			play();
		}
	}

	private static int[] registerClick(MemoryWindow w, MemoryBoard b) {
		w.waitForMouseClick();
		int r = w.getMouseRow(), c = w.getMouseCol();

		if (b.frontUp(r, c)) {
			return registerClick(w, b);
		}

		b.turnCard(r, c);
		w.drawCard(r, c);

		return new int[] { r, c };
	}
}
