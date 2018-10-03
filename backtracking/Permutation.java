/**
 * Print all permutaion of String
 */
public class Permutation {
    public static void main(String[] args) {
        permutaion("Ranj");
    }

    static void permutaion(String str) {
        permutaionHelper(str, "");
    }

    static void permutaionHelper(String str, String prefix) {
        // base condition
        if (str.isEmpty()) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                String rem = str.substring(0, i) + str.substring(i + 1);
                permutaionHelper(rem, prefix + str.charAt(i));
            }
        }
    }
}