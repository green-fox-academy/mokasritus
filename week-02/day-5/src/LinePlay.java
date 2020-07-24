import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class LinePlay {
  public static void mainDraw(Graphics graphics) {

    for (int i = 0; i < WIDTH; i++) {
      int delta = 25;
      int x1 = 50 + i * delta;
      int y1 = 0;
      int x2 = WIDTH;
      int y2 = y1 + (i + 1) * delta;
      graphics.setColor(Color.BLUE);
      graphics.drawLine(x1, y1, x2, y2);
    }
    for (int i = 0; i < HEIGHT; i++) {
      int delta = 25;
      int x1 = 0;
      int y1 = 50 + i * delta;;
      int x2 = x1 + (i + 1) * delta;
      int y2 = HEIGHT;
      graphics.setColor(Color.GREEN);
      graphics.drawLine(x1, y1, x2, y2);
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