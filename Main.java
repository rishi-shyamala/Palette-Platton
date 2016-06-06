import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;


public class Main {
   public static JFrame frame;
   public static void main(String[] args) {
   
      JPanel container = new JPanel();
      container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
      
      Grid mainPanel = new Grid(30, 30, 20, 0.27);
      mainPanel.display();
      
      JPanel button = new JPanel();
      JButton color1 = new JButton("Red");
      button.add(color1);
      JButton color2 = new JButton("Blue");
      button.add(color2);
      JButton color3 = new JButton("Green");
      button.add(color3);
      JButton color4 = new JButton("Yellow");
      button.add(color4);
      //color4.addActionListener(new testListener());
      JButton quit = new JButton("Quit");
      quit.addActionListener(new quitListener());
      button.add(quit);

      
      container.add(mainPanel);
      container.add(button);
      
      frame = new JFrame("The Main Panel");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(container);
      frame.setLocation(860, 310);
      frame.pack();
      frame.setVisible(true);
      
    }


   private static class quitListener implements ActionListener
   {
      private String[] args;
      public void actionPerformed(ActionEvent e)
      {
      frame.dispose();
      }
   }
//    private static class testListener implements ActionListener
//    {
//       private String[] args;
//       public void actionPerformed(ActionEvent e)
//       {
//       frame.invalidate();
//       frame.validate();
//       frame.repaint();
//       }
//    }
}
