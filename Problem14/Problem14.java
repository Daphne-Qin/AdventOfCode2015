import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Problem14 {
  // finds maximum from an array of numbers
  private static int findMax(int[] nums) {
    int result = nums[0]; // there will always be at least one number
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > result) result = nums[i];
    }
    return result;
  }

  //================================================================================
  // TESTER
  //================================================================================
  public static void main(String[] args) {
    int numReindeers = 9;
    int totalTime = 2503;
    boolean debug = false;

    Reindeer[] r = new Reindeer[numReindeers];

    // initialize all Reindeer
    try {
      String line;
      int reindeerNum = 0;
      File file = new File(args[0]);
      Scanner input = new Scanner(file);
      while (input.hasNextLine()) {
        line = input.nextLine();
        String[] data = line.split(" ");
        r[reindeerNum] = new Reindeer(Integer.parseInt(data[3]), Integer.parseInt(data[6]), Integer.parseInt(data[13]), 0);
        reindeerNum++;
      }
      input.close();
    } catch (FileNotFoundException ex) {
      System.out.println("File not found!");
    }

    try {
      int result;
      int[] allDistances = new int[numReindeers];

      if (args[1].equals("1")) { // part 1
        for (int i = 0; i < numReindeers; i++) {
          allDistances[i] = r[i].distance(totalTime);
        }
        result = findMax(allDistances);
        if (debug) System.out.println(Arrays.toString(allDistances));


      } else if (args[1].equals("2")) { // part 2
        int maxDistance;
        int[] allPoints = new int[numReindeers];
        for (int currentTime = 1; currentTime <= totalTime; currentTime++) { // finds distances of all Reindeer at all times (up to totalTime)
          for (int i = 0; i < numReindeers; i++) {
            allDistances[i] = r[i].distance(currentTime);
          }
          maxDistance = findMax(allDistances);
          for (int i = 0; i < numReindeers; i++) {
            if (allDistances[i] == maxDistance) r[i].addPoints();
          }
          if (debug) System.out.println(Arrays.toString(allDistances));
        }

        for (int i = 0; i < numReindeers; i++) {
          allPoints[i] = r[i].getPoints();
        }
        if (debug) System.out.println(Arrays.toString(allPoints));

        result = findMax(allPoints);


      } else {
        result = -1;
      }

      System.out.println(result);

    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("Invalid syntax: use \"java Problem14 [filename] [1/2]\"");
    }
  }
}
