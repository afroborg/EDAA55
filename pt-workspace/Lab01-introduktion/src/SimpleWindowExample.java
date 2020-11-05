import java.awt.Color;

import se.lth.cs.pt.window.SimpleWindow;

public class SimpleWindowExample {
    public static void main(String[] args) {
        int size = 600, offset = size / 5;
        SimpleWindow w = new SimpleWindow(size, size, "Drawing Window");
        w.moveTo(offset, offset);

        w.setLineColor(Color.RED);
        w.lineTo(offset, size - offset);
        w.lineTo(size - offset, size - offset);
        w.lineTo(size - offset, offset);
        w.lineTo(offset, offset);

    }
}