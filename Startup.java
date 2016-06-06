import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JSlider;

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
      
      JButton difficulty = new JButton("Difficulty");
      difficulty.addActionListener(new difficultyListener());
      StartScreen.add(difficulty);
      
      JLabel space2 = new JLabel("--------------------------------");
      StartScreen.add(space2);
      
      JButton play = new JButton("Play");
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
   private static class difficultyListener implements ActionListener
   {  
      private String[] args;
      public void actionPerformed(ActionEvent e)
      {
      Difficulty.main(args);
      frame.dispose();
      }
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
      Main.main(args);
      frame.dispose();
      }
   }
}