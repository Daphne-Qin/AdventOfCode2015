import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem01 {
  public static int findFloor(String dir) {
    int floor = 0;
    for (int i = 0; i < dir.length(); i++) {
      if (dir.charAt(i) == '(') {
        floor++;
      } else {
        floor--;
      }
    }
    return floor;
  }

  public static int findBasement(String dir) {
    int floor = 0;
    for (int i = 0; i < dir.length(); i++) {
      if (dir.charAt(i) == '(') {
        floor++;
      } else {
        floor--;
        if (floor < 0) {
          return i+1;
        }
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    String dir = "";

    try {
      File file = new File(args[0]);
      Scanner input = new Scanner(file);
      dir = input.nextLine();
      input.close();
    } catch (FileNotFoundException ex) {
      System.out.println("File not found!");
    }

    try {
      if (args[1].equals("1")) System.out.println(findFloor(dir));
      if (args[1].equals("2")) System.out.println(findBasement(dir));
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("Invalid syntax: use \"java Problem01 [filename] [1/2]\".");
    }
  }
}
