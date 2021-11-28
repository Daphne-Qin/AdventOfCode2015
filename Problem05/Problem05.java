import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Problem05 {
  //================================================================================
  // PART 1
  //================================================================================
  // under part 1 rules, determines if a string is naughty/nice; naughty is false, nice is true
  private static boolean naughtyNice1(String str) {
    String[] doubleLetters = {"qq", "ww", "ee", "rr", "tt", "yy", "uu", "ii", "oo", "pp", "aa", "ss", "dd", "ff", "gg", "hh", "jj", "kk", "ll", "zz", "xx", "cc", "vv", "bb", "nn", "mm"};
    char[] vowels = {'a', 'e', 'i', 'o', 'u'};
    int numDoubleLetters = 0;
    int numVowels = 0;

    // always naughty cases
    if (str.contains("ab") || str.contains("cd") || str.contains("pq") || str.contains("xy")) {
      return false;
    }

    // check for leters appearing twice in a row
    for (int i = 0; i < doubleLetters.length; i++) {
      if (str.contains(doubleLetters[i])) numDoubleLetters++;
    }
    if (numDoubleLetters == 0) return false;

    // check for at least three vowels
    for (int i = 0; i < str.length(); i++) {
      for (int j = 0; j < vowels.length; j++) {
        if (str.charAt(i) == vowels[j]) numVowels++;
      }
    }
    if (numVowels < 3) return false;

    // at this point the string has passed all checks
    return true;
  }

  //================================================================================
  // PART 2
  //================================================================================
  // under part 2 rules, determines if a string is naughty/nice; naughty is false, nice is true
  private static boolean naughtyNice2(String str) {
    return (findPair(str) && findSandwich(str));
  }
  // find pair of letters without overlaps
  private static boolean findPair(String str) {
    String pair; // first two characters of the string
    String end; // end of string, to check for other instances of pair
    for (int i = 0; i < str.length()-1; i++) {
      pair = str.substring(i,i+2);
      end = str.substring(i+2);
      if (end.contains(pair)) return true;
    }
    return false;
  }
  // find instances of "one letter which repeats with exactly one letter between them" (ex. "mom", "dad")
  private static boolean findSandwich(String str) {
    for (int i = 0; i < str.length()-2; i++) {
      if (str.charAt(i) == str.charAt(i+2)) return true;
    }
    return false;
  }

  //================================================================================
  // TESTER
  //================================================================================
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
      int result = 0;

      // part 1
      if (args[1].equals("1")) {
        for (int i = 0; i < str.size(); i++) {
          if (naughtyNice1(str.get(i))) result++;
        }
      }

      // part 2
      if (args[1].equals("2")) {
        for (int i = 0; i < str.size(); i++) {
          if (naughtyNice2(str.get(i))) result++;
        }
      }
      System.out.println(result);
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("Invalid syntax: use \"java Problem05 [filename] [1/2]\".");
    }
  }
}
