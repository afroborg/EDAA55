import java.util.Random;

public class RaceTurtle extends Turtle {
	protected int nbr;
	private Random rand;

	public RaceTurtle(RaceWindow w, int nbr) {
		super(w, RaceWindow.getStartXPos(nbr), RaceWindow.getStartYPos(nbr));
		this.nbr = nbr;
		this.rand = new Random();

		this.penDown();
		this.setDirection(0);
	}

	public void raceStep() {
		this.forward(this.randomNumber(1, 6));
	}

	public int randomNumber(int from, int to) {
		return this.rand.nextInt(to - from) + from; // ❤️https://stackoverflow.com/questions/5271598/java-generate-random-number-between-two-given-values
	}

	public boolean randomBool() {
		return this.rand.nextBoolean();
	}

	public String toString() {
		return "Nummer " + this.nbr;
	}
}
