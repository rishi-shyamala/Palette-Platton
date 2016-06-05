/***
*This Player interface contains the main methods for our AI's
*
*@author Chris
*@version 1.1.2
*@since 3:29 PM 6/5/16
***/

public abstract class Player{
   /***
   *This will think of the move the AI plays.
   *@param colors stores the colors
   *the AI will use
   *@return GamePixel[][] returns the 
   *array of the updated Colors with the
   *AI's move made inside of it
   ***/
   public abstract GamePixel[][] thinkMove(GamePixel[][] colors);

   /***
   *This will count the number of blocks that are 
   *the same color and touching the chosen block.
   *This is similar to floodFill()
   *@param colors stores the colors
   *the AI will use
   *@param mark stores the boolean array
   *of the squares visited
   *@param row the current row of the array
   *@param col the current column of the array
   *@param originalPixel used to compare colors
   *@param num the current count
   *@return int the current count of number of blocks
   ***/
   public int floodSearch(GamePixel[][] colors, boolean[][] mark,
                             int row, int col, GamePixel originalPixel, int num) {
        
        // make sure in bounds
        if (row < 0) return 0;
        if (col < 0) return 0;
        if (row >= colors.length) return 0;
        if (col >= colors[0].length) return 0;
        
        // new Pixel?

        if (mark[row][col]) return 0;
    
        // make sure this pixel is the right color to fill
        if (!colors[row][col].getColor().equals(originalPixel.getColor())) return 0; 

        //mark it as visited
        mark[row][col] = true;
        
        // recursive (depth-first search)
        int a = floodSearch(colors, mark, row - 1, col, originalPixel, (num+1));
        int b = floodSearch(colors, mark, row + 1, col, originalPixel, (num+1));
        int c = floodSearch(colors, mark, row, col - 1, originalPixel, (num+1));
        int d = floodSearch(colors, mark, row, col + 1, originalPixel, (num+1));
        int e = 1;
        return(a+b+c+d+e);
    }
   
   /***
   *This will fill the blocks that are 
   *the same color and touching the chosen block.
   *This is similar to floodSearch()
   *@param colors stores the colors
   *the AI will use
   *@param mark stores the boolean array
   *of the squares visited
   *@param row the current row of the array
   *@param col the current column of the array
   *@param originalPixel used to compare colors
   ***/
   public void floodFill(GamePixel[][] colors, boolean[][] mark,
                             int row, int col, GamePixel originalPixel) {
        
        // make sure in bounds
        if (row < 0) return;
        if (col < 0) return;
        if (row >= colors.length) return;
        if (col >= colors[0].length) return;

        // new Pixel?
        if (mark[row][col]) return;

        // make sure this pixel is the right color to fill
        if (!colors[row][col].getColor().equals(originalPixel.getColor())) return; 
  
        // fill pixel with target color and mark it as visited
        colors[row][col] = GamePixel.CYAN;
        mark[row][col] = true;
   
        // recursive (depth-first search)
        floodFill(colors, mark, row - 1, col, originalPixel);
        floodFill(colors, mark, row + 1, col, originalPixel);
        floodFill(colors, mark, row, col - 1, originalPixel);
        floodFill(colors, mark, row, col + 1, originalPixel);       
    }
    
   /***
   *This will printColors, mainly used for testing purposes.
   *@param colors stores the colors
   *the AI will use
   ***/
   public void printColors(GamePixel[][] colors)
   {
      for(GamePixel[] arr: colors){
         for(GamePixel p: arr){
            System.out.print(p);
         }  
         System.out.println();
      }
      System.out.println();
   }
   
   /***
   *This will check if the block
   *in the loop is touching 
   *one of an AI block. If yes, it
   *is an eligible block for the AI
   *to choose.
   *@param colors stores the colors
   *the AI will use
   *@param row the current row of the array
   *@param col the current column of the array
   *@return boolean is touching or not touching
   ***/
   public boolean isTouchingAIBlock(GamePixel[][] colors, int row, int col){
      GamePixel oC = GamePixel.CYAN;
      if((row > 0) && colors[row-1][col].getColor().equals(oC.getColor()))  return true;
      if((row < colors.length-1) && colors[row+1][col].getColor().equals(oC.getColor()))  return true;
      if((col > 0) && colors[row][col-1].getColor().equals(oC.getColor()))  return true;
      if((col < colors[0].length-1) && colors[row][col+1].getColor().equals(oC.getColor()))  return true;
      return false;
         
   } 
}  
