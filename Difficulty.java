import java.awt.BorderLayout;
import java.util.Hashtable;
import javax.swing.*;
import javax.swing.JPanel;
import java.awt.event.*;
import java.awt.*;
import javax.swing.event.*;

/***
*This Difficulty class will prompt the player for the difficulty of the AI.
*
*@author Rishi
*@version 1.1.2
*@since 11:13 PM 6/5/16
***/

public class Difficulty extends JPanel {
  /**
   * This static variable is what we translate the user's pick into.
  **/
  public static int value;
   /**
   * This static variable stores the public Frame;
  **/
  static JFrame frame;
  
  /**
   * This is an accessor method for the variable value.
   * @return int the variable value
  **/
  public static int getValue(){
      return value;
  }
  
  /**
   * This is the constructor for the Difficulty class.
   * @param ArtificialI the JSlider input
  **/
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
   * This is the main method for Difficulty.java class.
  **/
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
    * This is Button Listener class implements ACtionListener.
    **/
     private class ButtonListener implements ActionListener
     {
        private String[] args;
        /**
        * This method actionPerformed performs the 
        * action when the button is clicked.
        **/
        public void actionPerformed(ActionEvent e)
        {
        frame.dispose();
        Startup.main(args);
        }
     }
}
