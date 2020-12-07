public class DizzyTurtle extends RaceTurtle {
	private int dizzyness;

	public DizzyTurtle(RaceWindow w, int nbr) {
		super(w, nbr);
		this.dizzyness = this.randomNumber(1, 5);
	}

	public void raceStep() {
		int newDir = this.randomNumber(-10, 10); // New random direction between -10 and 10 degrees
		this.left(newDir * dizzyness); // Add the turltes dizzyness
		super.raceStep();

		// Move it back if it strays too far off track
		if (this.getDirection() > 90 || this.getDirection() < -90) {
			this.setDirection(0);
		}
	}

	public String toString() {
		return super.toString() + ": DizzyTurtle (Yrsel:" + this.dizzyness + ")";
	}

}
