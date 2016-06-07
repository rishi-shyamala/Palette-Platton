/***
*This MediumPlayer class is an AI that will choose
*the best move at the step without thinking
*ahead.
*
*@author Chris
*@version 1.1.2
*@since 10:41 PM 6/5/16
***/

public class MediumPlayer extends Player{'
   /***
   *This will think of the move the AI plays.
   *@param colors stores the colors
   *the AI will use
   *@return GamePixel[][] returns the 
   *array of the updated Colors with the
   *AI's move made inside of it
   ***/
   public GamePixel[][] thinkMove(GamePixel[][] colors)
   {
      //flood search stuff
      int max = 0;
      int mRow = 0;
      int mCol = 0;
      boolean[][] mark2 = new boolean[colors.length][colors[0].length];
      for(int i = 0; i < colors.length; i++){
         for(int j = 0; j < colors[0].length; j++){
            boolean[][] mark = new boolean[colors.length][colors[0].length];
            if(isTouchingAIBlock(colors, i, j) && !colors[i][j].getName().equals(GamePixel.CYAN.getName()) && !colors[i][j].getName().equals(GamePixel.ORANGE.getName())){ //valid block?
               int num = floodSearch(colors, mark, i, j, colors[i][j], 0);
               // System.out.println(i + "  " + j + "  " + max + "  " + num);
               if(num > max){
                  // System.out.println(max + "\tchanged to\t" + num);
                  max = num;
                  mRow = i;
                  mCol = j;
               }
            }
         }
      }
      //printColors(colors);
      // System.out.println(max + "   row and column   " + mRow + " " + mCol);Fprint
      floodFill(colors, mark2, mRow, mCol, colors[mRow][mCol]);
      //printColors(colors);
      return colors;
   }
}
