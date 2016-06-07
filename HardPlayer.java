//@author 2019cbi
//@Version 1.0

public class HardPlayer extends Player{
   public GamePixel[][] thinkMove(GamePixel[][] colors)
   {
      //flood search stuff
      int max = 0;
      int mRow = colors.length-1;
      int mCol = colors[0].length-2;
      boolean[][] mark = new boolean[colors.length][colors[0].length];
      for(int i = 0; i < colors.length; i++){
         for(int j = 0; j < colors[0].length; j++){
            
            GamePixel[][] temp = copyArray(colors);
            
            boolean[][] mark2 = new boolean[colors.length][colors[0].length];
            boolean[][] mark3 = new boolean[colors.length][colors[0].length];
            if(isTouchingAIBlock(colors, i, j) && !colors[i][j].getName().equals(GamePixel.CYAN.getName()) && !colors[i][j].getName().equals(GamePixel.ORANGE.getName())){
               int num = floodSearch(temp, mark3, i, j, colors[i][j], 0);
               floodFill(temp, mark2, i, j, colors[i][j]);
               
               int[] numbers = findMax(temp);
               int currM = numbers[0];
                              
               if((currM+num) > max){
                  max = (currM+num);
                  mRow = i;
                  mCol = j;
               }
            }
         }
      }
      floodFill(colors, mark, mRow, mCol, colors[mRow][mCol]);
      return colors;
   }
      
   public GamePixel[][] copyArray(GamePixel[][] colors){
      GamePixel[][] temp = new GamePixel[colors.length][colors[0].length];
      GamePixel c;
      for(int i = 0; i < colors.length; i++){
         for(int j = 0; j < colors[0].length; j++){
            temp[i][j] = whatPixel(colors[i][j]);
         }
      }
      return temp;
   }
   
   public GamePixel whatPixel(GamePixel c){
      if(c.getName().equals("Green")) return GamePixel.GREEN;
      if(c.getName().equals("Red")) return GamePixel.RED;
      if(c.getName().equals("Blue")) return GamePixel.BLUE;
      if(c.getName().equals("Yellow")) return GamePixel.YELLOW;
      if(c.getName().equals("Cyan")) return GamePixel.CYAN;
      if(c.getName().equals("Orange")) return GamePixel.ORANGE;
      else return GamePixel.ORANGE;
   }
   
   public int[] findMax(GamePixel[][] colors){   
      int[] rac = new int[3];  
      int max = 0;
      int mRow = 0;
      int mCol = 0;
      for(int i = 0; i < colors.length; i++){
         for(int j = 0; j < colors[0].length; j++){
            boolean[][] mark = new boolean[colors.length][colors[0].length];
            if(isTouchingAIBlock(colors, i, j) && !colors[i][j].getName().equals(GamePixel.CYAN.getName())){ //valid block?
               int num = floodSearch(colors, mark, i, j, colors[i][j], 0);
               if(num > max){
                  max = num;
                  mRow = i;
                  mCol = j;
               }
            }
         }
      }
      
      rac[0] = max;
      rac[1] = mRow;
      rac[2] = mCol;
      return rac;
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
