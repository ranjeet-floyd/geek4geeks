/**
 * @author ranjeet
 */

public class MergeSort {

    // auxilarry space for merge sort
    private static Comparable[] aux;

    public static void main(String[] args) {
        System.out.println("Hello merge sort");
        String[] alphas = { "a", "c", "b", "d" };
        sort(alphas);
    }

    static void merge(Comparable[] a, int low, int mid, int high) {
        System.out.println("Low :" + low + " , mid :" + mid + " and high: " + high);

    }

    // bottom up merge sort | no recurrsion
    static void sort(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];

        for (int sz = 1; sz < N; sz = 2 * sz) {
            for (int lo = 0; lo < N - sz; lo += 2 * sz) {

                merge(a, lo, lo + sz - 1, Math.max(lo + 2 * sz - 1, N - 1));
            }
        }

    }
}