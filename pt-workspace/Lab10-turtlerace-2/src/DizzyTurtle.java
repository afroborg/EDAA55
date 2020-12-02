import java.util.Random;

public class DizzyTurtle extends RaceTurtle {
	private int dizzyness;
	private Random rand;
	
	public DizzyTurtle(RaceWindow w, int nbr) {
		super(w, nbr);
		 this.rand = new Random();
		 this.dizzyness = rand.nextInt(5) + 1;
	}
	
	public void raceStep() {
		int newDir = rand.nextInt(20) - 10;
		this.left(newDir * dizzyness);
		super.raceStep();
		
		if(this.getDirection() > 90 || this.getDirection() < -90) {
			this.direction = 0;
		}
	}
	
	public String toString() {
		return super.toString() + ": DizzyTurtle (Yrsel:" + this.dizzyness + ")";
	}

}
