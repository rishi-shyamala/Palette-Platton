import javax.swing.*;
import java.awt.*;

/***
*This Grid class creates a GamePixel[][] array to store the colors of the game.
*@author Suresh
*@version 1.1.2
*@since 10:48 PM 6/5/16
***/

@SuppressWarnings("serial")
public class Grid extends JPanel {

   /**
   *This is the GamePixel[][] array used to store the colors.
   **/
   private GamePixel[][] myColors;
   /**
   *This is the JLabel[][] array used to show the colors.
   **/
   private JLabel[][] myLabels;
   /**
   *These are the constants for the Grid size and labels's size.
   **/
   private int rows, cols, cellWidth;
   /**
   *This the constant for how clumped the Grid should be.
   **/
   private double clumpPercentage;
   
   /***
   *This is the constructor for Grid.java.
   *@param r the number of rows.
   *@param c the number of columns.
   *@param width the width of labels.
   *@param cP the clump percentage.
   ***/
   public Grid(int r, int c, int width, double cP) {
	myColors = new GamePixel[r][c];
	myLabels = new JLabel[r][c];
	rows = r;
	cols = c;
	cellWidth = width;
	clumpPercentage = cP;
	setLayout(new GridLayout(rows, cols));
	clump();
	}
   /***
   *This is the mutator method for the GamePixel[][] myColors.
   *@param colors the GamePixel[][] of colors.
   ***/
   public void setColors(GamePixel[][] colors) {
	myColors = colors;
   }
   
   /***
   *This is the accessor method for the GamePixel[][] myColors.
   *@return colors the GamePixel[][] of colors.
   ***/
   public GamePixel[][] getColors() {
	return myColors;
   }
   
   /***
   *This prints out the GamePixel[][] colors.
   *It is used mainly for testing purposes.
   ***/
   public void printColors()
   {
      for(GamePixel[] arr: myColors){
         for(GamePixel p: arr){
            System.out.print(p);
         }  
      }
      System.out.println();
   }
	
   /***
   *This is one of two helper methods for clump().
   *@param col the current column
   *@param cols the number of columns
   ***/
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
   /***
   *This is one of two helper methods for clump().
   *@param row the current row
   *@param rows the number of rows
   ***/
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
   
   /***
   *This displays the GamePixel[][] myColors.
   ***/
   public void display()
   {
      for(int row = 0; row < myColors.length; row++){
         for(int col = 0; col < myColors[0].length; col++){
            myLabels[row][col].setBackground(myColors[row][col].getColor());
         }
         
      }
   }
   
   /***
   *This sets up the beginning array, and randomizes everything for myColors.
   ***/
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
		firstLabel.setPreferredSize(labelPrefSize);
		myLabels[row][col] = firstLabel;
		for (int x = 0; x < rows; x++) {
         for(int y = 0; y < cols; y++){
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
   			myColors[x][y] = myColor;
   			myLabel.setBackground(myColor.getColor());
   			myLabel.setPreferredSize(labelPrefSize);
   			add(myLabel);
   			myLabels[x][y] = myLabel;
         }
		}
      
      //for the first block of player and AI's
      myColors[0][0] = GamePixel.ORANGE;
      myColors[myColors.length-1][myColors[0].length-1] = GamePixel.CYAN;
      display();
   }
   
   public void floodFill(boolean[][] mark,
                             int row, int col, GamePixel originalPixel) { /////// OFFICIAL flood fill
                             
        // make sure in bounds
        if (row < 0) return;
        if (col < 0) return;
        if (row >= myColors.length) return;
        if (col >= myColors[0].length) return;
        
        // new Pixel?

        if (mark[row][col]) return;
        
        // make sure this pixel is the right color to fill
        if (!myColors[row][col].getColor().equals(originalPixel.getColor())) return; 

        // fill pixel with target color and mark it as visited
        myColors[row][col] = GamePixel.ORANGE;
        mark[row][col] = true;

        // recursive (depth-first search)
        floodFill(mark, row - 1, col, originalPixel);
        floodFill(mark, row + 1, col, originalPixel);
        floodFill(mark, row, col - 1, originalPixel);
        floodFill(mark, row, col + 1, originalPixel);
    } 

}
