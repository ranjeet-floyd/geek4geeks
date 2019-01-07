import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String args[]) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        int[] arr = { 2, 2, 5, 6, 9, 2, 11 };
        int n = arr.length;
        int m = 2;
        System.out.println(countSubArrays(arr, n, m));
    }

    static int countSubArrays(int[] arr, int n, int oddNum) {
        int count = 0;
        int[] prefix = new int[n];
        int odd = 0;

        for (int i = 0; i < n; i++) {
            prefix[odd]++;
            // check odd element
            if (arr[i] % 2 == 1) {
                odd++;

            }
            if (odd >= oddNum) {
                count += prefix[odd - oddNum];
            }
        }
        return count;
    }
}