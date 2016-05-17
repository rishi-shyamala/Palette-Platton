import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class Difficulty extends JPanel {

  public Difficulty() {

    super(true);
    this.setLayout(new BorderLayout());
    JSlider ArtificialI = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);

    ArtificialI.setMinorTickSpacing(10);
    ArtificialI.setMajorTickSpacing(10);
    ArtificialI.setPaintTicks(true);
    ArtificialI.setPaintLabels(true);
    ArtificialI.setSnapToTicks(true);

    ArtificialI.setLabelTable(ArtificialI.createStandardLabels(10));

    add(ArtificialI, BorderLayout.CENTER);
  }

  public static void main(String s[]) {
    JFrame frame = new JFrame("Slider Example");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setContentPane(new Difficulty());
    frame.pack();
    frame.setVisible(true);
  }
}