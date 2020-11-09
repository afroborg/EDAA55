import se.lth.cs.pt.maze.Maze;
import se.lth.cs.pt.window.SimpleWindow;

public class MazeWalker {
    private Turtle turtle;

    public MazeWalker(Turtle turtle) {
        this.turtle = turtle;
        this.turtle.penDown();
    }

    /**
     * Låter sköldpaddan vandra genom labyrinten maze, från ingången till utgången.
     */
    public void walk(Maze maze) {
        int nbrSteps = 0, nbrTurns = 0;
        while(!maze.atExit(this.turtle.getX(), this.turtle.getY())) {
            int x = this.turtle.getX(), y = this.turtle.getY(), dir = this.turtle.getDirection();
            if(!maze.wallAtLeft(dir, x, y)) {
                this.turtle.left(90);
                nbrTurns++;
            }

            if(maze.wallInFront(dir, x, y)) {
                if(maze.wallAtLeft(dir, x, y)) {
                    this.turtle.left(-90);
                }
                else {
                    this.turtle.left(90);
                }
                nbrTurns++;
            }

            this.turtle.forward(1);

            SimpleWindow.delay(1);
            nbrSteps++;
        }

        System.out.println("Im out! I took " + nbrSteps + " steps and made " + nbrTurns + " turns");


    }
}