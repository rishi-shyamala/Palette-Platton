import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JSlider;

public class StartScreen extends JPanel
   {
   
   private JLabel title;
   private JLabel space1;
   private JLabel space2;
   private JLabel space3;
   public boolean close = false;

   public StartScreen()
      {
      setLayout(new FlowLayout());
      
      title = new JLabel("Palette Platoon");
      title.setFont(new Font("Serif", Font.BOLD, 20));
      title.setForeground(Color.red);
      add(title);
      
      JButton size = new JButton("Size");
      //size.addActionListener(new sizeListener());
      add(size);
      
      space1 = new JLabel("--------------------------------");
      add(space1);
      
      JButton difficultly = new JButton("Difficulty");
      //difficulty.addActionListener(new difficultyListener());
      add(difficultly);
      
      space2 = new JLabel("--------------------------------");
      add(space2);
      
      JButton play = new JButton("Play");
      play.addActionListener(new playListener());
      add(play);
      
      space3 = new JLabel("--------------------------------");
      add(space3);
      
      JButton quit = new JButton("Quit");
      quit.addActionListener(new quitListener());
      add(quit);
      }
      
   private class quitListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
      close = true;
      }
   }
   
   private class playListener implements ActionListener
   {  
      private String[] args;
      public void actionPerformed(ActionEvent e)
      {
      Main.main(args);
      close = true;
      }
   }
   
   //private class difficultyListener implements ActionListener
}