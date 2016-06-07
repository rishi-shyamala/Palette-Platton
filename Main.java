import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
/***
*This Main class is for the functionality for the 
* Grid and for the AI and Buttons.
*
*@author Rishi
*@version 1.1.2
*@since 3:29 PM 6/5/16
***/


public class Main {
   /**
    * This is so that the frame is accesible from all 
    * over the program
    * */
    
   public static JFrame frame;
   
   /**
    * This is so that the panel, the grid
    * object, can ce accesses from all over
    * the program.
    * */
   public static Grid mainPanel;
   /**
    * This is the player class for 
    * the artificial intelligence
   */
   public static Player comp;
   /**
    * This is the class for the human class for clicking the buttons.
    * */
   public static HumanPlayer h;
   /**
    * The main method.
    * */
   public static void main(String[] args) {
      
     mainPanel = new Grid(50, 50, 17, 0.27);
     mainPanel.display();
      
      if (Difficulty.getValue() == -1){
         comp = new EasyPlayer();
      }
      else if (Difficulty.getValue() == 0){
         comp = new MediumPlayer();
      }
      else if (Difficulty.getValue() == 1){
         comp = new HardPlayer();
      }
      
      h = new HumanPlayer();
      
      JPanel container = new JPanel();
      container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
      
      
      
      JPanel button = new JPanel();
      
      JButton color1 = new JButton("Red");
      color1.addActionListener(new redListener());
      button.add(color1);
      
      JButton color2 = new JButton("Blue");
      color2.addActionListener(new blueListener());
      button.add(color2);
      
      JButton color3 = new JButton("Green");
      color3.addActionListener(new greenListener());
      button.add(color3);
      
      JButton color4 = new JButton("Yellow");
      color4.addActionListener(new yellowListener());
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
    
   private static class redListener implements ActionListener
   {
      private String[] args;
      public void actionPerformed(ActionEvent e)
      {
      h.thinkMove(mainPanel.getColors(), GamePixel.RED);
      mainPanel.display();
      comp.thinkMove(mainPanel.getColors());
      mainPanel.display();
      }
   }
   
   private static class blueListener implements ActionListener
   {
      private String[] args;
      public void actionPerformed(ActionEvent e)
      {
      h.thinkMove(mainPanel.getColors(), GamePixel.BLUE);
      mainPanel.display();
      comp.thinkMove(mainPanel.getColors());
      mainPanel.display();
      }
   }   
   
      private static class greenListener implements ActionListener
   {
      private String[] args;
      public void actionPerformed(ActionEvent e)
      {
      h.thinkMove(mainPanel.getColors(), GamePixel.GREEN);
      mainPanel.display();
      comp.thinkMove(mainPanel.getColors());
      mainPanel.display();
      }
   }

   private static class yellowListener implements ActionListener
   {
      private String[] args;
      public void actionPerformed(ActionEvent e)
      {
      h.thinkMove(mainPanel.getColors(), GamePixel.YELLOW);
      mainPanel.display();
      comp.thinkMove(mainPanel.getColors());
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
}
