import java.util.Arrays;

public class Problem25 {
  //================================================================================
  // TESTER
  //================================================================================
  public static void main(String[] args) {
    int[] input = {2947, 3029}; // {row, column}

    int[] currentCoords = {1, 1};
    long result = 20151125; // will be changed
    while (!(currentCoords[0] == input[0] && currentCoords[1] == input[1])) {
      currentCoords = incrementCoords(currentCoords);
      result = (result * 252533) % 33554393;
    }

    System.out.println("Answer: " + result);
  }

  private static int[] incrementCoords(int[] coords) {
    // format: {row, column} -> coords[0] is row, coords[1] is column
    if (coords[0] == 1) {
      coords[0] = coords[1] + 1;
      coords[1] = 1;
    } else {
      coords[0]--;
      coords[1]++;
    }
    return coords;
  }
}
