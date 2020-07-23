import java.awt.image.ImageObserver;
import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class CenteredSquare {

  public static void mainDraw(Graphics graphics) {
    // Draw a green 10x10 square to the canvas' center.



    int size = 10;

    int x1 = WIDTH / 2 - size / 2;
    int y1 = HEIGHT / 2 - size / 2;
    graphics.setColor(Color.GREEN);
    graphics.drawRect(x1, y1, size, size);
    // for (int i = 0; i < 4; i++) {

    //if (i % 2 == 0) {

    //int x2 = x1 + size;
    //int y2 = y1;
    // graphics.setColor(Color.GREEN);
    // graphics.drawLine(x1, y1, x2, y2);
    //} else {
    //int x2 = x1;
    //int y2 = y1 + size;
    //graphics.setColor(Color.GREEN);
    //graphics.drawLine(x1, y1, x2, y2);


    graphics.setColor(Color.GREEN);
    graphics.drawLine(WIDTH / 2 - size / 2, HEIGHT / 2 - size / 2, WIDTH / 2 + size / 2,
        HEIGHT / 2 - size / 2);

    graphics.setColor(Color.GREEN);
    graphics.drawLine(WIDTH / 2 + size / 2, HEIGHT / 2 - size / 2, WIDTH / 2 + size / 2,
        HEIGHT / 2 + size / 2);

    graphics.setColor(Color.GREEN);
    graphics.drawLine(WIDTH / 2 + size / 2, HEIGHT / 2 + size / 2, WIDTH / 2 - size / 2,
        HEIGHT / 2 + size / 2);

    graphics.setColor(Color.GREEN);
    graphics.drawLine(WIDTH / 2 - size / 2, HEIGHT / 2 + size / 2, WIDTH / 2 - size / 2,
        HEIGHT / 2 - size / 2);

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