import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;


public class Main {
   private static String[] args;
   public static JFrame frame;
   public static JLabel human;
   public static JLabel ai;
   public static Grid mainPanel;
   public static Player comp;
   public static HumanPlayer h;
   public static int humanScore = 1;
   public static int aiScore = 1;
   public static JPanel button;
   
   public static void main(String[] args) {
      
     mainPanel = new Grid(50, 50, 17, 0.27);
     mainPanel.display();
      
      if (Difficulty.getValue() == -1){
         comp = new EasyPlayer();
      }
      else if (Difficulty.getValue() == 0){
         comp = new MediumPlayer();
      }
      else if (Difficulty.getValue() == 1){
         comp = new HardPlayer();
      }
      
      h = new HumanPlayer();
      
      JPanel container = new JPanel();
      container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
      
      
      
      button = new JPanel();
      
      human = new JLabel("Your Score = " + humanScore);
      human.setFont(new Font("Serif", Font.BOLD, 18));
      human.setForeground(Color.orange);     
      button.add(human);
      
      JButton color1 = new JButton("Red");
      color1.addActionListener(new redListener());
      button.add(color1);
      
      JButton color2 = new JButton("Blue");
      color2.addActionListener(new blueListener());
      button.add(color2);
      
      JButton color3 = new JButton("Green");
      color3.addActionListener(new greenListener());
      button.add(color3);
      
      JButton color4 = new JButton("Yellow");
      color4.addActionListener(new yellowListener());
      button.add(color4);
      
      JButton reset = new JButton("Reset");
      reset.addActionListener(new resetListener());
      button.add(reset);
      
      JButton quit = new JButton("Quit");
      quit.addActionListener(new quitListener());     
      button.add(quit);

      ai = new JLabel("Computer Score = " + aiScore);
      ai.setFont(new Font("Serif", Font.BOLD, 18));
      ai.setForeground(Color.cyan);
      button.add(ai);      
      
      container.add(mainPanel);
      container.add(button);
      
      frame = new JFrame("The Main Panel");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(container);
      frame.setLocation(860, 310);
      frame.pack();
      frame.setVisible(true);
      
    }
   public static boolean equalsColors(GamePixel[][] a, GamePixel[][] b){
      for (int i = 0; i < a.length; i++){
         for (int j = 0; j < a.length; j++){
            if (!a[i][j].equals(b[i][j])){
               return false;
            }
         }
      }
   return true;
   }
   
   public static GamePixel[][] copyArray(GamePixel[][] colors){
      GamePixel[][] temp = new GamePixel[colors.length][colors[0].length];
      GamePixel c;
      for(int i = 0; i < colors.length; i++){
         for(int j = 0; j < colors[0].length; j++){
            temp[i][j] = whatPixel(colors[i][j]);
         }
      }
      return temp;
   }
   
   public static GamePixel whatPixel(GamePixel c){
      if(c.getName().equals("Green")) return GamePixel.GREEN;
      if(c.getName().equals("Red")) return GamePixel.RED;
      if(c.getName().equals("Blue")) return GamePixel.BLUE;
      if(c.getName().equals("Yellow")) return GamePixel.YELLOW;
      if(c.getName().equals("Cyan")) return GamePixel.CYAN;
      if(c.getName().equals("Orange")) return GamePixel.ORANGE;
      else return GamePixel.ORANGE;
   }
   
   public static int getPScores(GamePixel[][] colors){
      int scores = 0;
      for (int i = 0; i< colors.length; i++){
         for (int j = 0; j< colors.length; j++){
            if (colors[i][j].getName().equals(GamePixel.ORANGE.getName())){
               scores++;
            }
         }
      }
      return scores;
   }
   
   public static void checkWin(){
      if (humanScore > 1250){
         Win.main(args);
         frame.dispose();
      }
      else if (aiScore > 1250){
         Lose.main(args);
         frame.dispose();
      }
   }
   
   public static int getAiScores(GamePixel[][] colors){
      int scores = 0;
      for (int i = 0; i< colors.length; i++){
         for (int j = 0; j< colors.length; j++){
            if (colors[i][j].getName().equals(GamePixel.CYAN.getName())){
               scores++;
            }
         }
      }
      return scores;
   }
   
   private static class redListener implements ActionListener
   {
      private String[] args;
      public void actionPerformed(ActionEvent e)
      {
      GamePixel[][] temp1 = copyArray(mainPanel.getColors());
      h.thinkMove(mainPanel.getColors(), GamePixel.RED);
      mainPanel.display();
      GamePixel[][] temp2 = copyArray(mainPanel.getColors());
      if (equalsColors(temp1, temp2) == false){
         comp.thinkMove(mainPanel.getColors());
         mainPanel.display();
         humanScore = getPScores(temp2);
         aiScore = getAiScores(temp2);
         ai.setText("Computer Score = " + aiScore);
         human.setText("Your Score = " + humanScore);
         checkWin();
      }
      }
   }
   private static class blueListener implements ActionListener
   {
      private String[] args;
      public void actionPerformed(ActionEvent e)
      {
      GamePixel[][] temp1 = copyArray(mainPanel.getColors());
      h.thinkMove(mainPanel.getColors(), GamePixel.BLUE);
      mainPanel.display();
      GamePixel[][] temp2 = copyArray(mainPanel.getColors());
      if (equalsColors(temp1, temp2) == false){
         comp.thinkMove(mainPanel.getColors());
         mainPanel.display();
         humanScore = getPScores(temp2);
         aiScore = getAiScores(temp2);
         ai.setText("Computer Score = " + aiScore);
         human.setText("Your Score = " + humanScore);
         checkWin();
      }
      }
   }   
   
      private static class greenListener implements ActionListener
   {
      private String[] args;
      public void actionPerformed(ActionEvent e)
      {
      GamePixel[][] temp1 = copyArray(mainPanel.getColors());
      h.thinkMove(mainPanel.getColors(), GamePixel.GREEN);
      mainPanel.display();
      GamePixel[][] temp2 = copyArray(mainPanel.getColors());
      if (equalsColors(temp1, temp2) == false){
         comp.thinkMove(mainPanel.getColors());
         mainPanel.display();
         humanScore = getPScores(temp2);
         aiScore = getAiScores(temp2);
         ai.setText("Computer Score = " + aiScore);
         human.setText("Your Score = " + humanScore);
         checkWin();
      }
      }
   }

   private static class yellowListener implements ActionListener
   {
      private String[] args;
      public void actionPerformed(ActionEvent e)
      {
      GamePixel[][] temp1 = copyArray(mainPanel.getColors());
      h.thinkMove(mainPanel.getColors(), GamePixel.YELLOW);
      mainPanel.display();
      GamePixel[][] temp2 = copyArray(mainPanel.getColors());
      if (equalsColors(temp1, temp2) == false){
         comp.thinkMove(mainPanel.getColors());
         mainPanel.display();
         humanScore = getPScores(temp2);
         aiScore = getAiScores(temp2);
         ai.setText("Computer Score = " + aiScore);
         human.setText("Your Score = " + humanScore);
         checkWin();
      }
      }
   }
   
   private static class quitListener implements ActionListener
   {
      private String[] args;
      public void actionPerformed(ActionEvent e)
      {
      frame.dispose();
      }
   }
   
   private static class resetListener implements ActionListener
   {
      private String[] args;
      public void actionPerformed(ActionEvent e)
      {
      frame.dispose();
      Startup.main(args);
      }
   }
}
