import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Problem15 {
  //================================================================================
  // TESTER
  //================================================================================
  public static void main(String[] args) {
    Topping[] t = new Topping[4];

    // initialize all Toppings
    try {
      String line;
      int toppingNum = 0;
      String d02, d04, d06, d08, d10;
      File file = new File(args[0]);
      Scanner input = new Scanner(file);
      while (input.hasNextLine()) {
        line = input.nextLine();
        String[] data = line.split(" ");
        d02 = data[2].substring(0,data[2].length()-1); // gets rid of the ","
        d04 = data[4].substring(0,data[4].length()-1);
        d06 = data[6].substring(0,data[6].length()-1);
        d08 = data[8].substring(0,data[8].length()-1);
        d10 = data[10];
        t[toppingNum] = new Topping(Integer.parseInt(d02), Integer.parseInt(d04), Integer.parseInt(d06), Integer.parseInt(d08), Integer.parseInt(d10));
        toppingNum++;
      }
      input.close();
    } catch (FileNotFoundException ex) {
      System.out.println("File not found!");
    }

    try {
      String mode = args[1];

      int greatestTotal = 0; // 0 is the minimum total score
      int currentTotal;
      for (int sugar = 0; sugar <= 100; sugar++) {
        for (int sprinkles = 0; sprinkles <= 100-sugar; sprinkles++) {
          for (int candy = 0; candy <= 100-sugar-sprinkles; candy++) {
            int chocolate = 100-sugar-sprinkles-candy;
            currentTotal = total(t, sugar, sprinkles, candy, chocolate, mode);
            if (greatestTotal < currentTotal) greatestTotal = currentTotal;
          }
        }
      }
      System.out.println(greatestTotal);

    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("Invalid syntax: use \"java Problem15 [filename] [1/2]\".");
    }

  }

  //================================================================================
  // CALCULATE TOTAL
  //================================================================================
  private static int total(Topping[] t, int sugar, int sprinkles, int candy, int chocolate, String mode) {
    if (!mode.equals("1") && !mode.equals("2")) return 0;

    int capacity, durability, flavor, texture, calories;

    calories = t[0].getCalories() * sugar + t[1].getCalories() * sprinkles + t[2].getCalories() * candy + t[3].getCalories() * chocolate;
    if (mode.equals("2") && calories != 500) return 0;

    capacity = Math.max(0, t[0].getCapacity() * sugar + t[1].getCapacity() * sprinkles + t[2].getCapacity() * candy + t[3].getCapacity() * chocolate);
    durability = Math.max(0, t[0].getDurability() * sugar + t[1].getDurability() * sprinkles + t[2].getDurability() * candy + t[3].getDurability() * chocolate);
    flavor = Math.max(0, t[0].getFlavor() * sugar + t[1].getFlavor() * sprinkles + t[2].getFlavor() * candy + t[3].getFlavor() * chocolate);
    texture = Math.max(0, t[0].getTexture() * sugar + t[1].getTexture() * sprinkles + t[2].getTexture() * candy + t[3].getTexture() * chocolate);
    return capacity * durability * flavor * texture;
  }
}
