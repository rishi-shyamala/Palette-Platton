import javax.swing.JFrame;

public class PlatoonDriver{
   public static void main(String[] args) {
      JFrame frame = new JFrame("Palette Platoons");
      frame.setSize(300, 250);
      frame.setLocation(100,50);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new Welcome());
      frame.setVisible(true);
   }
}
