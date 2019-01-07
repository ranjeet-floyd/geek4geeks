import java.util.ArrayList;
import java.util.*;

/**
 * @author ranjeet
 */
public class StringPermutation {
    public static void main(String[] args) {
        System.out.println("Find all permutation of string, asssume string has unique characters.");
        getAllPermutation("abc").forEach(s -> {
            System.out.println(s);
        });
        ;
    }

    static List<String> getAllPermutation(String str) {
        List<String> stringPermutations = new ArrayList<>();
        permutationHelper(str, stringPermutations, "");
        System.out.println("Result ");
        return stringPermutations;

    }

    static void permutationHelper(String str, List<String> permutations, String prefix) {
        System.out.println(str + " | " + prefix);
        // base condition
        if (str.isEmpty()) {
            return;
        }

        // add last charac to prefix
        prefix = prefix + str.charAt(str.length() - 1);

        // remove prefix
        str = str.substring(0, str.length() - 1);

        permutations.add(str + prefix);
        permutations.add(prefix + str);

        permutationHelper(str, permutations, prefix);

    }
}