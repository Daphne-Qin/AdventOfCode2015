import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Problem17 {
  //================================================================================
  // TESTER
  //================================================================================
  public static void main(String[] args) {
    ArrayList<Integer> containers = new ArrayList<Integer>();
    int totalContainers;
    int desiredSum = 150;

    try {
      File file = new File(args[0]);
      Scanner input = new Scanner(file);
      while (input.hasNextInt()) {
        containers.add(input.nextInt());
      }
      input.close();
    } catch (FileNotFoundException ex) {
      System.out.println("File not found!");
    }
    totalContainers = containers.size();

    try {
      String mode = args[1];

      int result = 0;
      ArrayList<Integer> numContainers = new ArrayList<Integer>(); // used for part 2

      // goes through each iteration
      for (int i = 0; i < Math.pow(2, totalContainers); i++) {
        String on = fillBinary(Integer.toBinaryString(i), totalContainers); // 1s are added, 0s are not
        if (selectiveSum(containers, on) == desiredSum) {
          if (mode.equals("1")) {
            result++;
          } else if (mode.equals("2")) {
            numContainers.add(Integer.bitCount(i)); // bitCount() is used for counting how many containers are used
          }
        }
      }

      // extra part 2 steps to find the lowest number of containers needed and how many permutations of that there are
      if (mode.equals("2")) {
        Collections.sort(numContainers);
        int leastContainers = numContainers.get(0);
        for (int i = 0; numContainers.get(i) == leastContainers; i++) {
          result++;
        }
      }

      if (!mode.equals("1") && !mode.equals("2")) result = -1;
      System.out.println(result);

    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("Invalid syntax: use \"java Problem17 [filename] [1/2]\".");
    }
  }

  //================================================================================
  // HELPER FUNCTIONS
  //================================================================================
  // adds 0s to the binary string until the string reaches length len
  private static String fillBinary(String bin, int len) {
    while (bin.length() < len) {
      bin = "0" + bin;
    }
    return bin;
  }
  // adds numbers based on binary - 0 means ignore, 1 means add (nums and on are the same length)
  private static int selectiveSum(ArrayList<Integer> nums, String on) {
    int sum = 0;
    for (int i = 0; i < nums.size(); i++) {
      if (on.charAt(i) == '1') {
        sum += nums.get(i);
      }
    }
    return sum;
  }
}
