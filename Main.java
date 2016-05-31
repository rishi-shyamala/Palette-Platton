import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;

public class Main {
   public static void main(String[] args) {
      int rows = 30;
      int cols = 30;
      int cellWidth = 20;
      Grid mainPanel = new Grid(rows, cols, cellWidth, 0.27);
      Grid testGrid = new Grid(rows, cols, cellWidth, 0.27);
      testGrid.setColors(mainPanel.getColors());
      // mainPanel.printColors();
      //testGrid.printColors();
      
      //first display
      mainPanel.display();
      testGrid.display();
      
      // //official testing floodFill
//       GamePixel[][] test = testGrid.getColors();
//       System.out.println(test[0].length);
//       boolean[][] mark = new boolean[test.length][test[0].length];
//       //System.out.println(test[1][1]);//see what the color was
//       testGrid.floodFill(mark, 1, 1, test[1][1]);
      
      //testGrid.printColors();
      
      testGrid.display();
      
      //Official testing      
      GamePixel[][] test = testGrid.getColors();
      boolean[][] mark = new boolean[test.length][test[0].length];
      Player m = new HardPlayer();
         //testing floodSearch
      // int n = m.floodSearch(test, mark, 1, 1, test[1][1], 0); //  see if floodSearch works for player also
//       System.out.println(n);
      //System.out.println(test[28][29]);
      //System.out.println("28 29:   " + test[28][29]);
      //System.out.println("29 28:   " + test[29][28]);
      
      test = m.thinkMove(test);
      testGrid.setColors(test);
      testGrid.display();
      
         //isTouchingAI() testing
     
      
      // boolean t = false;
//       while(!t){
//          
//       }



      JFrame frame = new JFrame("The Main Panel");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
      
      JFrame frame2 = new JFrame("Test Grid");
      frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame2.getContentPane().add(testGrid);
      frame2.pack();
      frame2.setLocationByPlatform(true);
      frame2.setVisible(true);
      
      testGrid.display();
   }
}
