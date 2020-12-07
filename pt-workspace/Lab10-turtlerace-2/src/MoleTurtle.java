public class MoleTurtle extends RaceTurtle {

	public MoleTurtle(RaceWindow w, int nbr) {
		super(w, nbr);
	}

	public void raceStep() {
		if (this.randomBool()) {
			// Checking if the pen is up or down
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
