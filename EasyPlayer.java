//@author 2019cbi
//@Version 1.0

public class EasyPlayer extends Player{
   public GamePixel[][] thinkMove(GamePixel[][] colors)
   {
      //flood search stuff
      boolean[][] mark2 = new boolean[colors.length][colors[0].length];
      int max = 0;
      int mRow = 0;
      int mCol = 0;
      int max2 = 0;
      int mRow2 = colors.length-1;
      int mCol2 = colors[0].length-2;
      for(int i = 0; i < colors.length; i++){ // find highest
         for(int j = 0; j < colors[0].length; j++){
            boolean[][] mark = new boolean[colors.length][colors[0].length];
            if(isTouchingAIBlock(colors, i, j) && !colors[i][j].getName().equals(GamePixel.CYAN.getName()) && !colors[i][j].getName().equals(GamePixel.ORANGE.getName())){ //valid block?
               int num = floodSearch(colors, mark, i, j, colors[i][j], 0);
               if(num > max){
                  max = num;
                  mRow = i;
                  mCol = j;
               }
            }
         }
      }
      for(int i = 0; i < colors.length; i++){ //find second highest
         for(int j = 0; j < colors[0].length; j++){
            boolean[][] mark = new boolean[colors.length][colors[0].length];
            if(isTouchingAIBlock(colors, i, j) && !colors[i][j].getName().equals(GamePixel.CYAN.getName()) && !colors[i][j].getName().equals(GamePixel.ORANGE.getName())/** && !colors[i][j].getName().equals(GamePixel.ORANGE.getName())**/){ //valid block?
               int num = floodSearch(colors, mark, i, j, colors[i][j], 0);
               if((num > max2) && (num < max)){
                  max2 = num;
                  mRow2 = i;
                  mCol2 = j;
               }
            }
         }
      }

      floodFill(colors, mark2, mRow2, mCol2, colors[mRow2][mCol2]);

      return colors;
   }
   
   public GamePixel[][] returnMove()
   {
      GamePixel[][] a = new GamePixel[1][1]; //filler
      return a;
   }
   
//    public boolean isTouchingAIBlock(GamePixel[][] colors, int row, int col){
//       GamePixel oC = GamePixel.CYAN;
//       if((row > 0) && colors[row-1][col].getColor().equals(oC.getColor()))  return true;
//       if((row < colors.length-1) && colors[row+1][col].getColor().equals(oC.getColor()))  return true;
//       if((col > 0) && colors[row][col-1].getColor().equals(oC.getColor()))  return true;
//       if((col < colors[0].length-1) && colors[row][col+1].getColor().equals(oC.getColor()))  return true;
//       return false;
//          
//    } 
}