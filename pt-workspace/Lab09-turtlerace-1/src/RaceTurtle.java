import java.util.Random;

public class RaceTurtle extends Turtle {
	private int nbr;

	public RaceTurtle(RaceWindow w, int nbr) {
		super(w, RaceWindow.getStartXPos(nbr), RaceWindow.getStartYPos(nbr));
		this.nbr = nbr;
		this.penDown();

		/*
		 * Måste ändra direction så att den springer åt höger, Hur gör jag det på ett
		 * bättre sätt än att sätta protected och ändra?
		 */

		this.direction = 0;
	}

	public void raceStep() {
		Random rand = new Random();
		this.forward(rand.nextInt(6) + 1);
	}

	public String toString() {
		return "Nummer " + this.nbr;
	}
}
