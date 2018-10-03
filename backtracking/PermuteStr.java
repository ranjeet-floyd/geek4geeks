/**
 * Ranjeet Kumar
 * <p>
 * choose/Explore/un-choose
 * 
 */
public class PermuteStr {
    public static void main(String[] args) {
        permute("RAN");
    }

    private static void permute(String s) {
        permuteHelper(s, "");

    }

    private static void permuteHelper(String s, String chosen) {
        System.out.println("permuteHelper( " + s + ", " + chosen + " )");
        // if s is empty , print chosen
        if (s.trim().isEmpty()) {
            System.out.println(chosen);
            return;
        }
        /*
         * for each character in s : choose c to be first. permute(the rest of s).
         * un-choose c
         */
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            permuteHelper(s.substring(i + 1, s.length()), chosen + c);
            
        }

    }

}