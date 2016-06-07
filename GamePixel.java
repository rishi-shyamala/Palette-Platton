import java.awt.Color;

/**
*Theses are the specific squares in the grid
*/
public enum GamePixel{
   GREEN(Color.green, "Green", "g"), RED(Color.red, "Red", "r"), 
   BLUE(Color.blue, "Blue", "b"), YELLOW(Color.yellow, "Yellow", "y"),
   CYAN(Color.cyan, "Cyan", "c"), ORANGE(Color.orange, "Orange", "o");
   private Color color;
   private String name;
   private String shortName;

   /**
   *This is a constructor that sets the Color, Name, and Short Name of the Game Pixel 
   */
   private GamePixel(Color color, String name, String shortName) {
      this.color = color;
      this.name = name;
      this.shortName = shortName;
   }

   /**
   *This returns the Color of the Game Pixel
   */
   public Color getColor() {
      return color;
   }

   /**
   *This returns the Name of the Game Pixel
   */
   public String getName() {
      return name;
   }
   
   /**
   *This returns the Short Name of the Game Pixel, The Short Name is the first letter of the Name of the Game Pixel
   */
   public String getShortName() {
      return shortName;
   }
   
   /**
   *This returns the Short Name of the Game Pixel to a String
   */
   @Override
   public String toString() {
      return shortName;
   }
   
   /**
   *This sets the color of the GamePixel
   *@param wantColor the color you wish
   *to set the GamePixel to.
   */
   public void setColor(GamePixel wantColor)
   {
      color = wantColor.getColor();
      name = wantColor.getName();
      shortName = wantColor.getShortName();
   }

}
