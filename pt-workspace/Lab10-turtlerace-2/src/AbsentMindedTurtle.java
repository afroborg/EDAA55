public class AbsentMindedTurtle extends RaceTurtle {

	// Is this even a word?
	private int absentness;

	public AbsentMindedTurtle(RaceWindow w, int nbr) {
		super(w, nbr);

		this.absentness = this.randomNumber(0, 100); // Give the turtle a percentage of absentness from 0-100%
	}

	public void raceStep() {
		// Random check if turtle is too dizzy to walk forward
		if (this.randomNumber(0, 100) + 1 >= this.absentness) {
			super.raceStep();
		}
	}

	public String toString() {
		return super.toString() + " - AbsentMindedTurtle (" + this.absentness + "% frånvarande)";
	}

}
