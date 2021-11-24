import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Problem5 {
  // determines if a string is naughty/nice; naughty is false, nice is true
  private static boolean naughtyNice(String str) {
    // always naughty cases
    if (str.contains("aa") || str.contains("cd") || str.contains("pq") || str.contains("xy")) {
      return false;
    }
    return true;
  }

  public static void main(String[] args) {
    ArrayList<String> str = new ArrayList<String>();

    try {
      File file = new File(args[0]);
      Scanner input = new Scanner(file);
      while (input.hasNextLine()) {
        str.add(input.nextLine());
      }
      input.close();
    } catch (FileNotFoundException ex) {
      System.out.println("File not found!");
    }

    try {
      if (Integer.parseInt(args[1]) == 1) {
        int result = 0;
        for (int i = 0; i < str.size(); i++) {
          if (naughtyNice(str.get(i))) result++;
        }
        System.out.println(result);
      }
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("Invalid syntax: use \"java Problem5 [filename] 1\"");
    }
  }
}
