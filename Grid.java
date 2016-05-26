import javax.swing.*;
import java.awt.*;

//@ version 2:37 p.m.

@SuppressWarnings("serial")
public class Grid extends JPanel {

	private GamePixel[][] myColors;
	private JLabel[][] myLabels;
   private int rows, cols, cellWidth;
   private double clumpPercentage;

	public Grid(int r, int c, int width, double cP) {
		myColors = new GamePixel[r][c];
		myLabels = new JLabel[r][c];
      rows = r;
      cols = c;
      cellWidth = width;
      clumpPercentage = cP;
//		MyMouseListener myListener = new MyMouseListener(this);
		setLayout(new GridLayout(rows, cols));
	   clump();
      
	}

	public GamePixel[][] getColors() {
		return myColors;
	}

	public int randomizeCol(int col, int cols){
		double ran1 = Math.random();
		if ((ran1 < 0.5) && (col != cols)) {
			return col ++;
		} else if (ran1 < 1 && (col != 0)) {
			return col --;
		}else {
			return -1;
		}
	}

	public int randomizeRow(int row, int rows){
		double ran1 = Math.random();
		if ((ran1 < 0.5) && (row != rows)) {
			return row ++;
		} else if (ran1 < 1 && (row != 0)) {
			return row --;
		}else {
			return -1;
		}
	}

	public void labelPressed(JLabel label) {
		for (int row = 0; row < myLabels.length; row++) {
			for (int col = 0; col < myLabels[row].length; col++) {
				// do something
			}
		}
	}
   
   // edited 2:39 p.m. by 2019cbi
   public void display()
   {
      for(int row = 0; row < myColors.length; row++){
         for(int col = 0; col < myColors[0].length; col++){
            myLabels[row][col].setBackground(myColors[row][col].getColor());
         }
      }
   }
   
   // edited 2:44 p.m. by 2019cbi
   //@param GamePixel pix the pixel you want to do
   public void floodFill(GamePixel pix, int row, int col)
   {
      int r = row;
      int c = col;
      if(fill(pix, r, c))
      {
         if(row > 0){
            fill(pix, --row, col);
         } else if(row < myColors.length-1){
            fill(pix, ++row, col);
         } else if (col > 0){
            fill(pix, row, --col);
         } else if (col < myColors[0].length-1){
            fill(pix, row, ++col);
         }
      }
   }
   
   public boolean fill(GamePixel pix, int row, int col)
   {
      if(myColors[row][col].getColor().equals(pix.getColor()))
      {
         myColors[row][col].setColor(GamePixel.ORANGE);
         return true;
      }
      return false;
   }
   
   // edited 2:44 p.m. by 2019cbi
   public void clump()
   {
		JLabel myLabel = new JLabel();
		Dimension labelPrefSize = new Dimension(cellWidth, cellWidth);
     	int col = (int)(Math.random() * cols);
		int row = (int)(Math.random() * rows);
		GamePixel c = GamePixel.BLUE;
		double ran = Math.random();
		if (ran < 0.24) {
			c = GamePixel.RED;
		} else if (ran < 0.49) {
			c = GamePixel.BLUE;
		} else if (ran < 0.74) {
			c = GamePixel.GREEN;
		} else {
			c = GamePixel.YELLOW;
		}
		GamePixel firstColor = c;
		JLabel firstLabel = new JLabel();
		firstLabel = new JLabel();
		firstLabel.setOpaque(true);
		myColors[row][col] = firstColor;
		GamePixel previousColor = firstColor;
		firstLabel.setBackground(firstColor.getColor());
//		myLabel.addMouseListener(myListener);
		firstLabel.setPreferredSize(labelPrefSize);
		add(firstLabel);
		myLabels[row][col] = firstLabel;
		for (int x = 0; x < (rows)*(cols) - 1; x++) {
			double ran1 = Math.random();
			boolean bool = true;
			while(bool) {
				if (ran1 < 0.5) {
					col = randomizeCol(col,cols);
				} else {
					row = randomizeRow(row,rows);
				}
				if((col == -1) || (row == -1)) {
					bool = true;
				} else {
					bool = false;
				}
			}
			ran = Math.random();
			if (ran < (clumpPercentage)) {
				c = previousColor;
			} else if (ran < (((1 - clumpPercentage)/4) + clumpPercentage)) {
				c = GamePixel.BLUE;
			} else if (ran < ((((1 - clumpPercentage)/4)*2) + clumpPercentage)) {
				c = GamePixel.GREEN;
			} else if (ran < ((((1 - clumpPercentage)/4)*3) + clumpPercentage)){
				c = GamePixel.YELLOW;
			} else {
				c = GamePixel.RED;
			}
			
			previousColor = c;
			GamePixel myColor = c;
			myLabel = new JLabel();
			myLabel.setOpaque(true);
			myColors[row][col] = myColor;
			myLabel.setBackground(myColor.getColor());
//			myLabel.addMouseListener(myListener);
			myLabel.setPreferredSize(labelPrefSize);
			add(myLabel);
			myLabels[row][col] = myLabel;
		}
   }
}
