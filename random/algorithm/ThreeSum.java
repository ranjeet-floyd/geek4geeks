import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author ranjeet
 * @see Given N distinct integers, how many triples sum to exactly zero?
 */

public class ThreeSum {
    public static void main(String[] args) {
        /*
         * 30 -40 -20 -10 40 0 10 5
         */

        int[] arr = { 30, -40, -20, -10, 40, 0, 10, 5 };
        System.out.println("Total count : " + getCountOfTripletSumOfZeroUsingBruteForce(arr));
        System.out.println("Total count : " + getCountOfTripletSumOfZeroUsingSet(arr));

    }

    static int getCountOfTripletSumOfZeroUsingBruteForce(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        count++;
                    }
                }

            }
        }

        return count;
    }

    /**
     * Time complexcity ~ O(n^2)
     * 
     * @param arr
     * @return
     */
    static int getCountOfTripletSumOfZeroUsingSet(int[] arr) {
        int count = 0;
        // first put all arr in HashMao for quick find.
        Map<Integer, Integer> arrMap = new HashMap<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            arrMap.put(arr[i], i);
        }
        System.out.println(arrMap);
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                int negativeSum = -(arr[i] + arr[j]);

                if (arrMap.containsKey(negativeSum) && arrMap.get(negativeSum) != i && arrMap.get(negativeSum) != j) {
                    System.out.println("negativeSum :" + negativeSum + " ith :" + arr[i] + " jth" + arr[j]);
                    count += 1;
                }

            }
        }
        return count;
    }

}