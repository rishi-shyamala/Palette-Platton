// @ author Christopher Bi
// @Version version1

public abstract class Player{
   public abstract int[] thinkMove();
   public abstract int[] returnMove();
   
   public int findNumBlocks(GamePixel[][] colors, int row, int col, GamePixel original){
      boolean sameColor = colors[row][col].getColor().equals(original.getColor());
      int total = 0;
      
      for(int i = 0; i < colors.length; i++){
         for(int j = 0; j < colors[0].length; j++){
            if(isTouching(i, j, row, col) && sameColor){
               total+=1;
            }        
         }
      } 
     return total;
   }
   
   public boolean isTouching(int newR, int newC, int oRow, int oCol){
      double distance = Math.sqrt(Math.pow((newR-oRow), 2) + Math.pow((newC-oCol), 2));
      if(distance < 2.0)
         return true;
      else
         return false;
   }
}  
