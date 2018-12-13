import java.util.List;

/**
 * @author ranjeet
 * 
 */

public class InsertionSort {
    public static void main(String[] args) {
        System.out.println("Hello insertion sort.");

        Data[] arr = { new Data(11), new Data(4), new Data(8), new Data(9), new Data(10), new Data(1) };
        sort(arr);
        // print(arr);

    }

    private static class Data implements Comparable<Data> {
        int data;

        public Data(int _data) {
            data = _data;
        }

        @Override
        public String toString() {
            return Integer.toString(data);
        }

        /**
         * @return the data
         */
        public int getData() {
            return data;
        }

        @Override
        public int compareTo(Data o) {
            if (this.getData() - o.getData() > 0) {
                return 1;
            } else {
                if (this.getData() == o.getData()) {
                    return 0;
                }

                else
                    return -1;

            }
        }

    }

    static void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                System.out.println("i : " + i + " and j :" + j);
                print(a);
                if (less(a[j], a[j - 1])) {
                    exch(a, j, j - 1);
                } else
                    break;
            }
        }

    }

    static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;

    }

    static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    static void print(Comparable[] a) {
        for (Comparable var : a) {
            System.out.print(var + " ");

        }
    }
}