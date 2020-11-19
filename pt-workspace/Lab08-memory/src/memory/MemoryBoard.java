package memory;

import java.util.Random;

public class MemoryBoard {
	int size;
	MemoryCardImage[][] cards;
	boolean[][] isTurned;

	/**
	 * Skapar ett memorybräde med size * size kort. backFileName är filnamnet för
	 * filen med baksidesbilden. Vektorn frontFileNames innehåller filnamnen för
	 * frontbilderna.
	 */
	public MemoryBoard(int size, String backFileName, String[] frontFileNames) {
		this.size = size;
		this.cards = new MemoryCardImage[size][size];
		this.isTurned = new boolean[size][size];

		this.createCards(backFileName, frontFileNames);
	}

	/*
	 * Skapar size * size / 2 st memorykortbilder. Placerar ut varje kort på två
	 * slumpmässiga ställen på spelplanen.
	 */
	private void createCards(String backFileName, String[] frontFileNames) {
		for (int i = 0; i < (this.size * this.size) / 2; i++) {
			MemoryCardImage card = new MemoryCardImage(frontFileNames[i], backFileName);
			placeCard(card);
			placeCard(card);
		}
	}

	/*
	 * Places two cards randomly on the board
	 */
	private void placeCard(MemoryCardImage card) {
		Random rand = new Random();
		int r = rand.nextInt(size), c = rand.nextInt(size);

		if (this.cards[r][c] == null) {
			this.cards[r][c] = card;
		} else {
			placeCard(card);
		}
	}

	/** Tar reda på brädets storlek. */
	public int getSize() {
		return this.size;
	}

	/**
	 * Hämtar den tvåsidiga bilden av kortet på rad r, kolonn c. Raderna och
	 * kolonnerna numreras från 0 och uppåt.
	 */
	public MemoryCardImage getCard(int r, int c) {
		return this.cards[r][c];
	}

	/** Vänder kortet på rad r, kolonn c. */
	public void turnCard(int r, int c) {
		this.isTurned[r][c] = !this.isTurned[r][c];
	}

	/** Returnerar true om kortet r, c har framsidan upp. */
	public boolean frontUp(int r, int c) {
		return this.isTurned[r][c];
	}

	/**
	 * Returnerar true om det är samma kort på rad r1, kolonn c2 som på rad r2,
	 * kolonn c2.
	 */
	public boolean same(int r1, int c1, int r2, int c2) {
		return this.cards[r1][c1].equals(this.cards[r2][c2]);
	}

	/** Returnerar true om alla kort har framsidan upp. */
	public boolean hasWon() {
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
				if (!this.isTurned[r][c]) {
					return false;
				}
			}
		}

		return true;
	}
}
