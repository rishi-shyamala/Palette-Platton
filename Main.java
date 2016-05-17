import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;

/***
*This is the Driver class for our program, and contains all of the visuals. 
*
*@author Chris, Suresh, Rishi
*@version 1.0
*@since 10:03 pm 5/16/16
***/

public class Main {
   public static void main(String[] args) {
      int rows = 40;
      int cols = 40;
      int cellWidth = 20;
      Grid mainPanel = new Grid(rows, cols, cellWidth, 0.08);

      JFrame frame = new JFrame("Color Grid Example");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
   }
}