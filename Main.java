import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;


public class Main {

   public static JFrame frame;
   public static Grid mainPanel;
   public static Player m;
   public static void main(String[] args) {
      
     mainPanel = new Grid(30, 30, 20, 0.27);
     mainPanel.display();
      
      if (Difficulty.getValue() == -1){
         m = new EasyPlayer();
      }
      else if (Difficulty.getValue() == 0){
         m = new MediumPlayer();
      }
      else if (Difficulty.getValue() == 1){
         m = new HardPlayer();
      }
      
      JPanel container = new JPanel();
      container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
      
      JPanel button = new JPanel();
      JButton color1 = new JButton("Red");
      color1.addActionListener(new testListener());
      button.add(color1);
      JButton color2 = new JButton("Blue");
      button.add(color2);
      JButton color3 = new JButton("Green");
      button.add(color3);
      JButton color4 = new JButton("Yellow");
      button.add(color4);
      JButton reset = new JButton("Reset");
      reset.addActionListener(new resetListener());
      button.add(reset);
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

   private static class testListener implements ActionListener
   {
      private String[] args;
      public void actionPerformed(ActionEvent e)
      {
      m.thinkMove(mainPanel.getColors());
      mainPanel.display();
      }
   }
   
   private static class quitListener implements ActionListener
   {
      private String[] args;
      public void actionPerformed(ActionEvent e)
      {
      frame.dispose();
      }
   }
   
   private static class resetListener implements ActionListener
   {
      private String[] args;
      public void actionPerformed(ActionEvent e)
      {
      frame.dispose();
      Startup.main(args);
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
