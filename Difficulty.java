import java.awt.BorderLayout;
import java.util.Hashtable;
import javax.swing.*;
import javax.swing.JPanel;
import java.awt.event.*;
import java.awt.*;
import javax.swing.event.*;
/** This class includes a slider for the difficulty of the AI class.
 * 
 * @author Rishi
 * @version 1.1.2
 * @since 12:05 AM 06/07/2016
 * */
public class Difficulty extends JPanel {
  /**
   * This integer is the abitrary number assigned to the different difficulties
   * */
  public static int value;
  static JFrame frame;
  /**
   * This method allows the other classes to get the value of the difficulty
   * */
  public static int getValue(){
      return value;
  }
  /**
   * This makes a slider that is aligned to easy, medium, and hard.
   * The slider saves its position in a variable called value
   * everytime that it is changed. There is a button that goes back 
   * to the main Startup
   * @param ArtificialI is the name of the slider. 
   * */
  public Difficulty(JSlider ArtificialI) {

    super(true);
    this.setLayout(new BorderLayout());
    ArtificialI = new JSlider(JSlider.HORIZONTAL, -1, 1, 0);

    ArtificialI.setMinorTickSpacing(1);
    ArtificialI.setMajorTickSpacing(1);
    ArtificialI.setPaintTicks(true);
    ArtificialI.setPaintLabels(true);
    ArtificialI.setSnapToTicks(true);
    ArtificialI.addChangeListener(new ChangeListener(){
      public void stateChanged(ChangeEvent evt){
         JSlider ArtificialI = (JSlider) evt.getSource();
         if (!ArtificialI.getValueIsAdjusting()) {
            value = ArtificialI.getValue();
        }
      }
   });
 
    
      Hashtable<Integer, JLabel> table = new Hashtable<Integer, JLabel>();
      table.put (-1, new JLabel("Easy"));
      table.put (0, new JLabel("Medium"));
      table.put (1, new JLabel("Hard"));
      ArtificialI.setLabelTable (table);

      add(ArtificialI, BorderLayout.NORTH);
      JButton button = new JButton("Back");
      button.addActionListener(new ButtonListener());
      add(button, BorderLayout.SOUTH);
        
  }
    /**
     * This is the frame for the JSlider and button 
     * */
    public static void main(String args[]) {
      JSlider ArtificialI = new JSlider();
      frame = new JFrame("Difficulty");
      frame.setSize(200, 250);
      frame.setLocation(860, 310);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new Difficulty(ArtificialI));
      frame.pack();
      frame.setVisible(true);
     }
     /**
      * This class is specific to the button listener.
      * */
     private class ButtonListener implements ActionListener
     {
        private String[] args;
        public void actionPerformed(ActionEvent e)
        {
        frame.dispose();
        Startup.main(args);
        }
     }
}
