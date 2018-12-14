/**
 * One array holding heights of building are provided. its raining and there can be water accumulated between free space in buildings. Needed to find the accumulated water quantity. It was said to assume its raining for very long time so consider all free space which can hold water will be filled.
 @author ranjeet
 */

public class RainTap {
    public static void main(String[] args) {
        System.out.println("Find total Rain tap water.");
        int[] arr = { 7, 1, 4, 0, 2, 8, 6, 3, 5 };
        System.out.println("Total Water : " + findWater(arr));
    }

    static int findWater(int[] arr) {
        return findWaterHelper(arr, 0, arr.length - 1);
    }

    static int findWaterHelper(int[] arr, int left, int high) {
        int leftMax = 0;
        int rightMax = 0;
        int totalWater = 0;
        while (left < high) {
            // go from min of arr[ low] , arr[high]
            if (arr[left] < arr[high]) {
                // go from left side
                if (arr[left] >= leftMax) {
                    // update left max
                    leftMax = arr[left];
                } else {
                    totalWater += (leftMax - arr[left]);
                    System.out.println("totalWater :" + totalWater);
                }
                left++;

            }
            // go from right
            else {
                if (arr[high] >= rightMax) {
                    rightMax = arr[high];
                } else {
                    totalWater += rightMax - arr[high];
                    System.out.println("totalWater :" + totalWater);
                }
                high--;
            }

        }

        return totalWater;
    }

}