import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JSlider;
/***
*This is the class for the panel and driver for when 
* the player wins the game.
*
*@author Rishi
*@version 1.1.2
*@since 3:29 PM 6/5/16
***/
public class Win
{
   /**
    * This is so that the win screen is public
    * */
   public static JFrame frame;
   /** This is the main method for the panel
    * and driver
    * */
   public static void main(String[] args)
   {  
      JPanel StartScreen = new JPanel();
      StartScreen.setLayout(new FlowLayout());
      
      JLabel title = new JLabel("You Win!");
      title.setFont(new Font("Serif", Font.BOLD, 40));
      title.setForeground(Color.red);
      StartScreen.add(title);
      
      JButton play = new JButton("Reset");
      play.addActionListener(new playListener());
      StartScreen.add(play);
      
      JLabel space3 = new JLabel("--------------------------------");
      StartScreen.add(space3);
      
      JButton quit = new JButton("Quit");
      quit.addActionListener(new quitListener());
      StartScreen.add(quit);
      
      frame = new JFrame("Palette Platoon");
      frame.setSize(200, 250);
      frame.setLocation(860, 310);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      frame.getContentPane().add(StartScreen);
      frame.setVisible(true);
   }
    /**
     * This quits the game
     * */
    private static class quitListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
      frame.dispose();
      }
   }
   /**this resets the game
    * */
   private static class playListener implements ActionListener
   {  
      private String[] args;
      public void actionPerformed(ActionEvent e)
      {
      Startup.main(args);
      frame.dispose();
      }
   }
}
