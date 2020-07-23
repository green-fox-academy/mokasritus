import java.util.Random;
import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class HorizontalLines {
  public static void mainDraw(Graphics graphics) {
    // Create a function that draws a single line and takes 3 parameters:
    // The x and y coordinates of the line's starting point and the graphics
    // and draws a 50 long horizontal line from that point.
    // Draw at least 3 lines with that function using a loop.

    for (int i = 0; i < 3; i++) {
      int x = getRandomXCoordinate();
      int y = getRandomYCoordinate();
      drawThree50LongHorizontalLine(x, y, graphics);
    }
    

  }
  public static void drawThree50LongHorizontalLine (int x1,int y1, Graphics graphics){
      int x2 = x1 + 50;
      int y2 = y1;
      graphics.drawLine(x1, y1, x2, y2);
  }

  public static int getRandomXCoordinate() {
    Random random = new Random();
    int limitX = WIDTH;
    return random.nextInt(limitX);
  }

  public static int getRandomYCoordinate() {
    Random random = new Random();
    int limitX = HEIGHT;
    return random.nextInt(limitX);
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