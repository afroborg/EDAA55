import java.util.ArrayList;
import java.util.Random;

public class TurtleRace {
	public static void main(String[] args) {
		RaceWindow w = new RaceWindow();
		ArrayList<RaceTurtle> racingTurtles = new ArrayList<RaceTurtle>();
		ArrayList<RaceTurtle> doneTurtles = new ArrayList<RaceTurtle>();

		// Initialize turtles
		for (int i = 1; i < 9; i++) {
			Random rand = new Random();
			RaceTurtle t;
			switch (rand.nextInt(3)) {
				case 0:
					t = new MoleTurtle(w, i);
					break;
				case 1:
					t = new AbsentMindedTurtle(w, i);
					break;
				case 2:
					t = new DizzyTurtle(w, i);
					break;

				// Wont actually happen, just to make eclipse happy
				default:
					t = new RaceTurtle(w, i);
			}

			racingTurtles.add(t);
			System.out.println(t);
		}

		// Loop until all racing turtles are done
		while (!racingTurtles.isEmpty()) {

			// Loop all racing turtles
			for (int i = 0; i < racingTurtles.size(); i++) {
				RaceTurtle t = racingTurtles.get(i);
				t.raceStep();

				RaceWindow.delay(2);

				// Check if the turtle has passed the line
				if (t.getX() >= RaceWindow.X_END_POS) {
					// Add it to done
					doneTurtles.add(t);

					// Remove it from racing
					racingTurtles.remove(t);

					// Go back so that it doesn't skip anyone
					i--;
				}
			}
		}

		System.out.println("\rLopp över, se resultat nedan:");

		// Print top 3 turtles
		for (int i = 0; i < 3; i++) {
			System.out.println("På plats " + (i + 1) + ": " + doneTurtles.get(i));
		}

	}
}
