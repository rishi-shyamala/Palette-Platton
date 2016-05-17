import javax.swing.JFrame;

public class Startup
{
   public static JFrame frame;
   public static void main(String[] args)
   {
      frame = new JFrame("Palette Platoon");
      frame.setSize(200, 300);
      frame.setLocation(860, 310);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      StartScreen start = new StartScreen();
      
      frame.setContentPane(start);
      frame.setVisible(true);
      while (true)
      {if (start.close == true)
         {
         frame.setVisible(false);
         frame.dispose();
         break;
         }
      }
   }
}