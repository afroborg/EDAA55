import se.lth.cs.pt.window.SimpleWindow;

public class Turtle {
	final private SimpleWindow w;

	// Current x- and y coordinates for the turtle
	private double x; // * Attribut, används i ctor, forward, getX, jumpTo osv.
	private double y;
	// Degree from north that the turtle is facing
	protected double direction;
	
	private boolean isPenDown;

	/**
	 * Skapar en sköldpadda som ritar i ritfönstret w. Från början befinner sig
	 * sköldpaddan i punkten x, y med pennan lyft och huvudet pekande rakt uppåt i
	 * fönstret (i negativ y-riktning).
	 */
	public Turtle(SimpleWindow w, int x, int y) {
		this.w = w;
		this.x = x;
		this.y = y;

		// Set turtle to point north on startup
		this.direction = Math.toRadians(90);
		this.isPenDown = false;
		this.w.moveTo(x, y);

		// * Lokal variabel, används inte men hade ingen annan :)
		// int a = 1;
	}

	/** Sänker pennan. */
	public void penDown() {
		this.isPenDown = true;
	}

	/** Lyfter pennan. */
	public void penUp() {
		this.isPenDown = false;
	}

	/** Går rakt framåt n pixlar i den riktning huvudet pekar. */
	public void forward(int n) { // * n = parameter, sträckan som turtle ska röra sig i den riktning den pekar
									// mot.
		this.w.moveTo((int) Math.round(this.x), (int) Math.round(this.y));

		// Calculate new coordinates
		this.x += n * Math.cos(this.direction);
		this.y -= n * Math.sin(this.direction);

		if (this.isPenDown)
			this.w.lineTo((int) Math.round(this.x), (int) Math.round(this.y));
		else
			this.w.moveTo((int) Math.round(this.x), (int) Math.round(this.y));
	}

	/** Vrider beta grader åt vänster runt pennan. */
	public void left(int beta) {
		this.direction += Math.toRadians(beta);
	}

	/**
	 * Går till punkten newX, newY utan att rita. Pennans läge (sänkt eller lyft)
	 * och huvudets riktning påverkas inte.
	 */
	public void jumpTo(int newX, int newY) {
		w.moveTo(newX, newY);

		this.x = newX;
		this.y = newY;
	}

	/** Återställer huvudriktningen till den ursprungliga. */
	public void turnNorth() {
		this.direction = Math.toRadians(90);
	}

	/** Tar reda på x-koordinaten för sköldpaddans aktuella position. */
	public int getX() {
		return (int) Math.round(this.x);
	}

	/** Tar reda på y-koordinaten för sköldpaddans aktuella position. */
	public int getY() {
		return (int) Math.round(this.y);
	}

	/** Tar reda på sköldpaddans riktning, i grader från den positiva X-axeln. */
	public int getDirection() {
		return (int) Math.toDegrees(this.direction);
	}
	
	public boolean isDrawing() {
		return this.isPenDown;
	}
}
