/**
 * @author ranjeet
 *         <p>
 *         shell sort : increment 7,3,1
 */
public class ShellSort {
    public static void main(String[] args) {
        System.out.println("Hello Shell sort.. improve Insertion sort");
        String[] arr = { "a", "c", "d", "z", "h" };
        sort(arr);

    }

    static void sort(Comparable<String>[] a) {
        int N = a.length;
        int h = 1;
        // h => 1, 4, 13, 40, 121, ....
        while (h < N / 3) {
            h = 3 * h + 1;
            while (h >= 1) {
                // h-sort array
                for (int i = h; i < N; i++) {
                    for (int j = i; j >= h && less(a[j - h], a[j]); j -= h) {
                        exch(a, j, j - h);
                    }

                }
                h = h / 3;
            }
        }

    }

    static boolean less(Comparable<T> v, Comparable<T> w) {
        return v < w;
    }

    static void exch(Comparable<T>[] a, int i, int j) {
        Comparable<T> temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}