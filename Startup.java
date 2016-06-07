import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JSlider;

/***
*This is essentially the Driver of the game.
*@author Rishi
*@version 1.1.2
*@since 11:07 PM 6/5/16
***/
public class Startup
{
   public static JFrame frame;
   public static void main(String[] args)
   {  
      JPanel StartScreen = new JPanel();
      StartScreen.setLayout(new FlowLayout());
      
      JLabel title = new JLabel("Palette Platoon");
      title.setFont(new Font("Serif", Font.BOLD, 20));
      title.setForeground(Color.red);
      StartScreen.add(title);
      
      /***
      * Sets up button controlling difficulty
      ***/
      JButton difficulty = new JButton("Difficulty");
      difficulty.addActionListener(new difficultyListener());
      StartScreen.add(difficulty);
      
      JLabel space2 = new JLabel("--------------------------------");
      StartScreen.add(space2);
      
      /***
      * Sets up button for playing the game
      ***/
      JButton play = new JButton("Play");
      play.addActionListener(new playListener());
      StartScreen.add(play);
      
      JLabel space3 = new JLabel("--------------------------------");
      StartScreen.add(space3);
      
      /***
      * Sets up button for quitting the game
      ***/
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
   
   /***
    * Implements listener for changing difficulty
    ***/
   private static class difficultyListener implements ActionListener
   {  
      private String[] args;
      public void actionPerformed(ActionEvent e)
      {
      Difficulty.main(args);
      frame.dispose();
      }
   }
   
   /***
    * Implements listener for Quitting Game
    ***/
    private static class quitListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
      frame.dispose();
      }
   }
   
   /***
    * Implements listener for Play the Game
    ***/
   private static class playListener implements ActionListener
   {  
      private String[] args;
      public void actionPerformed(ActionEvent e)
      {
      Main.main(args);
      frame.dispose();
      }
   }
}
