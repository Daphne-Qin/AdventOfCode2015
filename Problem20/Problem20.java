public class Problem20 {
  //================================================================================
  // TESTER
  //================================================================================
  public static void main(String[] args) {
    int input = 36000000;
    boolean progressCheck = true; // Warning: spammy!

    int houseNum = 1;
    int numPresents = 0;
    try {
      if (args[0].equals("1")) { // part 1
        input = input / 10;
        while(numPresents < input) {
          numPresents = presents(houseNum);
          if (progressCheck) {
            System.out.println("House Number: " + houseNum + "\nPresents/10: " + numPresents);
          }
          houseNum++;
        }
        houseNum--;
        /*
      } else if (args[0].equals("2")) { // part 2
        */
      } else {
        houseNum = -1;
      }

      System.out.println(houseNum);

    } catch (Exception e) {
      System.out.println("Invalid syntax: use \"java Problem20 [1/2]\".\nEdit the input inside the code.");
    }
  }

  //================================================================================
  // CALCULATING NUMBER OF PRESENTS TO A SPECIFIC HOUSE
  //================================================================================
  private static int presents(int houseNum) {
    int result = 0;
    for (int i = 1; i <= houseNum; i++) {
      if (houseNum % i == 0) result += i;
    }
    return result;
  }
}
