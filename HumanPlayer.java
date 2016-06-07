//@author 2019cbi
//@Version 1.0

public class HumanPlayer{
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
//               if (playerAction = 1){
//                   floodFill(colors, mark, i, j, colors[i][j]) 
//               }
//               if (playerAction = 2){
//                   floodFill(colors, mark, i, j, colors[i][j]) 
//               }
//               
//               if (playerAction = 3){
//                   floodFill(colors, mark, i, j, colors[i][j]) 
//               }
//               
//               if (playerAction = 4){
                  floodFill(colors, mark, i, j, colors[i][j]); 
//               }
              
              }
            }
         }
      return colors;
      }
      
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
//       floodFill(colors, mark2, mRow, mCol, colors[mRow][mCol]);
//       //printColors(colors);
//       return colors;
   
//    public GamePixel[][] returnMove()
//    {
//       GamePixel[][] a = new GamePixel[1][1]; //filler
//       return a;
//    }
//    
    public boolean isTouchingBlock(GamePixel[][] colors, int row, int col){
       GamePixel oC = GamePixel.ORANGE;
       if((row > 0) && colors[row-1][col].getName().equals(oC.getName()))  return true;
       if((row < colors.length-1) && colors[row+1][col].getName().equals(oC.getName()))  return true;
       if((col > 0) && colors[row][col-1].getName().equals(oC.getName()))  return true;
       if((col < colors[0].length-1) && colors[row][col+1].getName().equals(oC.getName()))  return true;
       return false;
          
    } 
}
