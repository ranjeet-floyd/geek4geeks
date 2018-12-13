/**
 * @author ranjeet
 */

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = { 6, 13, 14, 25, 33, 43, 51, 53, 64, 72, 84, 93, 95, 96, 97 };
        System.out.println("search 51 : " + search(arr, 51));
    }

    /**
     * 
     * @param arr  : sorted array
     * @param item : to search
     * @return : true if found.
     */
    static boolean search(int[] arr, int item) {

        return searchHelper(arr, 0, arr.length - 1, item);
    }

    static boolean searchHelper(int[] arr, int low, int high, int item) {

        if (low > high) {
            return false;
        }

        int mid = (low + high) / 2;
        System.out.println("low :" + arr[low] + " high :" + arr[high] + " and mid: " + arr[mid]);
        if (item == arr[mid]) {
            return true;
        }

        // go left
        if (item < arr[mid]) {
            System.out.println("go left");
            return searchHelper(arr, low, mid - 1, item);

        }
        // go right
        else {
            System.out.println("go right");
            return searchHelper(arr, mid + 1, high, item);

        }

    }
}