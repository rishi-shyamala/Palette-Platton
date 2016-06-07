import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JSlider;

/***
*This Grid class displays the "You Lose" screen.
*@author Rishi
*@version 1.1.2
*@since 10:48 PM 6/5/16
***/
public class Lose
{
   /**
   *This is the JFrame used for displaying "You Lose" screen as well as reset and quit buttons.
   **/
   public static JFrame frame;
   
   /***
   *This method is used for displaying "You Lost" 
   *as well as providing a reset button to start over and quit button to quit the game.
   ***/
   public static void main(String[] args)
   {  
      JPanel StartScreen = new JPanel();
      StartScreen.setLayout(new FlowLayout());
      
      JLabel title = new JLabel("You Lose!");
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
    
    private static class quitListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
      frame.dispose();
      }
   }
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
