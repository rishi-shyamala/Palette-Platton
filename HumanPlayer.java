/***
*This HumanPlayer class is a class that
* processes the move made by the
*player.
*@author Suresh, Chris, Rishi
*@version 1.1.2
*@since 12:05 PM 6/5/16
***/

public class HumanPlayer{
   /***
   *This will think of the move the AI plays.
   *@param colors stores the colors
   *the AI will use
   *@param p the GamePixel of the color
   *of the button the player picks
   *@return GamePixel[][] returns the 
   *array of the updated Colors with the
   *AI's move made inside of it
   ***/
   public GamePixel[][] thinkMove(GamePixel[][] colors, GamePixel p)
   {
      //flood search stuff
      int max = 0;
      int mRow = 0;
      int mCol = 0;
      boolean[][] mark2 = new boolean[colors.length][colors[0].length];
      for(int i = 0; i < colors.length; i++){
         for(int j = 0; j < colors[0].length; j++){
            boolean[][] mark = new boolean[colors.length][colors[0].length];
            if(isTouchingBlock(colors, i, j) && !colors[i][j].getName().equals(GamePixel.ORANGE.getName()) && colors[i][j].getName().equals(p.getName())){ //valid block?
                  floodFill(colors, mark, i, j, colors[i][j]);
              }
            }
         }
      return colors;
    }
   
   /***
   *This is the driver floodFill() algorithm.
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
        for(int i = 0; i < colors.length; i++){
         for(int j = 0; j < colors[0].length; j++){
            boolean[][] mark3 = new boolean[colors.length][colors[0].length];
            if(isTouchingBlock(colors, i, j) && colors[i][j].getName().equals(originalPixel.getName())){
               floodFillReal(colors, mark3, i, j, originalPixel);
            }
         }
        }
    }
    
   /***
   *This will fill the blocks that are 
   *the same color and touching the chosen block.
   *This is the helper method for floodFill().
   *@param colors stores the colors
   *the AI will use
   *@param mark stores the boolean array
   *of the squares visited
   *@param row the current row of the array
   *@param col the current column of the array
   *@param originalPixel used to compare colors
   ***/
   public void floodFillReal(GamePixel[][] colors, boolean[][] mark,
                             int row, int col, GamePixel originalPixel) {
        
        // make sure in bounds
        if (row < 0) return;
        if (col < 0) return;
        if (row >= colors.length) return;
        if (col >= colors[0].length) return;

        // new Pixel?
        if (mark[row][col]) return;

        // make sure this pixel is the right color to fill
        if (!colors[row][col].getName().equals(originalPixel.getName())) return; 
  
        // fill pixel with target color and mark it as visited
        colors[row][col] = GamePixel.ORANGE;
        
        mark[row][col] = true;
   
        // recursive (depth-first search)
        floodFillReal(colors, mark, row - 1, col, originalPixel);
        floodFillReal(colors, mark, row + 1, col, originalPixel);
        floodFillReal(colors, mark, row, col - 1, originalPixel);
        floodFillReal(colors, mark, row, col + 1, originalPixel);       
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
    public boolean isTouchingBlock(GamePixel[][] colors, int row, int col){
       GamePixel oC = GamePixel.ORANGE;
       if((row > 0) && colors[row-1][col].getName().equals(oC.getName()))  return true;
       if((row < colors.length-1) && colors[row+1][col].getName().equals(oC.getName()))  return true;
       if((col > 0) && colors[row][col-1].getName().equals(oC.getName()))  return true;
       if((col < colors[0].length-1) && colors[row][col+1].getName().equals(oC.getName()))  return true;
       return false;
          
    } 
}
