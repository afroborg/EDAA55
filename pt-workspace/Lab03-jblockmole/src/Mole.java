public class Mole {
    final int width = 30;
    final int height = 50;
    final int blockSize = 10;
    final int skyHeight = 4;
    final int grassHeight = 1;

    private Graphics g = new Graphics(width, height, blockSize);

    public static void main(String[] args) {
        System.out.println("Keep on digging!");
        Mole m = new Mole();
        m.drawWorld();
        // m.dig();
        m.initDig(m);
    }

    public void drawWorld() {
        g.rectangle(0, 0, width, skyHeight, Colors.SKY);
        g.rectangle(0, skyHeight, width, grassHeight, Colors.GRASS);
        g.rectangle(0, skyHeight + grassHeight, width, height - (skyHeight + grassHeight), Colors.SOIL);
    }

    public void dig() {
        int x = g.getWidth() / 2 - 1, y = g.getHeight() / 2 - 1;

        while (true) {
            g.block(x, y, Colors.MOLE);
            char key = g.waitForKey();
            g.block(x, y, y == skyHeight ? Colors.GRASS : Colors.TUNNEL);
            switch (key) {
                case 'w':
                    if (y > skyHeight)
                        y--;
                    break;
                case 'a':
                    if (x > 0)
                        x--;
                    break;
                case 's':
                    if (y < height - 1)
                        y++;
                    break;
                case 'd':
                    if (x < width - 1)
                        x++;
                    break;
            }
        }

    }

    public void initDig(Mole m) {
        m.digRecursive(g.getWidth() / 2 - 1, g.getHeight() / 2 - 1);
    }

    // Recursive instead of while(true)
    public void digRecursive(int x, int y) {
        if (x < 0) {
            digRecursive(0, y);
        }
        if (y < skyHeight) {
            digRecursive(x, skyHeight);
        }
        if (x > width - 1) {
            digRecursive(width - 1, y);
        }
        if (y > height - 1) {
            digRecursive(x, height - 1);
        }

        g.block(x, y, Colors.MOLE);

        char key = g.waitForKey();
        g.block(x, y, y == skyHeight ? Colors.GRASS : Colors.TUNNEL);
        switch (key) {
            case 'w':
                digRecursive(x, y - 1);
                break;
            case 'a':
                digRecursive(x - 1, y);
                break;
            case 's':
                digRecursive(x, y + 1);
                break;
            case 'd':
                digRecursive(x + 1, y);
                break;
        }

    }
}