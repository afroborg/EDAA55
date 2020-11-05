import java.awt.Color;

import se.lth.cs.pt.window.SimpleWindow;

public class Graphics {
    private SimpleWindow w;
    private int width;
    private int height;
    private int blockSize;

    public Graphics(int w, int h, int b) {
        this.width = w;
        this.height = h;
        this.blockSize = b;

        this.w = new SimpleWindow(this.width * this.blockSize, this.height * this.blockSize, "Digging");
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public void square() {
        w.moveTo(10, 10);
        w.lineTo(10, 20);
        w.lineTo(20, 20);
        w.lineTo(20, 10);
        w.lineTo(10, 10);
    }

    public void block(int x, int y, Color c) {
        int left = x * blockSize;
        int right = left + blockSize - 1;
        int top = y * blockSize;
        int bottom = top + blockSize - 1;
        w.setLineColor(c);
        for (int row = top; row <= bottom; row++) {
            w.moveTo(left, row);
            w.lineTo(right, row);
        }
    }

    public void rectangle(int x, int y, int width, int height, Color c) {
        for (int yy = y; yy < y + height; yy++) {
            for (int xx = x; xx < x + width; xx++) {
                block(xx, yy, c);
            }
        }
    }

    public char waitForKey() {
        return w.waitForKey();
    }

}
