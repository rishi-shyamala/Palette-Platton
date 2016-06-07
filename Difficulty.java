import java.awt.BorderLayout;
import java.util.Hashtable;
import javax.swing.*;
import javax.swing.JPanel;
import java.awt.event.*;
import java.awt.*;
import javax.swing.event.*;
/** This class includes a slider for 
 * 
 * */
public class Difficulty extends JPanel {
  public static int value;
  static JFrame frame;
  
  public static int getValue(){
      return value;
  }
  
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
