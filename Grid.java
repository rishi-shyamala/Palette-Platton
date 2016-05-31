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
   //edited 9:55 5/29/16 by 2019cbi
   public void setColors(GamePixel[][] colors) {
		myColors = colors;
	}
   
	public GamePixel[][] getColors() {
		return myColors;
	}
   
   public void printColors()
   {
      for(GamePixel[] arr: myColors){
         for(GamePixel p: arr){
            System.out.print(p);
         }  
         //System.out.println();
      }
      System.out.println();
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
            //add(myLabels[row][col]);
         }
         
      }
   }
   
// // // // // // // // // // //    // edited 2:44 p.m. by 2019cbi
// // // // // // // // // // //    //@param GamePixel pix the pixel you want to do
// // // // // // // // // // //    public void floodFill(GamePixel pix, int row, int col) ///////////UNOFFICIAL floodfill
// // // // // // // // // // //    {
// // // // // // // // // // //       int r = row;
// // // // // // // // // // //       int c = col;
// // // // // // // // // // //       if(fill(pix, r, c))
// // // // // // // // // // //       {
// // // // // // // // // // //          if(row > 0){
// // // // // // // // // // //             fill(pix, --row, col);
// // // // // // // // // // //          } else if(row < myColors.length-1){
// // // // // // // // // // //             fill(pix, ++row, col);
// // // // // // // // // // //          } else if (col > 0){
// // // // // // // // // // //             fill(pix, row, --col);
// // // // // // // // // // //          } else if (col < myColors[0].length-1){
// // // // // // // // // // //             fill(pix, row, ++col);
// // // // // // // // // // //          }
// // // // // // // // // // //       }
// // // // // // // // // // //    }
// // // // // // // // // // //    
// // // // // // // // // // //    public boolean fill(GamePixel pix, int row, int col)
// // // // // // // // // // //    {
// // // // // // // // // // //       if(myColors[row][col].getColor().equals(pix.getColor()))
// // // // // // // // // // //       {
// // // // // // // // // // //          myColors[row][col].setColor(GamePixel.ORANGE);
// // // // // // // // // // //          return true;
// // // // // // // // // // //       }
// // // // // // // // // // //       return false;
// // // // // // // // // // //    }
// // // // // // // // // // //    

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
		//add(firstLabel);
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
   //			myLabel.addMouseListener(myListener);
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
                             
        //System.out.println("Made it past 0!");                     //test
        
        //System.out.println(row + "\t" + col);
        
        // System.out.print(time + ".\t");
//         printColors(); //prints row
        
        // make sure in bounds
        if (row < 0) return;
        if (col < 0) return;
        if (row >= myColors.length) return;
        if (col >= myColors[0].length) return;
        
        //System.out.println("Made it past 1!");   
        
        // new Pixel?

        if (mark[row][col]) return;
        
        //System.out.println("Made it past 2!");  
        
        // make sure this pixel is the right color to fill
        if (!myColors[row][col].getColor().equals(originalPixel.getColor())) return; 
               
        //System.out.println("Made it past 3!");  
        
        // fill pixel with target color and mark it as visited
        myColors[row][col] = GamePixel.ORANGE;
        mark[row][col] = true;
        
        //System.out.println("Made it past 4! and set the color");  
        
        //test 
        
        // recursive (depth-first search)
        floodFill(mark, row - 1, col, originalPixel);
        floodFill(mark, row + 1, col, originalPixel);
        floodFill(mark, row, col - 1, originalPixel);
        floodFill(mark, row, col + 1, originalPixel);
        
        //System.out.println("Made it past 5! Finished!"); 
    } 

}
