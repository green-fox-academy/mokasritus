import javax.swing.*;

import java.awt.*;

import static java.awt.image.ImageObserver.HEIGHT;
import static java.awt.image.ImageObserver.WIDTH;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Diagonals {
  public static void mainDraw(Graphics graphics) {
    // Draw the canvas' diagonals.
    // If it starts from the upper-left corner it should be green, otherwise it should be red.
    int x = WIDTH;
    int y = 0;
    int z = 0;
    int v = HEIGHT;


    if (x==0 && y==0 ||y==HEIGHT) {
      graphics.setColor(Color.GREEN);
      graphics.drawLine(x, y, z, v);
    } else {
      graphics.setColor(Color.RED);
      graphics.drawLine(x, y, z, v);
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