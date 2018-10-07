import com.sun.org.apache.xpath.internal.operations.String;

/**
 * @author ranjeet
 *         </p>
 *         2 double size but reduce by 1/4 only.
 */

public class ResizeCapacityStacksOfStrings {

    private String[] s;
    private int currSize = 0;

    public ResizeCapacityStacksOfStrings() {
        s = new String[1];
    }

    public static void main(String[] args) {
        System.out.println("");
    }

    public void push(String item) {
        // double array size
        if (s.length == currSize) {
            resize(2 * s.length);
        }

        s[currSize++] = item;

    }

    public String pop() {
        String item = s[--currSize];
        s[currSize] = null;

        if (currSize == s.length / 4) {
            resize(s.length / 2);
        }

        return item;

    }

    private void resize(int capacity) {
        String[] copy = new String[capacity];
        for (int i = 0; i < currSize; i++) {
            copy[i] = s[i];
        }

        s = copy;
    }

}