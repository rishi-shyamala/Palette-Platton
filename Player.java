// @ author Christopher Bi
// @Version version1

public abstract class Player{
   public abstract GamePixel[][] thinkMove(GamePixel[][] colors);
   public abstract GamePixel[][] returnMove();
   
   public int findNumBlocks(GamePixel[][] colors, int row, int col, GamePixel original){//uses block touching players blocks
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
   
   public int floodSearch(GamePixel[][] colors, boolean[][] mark,
                             int row, int col, GamePixel originalPixel, int num) { /////// OFFICIAL flood fill
        
        // make sure in bounds
        if (row < 0) return 0;
        if (col < 0) return 0;
        if (row >= colors.length) return 0;
        if (col >= colors[0].length) return 0;
        
        //System.out.println("Made it past 1!");   
        
        // new Pixel?

        if (mark[row][col]) return 0;
        
        //System.out.println("Made it past 2!"); 
        
        // make sure this pixel is the right color to fill
        if (!colors[row][col].getColor().equals(originalPixel.getColor())) return 0; 
               
        //System.out.println("Made it past 3!");  
        
        //mark it as visited
        mark[row][col] = true;
        
        //System.out.println("Made it past 4! and set the color");  
        
        //test 
        
        // recursive (depth-first search)
        int a = floodSearch(colors, mark, row - 1, col, originalPixel, (num+1));
        int b = floodSearch(colors, mark, row + 1, col, originalPixel, (num+1));
        int c = floodSearch(colors, mark, row, col - 1, originalPixel, (num+1));
        int d = floodSearch(colors, mark, row, col + 1, originalPixel, (num+1));
        
        int e = 1;
        return(a+b+c+d+e);
        //System.out.println("Made it past 5! Finished!"); 
    }
    
   public void floodFill(GamePixel[][] colors, boolean[][] mark,
                             int row, int col, GamePixel originalPixel) { /////// OFFICIAL flood fill
                             
        //System.out.println("Made it past 0!");                     //test
        
        //System.out.println(row + "\t" + col);
        
        // System.out.print(time + ".\t");
//         printColors(); //prints row
        
        // make sure in bounds
        if (row < 0) return;
        if (col < 0) return;
        if (row >= colors.length) return;
        if (col >= colors[0].length) return;
        
        //System.out.println("Made it past 1!");   
        
        // new Pixel?

        if (mark[row][col]) return;
        
        //System.out.println("Made it past 2!");  
        
        // make sure this pixel is the right color to fill
        if (!colors[row][col].getColor().equals(originalPixel.getColor())) return; 
               
        //System.out.println("Made it past 3!");  
        
        // fill pixel with target color and mark it as visited
        colors[row][col] = GamePixel.CYAN;
        mark[row][col] = true;
        
        //System.out.println("Made it past 4! and set the color");  
        
        //test 
        
        // recursive (depth-first search)
        floodFill(colors, mark, row - 1, col, originalPixel);
        floodFill(colors, mark, row + 1, col, originalPixel);
        floodFill(colors, mark, row, col - 1, originalPixel);
        floodFill(colors, mark, row, col + 1, originalPixel);
        
        //System.out.println("Made it past 5! Finished!"); 
    }
    
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
   
   public boolean isTouchingAIBlock(GamePixel[][] colors, int row, int col){
      GamePixel oC = GamePixel.CYAN;
      if((row > 0) && colors[row-1][col].getColor().equals(oC.getColor()))  return true;
      if((row < colors.length-1) && colors[row+1][col].getColor().equals(oC.getColor()))  return true;
      if((col > 0) && colors[row][col-1].getColor().equals(oC.getColor()))  return true;
      if((col < colors[0].length-1) && colors[row][col+1].getColor().equals(oC.getColor()))  return true;
      return false;
         
   } 
}  
