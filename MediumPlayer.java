//@author 2019cbi
//@Version 1.0

public class MediumPlayer extends Player{
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
            if(isTouchingAIBlock(colors, i, j) && !colors[i][j].getColor().equals(GamePixel.CYAN.getColor())){ //valid block?
               int num = floodSearch(colors, mark, i, j, colors[i][j], 0);
               System.out.println(i + "  " + j + "  " + max + "  " + num);
               if(num > max){
                  System.out.println(max + "\tchanged to\t" + num);
                  max = num;
                  mRow = i;
                  mCol = j;
               }
            }
         }
      }
      //printColors(colors);
      System.out.println(max + "   row and column   " + mRow + " " + mCol);
      floodFill(colors, mark2, mRow, mCol, colors[mRow][mCol]);
      //printColors(colors);
      return colors;
   }
   
   public GamePixel[][] returnMove()
   {
      GamePixel[][] a = new GamePixel[1][1]; //filler
      return a;
   }
   
   public boolean isTouchingAIBlock(GamePixel[][] colors, int row, int col){
      GamePixel oC = GamePixel.CYAN;
      if((row > 0) && colors[row-1][col].getColor().equals(oC.getColor()))  return true;
      if((row < colors.length-1) && colors[row+1][col].getColor().equals(oC.getColor()))  return true;
      if((col > 0) && colors[row][col-1].getColor().equals(oC.getColor()))  return true;
      if((col < colors[0].length-1) && colors[row][col+1].getColor().equals(oC.getColor()))  return true;
      return false;
         
   } 
}
