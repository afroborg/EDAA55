import java.awt.Color;

import se.lth.cs.pt.window.SimpleWindow;

public class SimpleWindowExample {
    public static void main(String[] args) {
        int height = 500, width = 500, offset = 100;
        SimpleWindow w = new SimpleWindow(width, height, "Drawing Window");
        w.setLineColor(Color.RED);
        w.moveTo(offset, offset);

        w.lineTo(offset, height - offset);
        w.lineTo(width - offset, height - offset);
        w.lineTo(width - offset, offset);
        w.lineTo(offset, offset);

    }
}