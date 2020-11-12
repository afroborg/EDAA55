import se.lth.cs.pt.maze.Maze;
import se.lth.cs.pt.window.SimpleWindow;

public class MazeTurtle {
    public static void main(String[] args) {
        Maze m = new Maze(5);
        SimpleWindow w = new SimpleWindow(400, 500, "MazeTurtle");
        Turtle t = new Turtle(w, m.getXEntry(), m.getYEntry());

        MazeWalker mw = new MazeWalker(t);

        m.draw(w);
        mw.walk(m);
    }
}
