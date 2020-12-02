import java.util.Random;

public class MoleTurtle extends RaceTurtle {

	public MoleTurtle(RaceWindow w, int nbr) {
		super(w, nbr);
	}

	public void raceStep() {
		Random rand = new Random();
		if (rand.nextBoolean()) {

			/*
			 * Samma sak här, isPenDown måste man ha access till
			 */
			if (this.isDrawing()) {
				this.penUp();
			} else {
				this.penDown();
			}
		}

		super.raceStep();
	}
	
	public String toString() {
		return super.toString() + " - MoleTurtle";
	}

}
