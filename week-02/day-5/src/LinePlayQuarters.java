import static javax.swing.JFrame.EXIT_ON_CLOSE;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LinePlayQuarters {

  public static void mainDraw(Graphics graphics) {

    int numberLines = 13;
    for (int i = 0; i < numberLines; i++) {
      int[] coordinatesTop = calculateTopCoordinates(i, numberLines);
      graphics.setColor(Color.BLUE);
      graphics.drawLine(coordinatesTop[0], coordinatesTop[1], coordinatesTop[2], coordinatesTop[3]);
      int[] coordinatesBottom = calculateBottomCoordinates(i, numberLines);
      graphics.setColor(Color.GREEN);
      graphics.drawLine(coordinatesBottom[0], coordinatesBottom[1], coordinatesBottom[2],
          coordinatesBottom[3]);
    }
  }

  public static int[] calculateTopCoordinates(int i, int numberLines) {
    int delta = WIDTH / numberLines;
    int x1 = (i + 1) * delta;
    int y1 = 0;
    int x2 = WIDTH;
    int y2 = y1 + (i + 1) * delta;
    return new int[] {x1, y1, x2, y2};
  }

  public static int[] calculateBottomCoordinates(int i, int numberLines) {
    int delta = WIDTH / numberLines;
    int x1 = 0;
    int y1 = (i + 1) * delta;
    int x2 = x1 + (i + 1) * delta;
    int y2 = HEIGHT;
    return new int[] {x1, y1, x2, y2};
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