public class Problem10 {
  //================================================================================
  // TESTER
  //================================================================================
  public static void main(String[] args) {
    String input = "1113222113";
    boolean progressCheck = true;

    try {
      int repeat;
      if (args[0].equals("1")) { // part 1
        repeat = 40;
      } else if (args[0].equals("2")) { // part 2
        repeat = 50;
      } else {
        repeat = 0;
      }

      System.out.println("This might take a while!");
      String result = input;
      for (int i = 1; i <= repeat; i++) {
        result = lookAndSay(result);
        if (progressCheck) System.out.println(i + ": " + result.length());
      }
      System.out.println("Result: " + result.length());
    } catch (Exception e) {
      System.out.println("Invalid syntax: use \"java Problem10 [1/2]\".\nEdit the input inside the code.");
    }
  }

  //================================================================================
  // LOOK-AND-SAY MECHANISM
  //================================================================================
  private static String lookAndSay(String num) {
    char current = num.charAt(0);
    int count = 0;
    String newNum = "";

    for (int i = 0; i <= num.length(); i++) {
      if (i != num.length() && current == num.charAt(i)) { // count same number of characters in a row, check that it's not the last character
        count++;
      } else { // end at different number, edit newNum, start the count over with the new number
        newNum += count;
        newNum += current;
        if (i != num.length()) { // use new character if not at end of string
          current = num.charAt(i);
          count = 1; // not 0 since that would undercount by 1
        }
      }
    }

    return newNum;
  }
}
