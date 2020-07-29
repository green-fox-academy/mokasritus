import static javax.swing.JFrame.EXIT_ON_CLOSE;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SierpinskiCarpit {

  public static void mainDraw(Graphics graphics) {
    int size = WIDTH/3;

    int x1 = WIDTH / 2 - size / 2;
    int y1 = HEIGHT / 2 - size / 2;

    drawCenteredSquare(graphics, x1, y1, WIDTH, HEIGHT, 6);

  }

  private static int drawCenteredSquare(Graphics graphics, int xi, int yi, int WIDTH, int HEIGHT,
                                        int depht) {

    int newWidth = WIDTH / 3;
    int newHeight = HEIGHT / 3;
    int x = WIDTH / 2 - (WIDTH/3/2);
    int y = HEIGHT / 2 - (HEIGHT/3/2);
    graphics.setColor(Color.GREEN);
    graphics.fillRect(x, y, newWidth, newHeight);

    int x1 = 0;
    int y1 = 0;
    if (depht > 1) {
      int sum = 0;
      for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
          x1 = i * WIDTH / 2 ;
          y1 = i * HEIGHT / 2;

          sum = sum + drawCenteredSquare(graphics, x1, y1, newWidth, newHeight, depht - 1);

        }
      } return 1 + sum;
    } else {
      return 1;
    }
  }

  // Don't touch the code below
  static int WIDTH = 320;
  static int HEIGHT = 320;

  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Drawing");
    jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    ImagePanel panel = new ImagePanel();
    panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    jFrame.add(panel);
    jFrame.setLocationRelativeTo(null);
    jFrame.setVisible(true);
    jFrame.pack();
  }

  static class ImagePanel extends JPanel {
    @Override
    protected void paintComponent(Graphics graphics) {
      super.paintComponent(graphics);
      mainDraw(graphics);
    }
  }
}