import java.util.ArrayList;

public class TurtleRace {
	public static void main(String[] args) {
		RaceWindow w = new RaceWindow();
		ArrayList<RaceTurtle> racingTurtles = new ArrayList<RaceTurtle>();
		ArrayList<RaceTurtle> doneTurtles = new ArrayList<RaceTurtle>();

		// Initialize turtles
		for (int i = 0; i < 8; i++) {
			racingTurtles.add(new RaceTurtle(w, i + 1));
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

		// Print top 3 turtles
		for (int i = 0; i < 3; i++) {
			System.out.println("På plats " + (i + 1) + ": " + doneTurtles.get(i));
		}

	}
}
