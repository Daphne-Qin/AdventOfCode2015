import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Problem02 {
  // calculates surface area of a cuboid
  private static int surfaceArea(int l, int w, int h) {
    int smallest = Math.min(l*w, w*h);
    smallest = Math.min(smallest, h*l);
    return (2*l*w + 2*w*h + 2*h*l + smallest);
  }

  // calculates perimeter of smallest side plus volume for a cuboid
  private static int ribbonNeeded(int l, int w, int h) {
    int smallest = Math.min(l+w, w+h);
    smallest = Math.min(smallest, h+l);
    return (2*smallest + l*w*h);
  }

  // part 1
  private static int wrappingPaper(ArrayList<Integer> nums) {
    int result = 0;
    for (int i = 0; i < nums.size(); i += 3) {
      result += surfaceArea(nums.get(i), nums.get(i+1), nums.get(i+2));
    }
    return result;
  }

  // part 2
  private static int ribbon(ArrayList<Integer> nums) {
    int result = 0;
    for (int i = 0; i < nums.size(); i += 3) {
      result += ribbonNeeded(nums.get(i), nums.get(i+1), nums.get(i+2));
    }
    return result;
  }

  public static void main(String[] args) {
    String line;
    ArrayList<Integer> nums = new ArrayList<Integer>();

    try {
      File file = new File(args[0]);
      Scanner input = new Scanner(file);
      while (input.hasNextLine()) {
        line = input.nextLine();
        String[] numLines = line.split("x");
        for (int i = 0; i < 3; i++) {
          nums.add(Integer.parseInt(numLines[i]));
        }
      }
      input.close();//releases the file from your program
    } catch (FileNotFoundException ex) {
      System.out.println("File not found!");
    }

    try {
      if (args[1].equals("1")) System.out.println(wrappingPaper(nums));
      if (args[1].equals("2")) System.out.println(ribbon(nums));
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("Invalid syntax: use \"java Problem02 [filename] [1/2]\".");
    }
  }
}
