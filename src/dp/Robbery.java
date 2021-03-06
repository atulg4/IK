package dp;

public class Robbery {
  /**
   * Robbery
   *
   *
   *
   *
   *
   * Problem Statement:
   *
   * There are n houses built in a line, each of which contains some value in it. A thief is going to steal the maximal value in these houses, but he cannot steal in two adjacent houses because the owner of a stolen house will tell his two neighbors on the left and right side. What is the maximal stolen value?
   *
   *
   *
   * For example, if there are four houses with values [6, 1, 2, 7], the maximal stolen value is 13 when the first and fourth houses are stolen.
   *
   *
   *
   * Input Format:
   *
   *
   *
   * You will be given an array of integer values denoting the value in each house.
   *
   *
   *
   * Output Format:
   *
   *
   *
   * Return an integer denoting the maximum possible robbery.
   *
   *
   *
   * Constraints:
   *
   *
   *
   * 1 <= length(values) <= 10^5
   *
   * 1 <= values[i] <= 10^4
   *
   *
   *
   * Sample Test Case:
   *
   *
   *
   * Sample Input-1:
   *
   *
   *
   * values = [6, 1, 2, 7]
   *
   *
   *
   * Sample Output-1:
   *
   *
   *
   * 13
   *
   *
   *
   * Explanation-1:
   *
   *
   *
   * Steal from the first and the last house.
   *
   *
   *
   * Sample Input-2:
   *
   *
   *
   * steps = [1, 2, 4, 5, 1]
   *
   *
   *
   * Sample Output-2:
   *
   *
   *
   * 7
   *
   *
   *
   * Explanation-2:
   *
   *
   *
   * Steal from the second and the fourth house.
   */
  static int maxStolenValue(int[] values) {
    int[] table = new int[values.length+1];
    return maxStolenValue(values, table);
  }

  static int maxStolenValueR(int[] values, int index){
    if(index<0)
      return 0;

    return Math.max(maxStolenValueR(values, index-1), values[index]+maxStolenValueR(values, index-2));
  }

  static int maxStolenValue(int[] values, int[] table){
    table[0] = 0;
    table[1] = values[0];
    for(int i=2; i<table.length; i++){
      table[i] = Math.max(values[i-1]+table[i-2], table[i-1]);
    }

    return table[table.length-1];
  }

}
