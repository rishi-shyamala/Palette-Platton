import java.awt.Color;

public enum GamePixel{
   GREEN(Color.green, "Green", "g"), RED(Color.red, "Red", "r"), 
   BLUE(Color.blue, "Blue", "b"), YELLOW(Color.yellow, "Yellow", "y"),
   CYAN(Color.cyan, "Cyan", "c"), ORANGE(Color.orange, "Orange", "o");
   private Color color;
   private String name;
   private String shortName;

   private GamePixel(Color color, String name, String shortName) {
      this.color = color;
      this.name = name;
      this.shortName = shortName;
   }

   public Color getColor() {
      return color;
   }

   public String getName() {
      return name;
   }

   public String getShortName() {
      return shortName;
   }

   @Override
   public String toString() {
      return shortName;
   }

}