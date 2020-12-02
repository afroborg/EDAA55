import java.util.Random;

public class AbsentMindedTurtle extends RaceTurtle {

	// Is this even a word?
	private int absentness;
	private Random rand;

	public AbsentMindedTurtle(RaceWindow w, int nbr) {
		super(w, nbr);
		
		this.rand = new Random();
		this.absentness = rand.nextInt(100);
	}

	public void raceStep() {
		// Random check if turtle is too dizzy to walk forward
		if ((rand.nextInt(100) + 1) >= this.absentness) {
			super.raceStep();
		}
	}
	
	public String toString() {
		return super.toString() + " - AbsentMindedTurtle (" + this.absentness + "% frånvarande)";
	}

}
