import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Problem17 {
  //================================================================================
  // TESTER
  //================================================================================
  public static void main(String[] args) {
    ArrayList<Integer> containers = new ArrayList<Integer>();

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

    System.out.println(containers);

    for (int i = 0; i < 1048576; i++) {
      System.out.println(toBinary(i));
    }

/*
    try {
      String mode = args[1];


    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("Invalid syntax: use \"java Problem15 [filename] [1/2]\".");
    }
*/
  }

  private static int toBinary(int num) {
    String binary = "";

    int dividend = num;
    int remainder;

    while (dividend > 1) {
      // add to the number first
      remainder = num % 2;
      binary = ""+remainder + binary;

      // setup for next loop
      dividend /= 2;
    }
    binary = ""+dividend + binary;

    return Integer.parseInt(binary);
  }
}
