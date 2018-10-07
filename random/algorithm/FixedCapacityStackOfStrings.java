/**
 * @author ranjeet
 */
public class FixedCapacityStackOfStrings {
    private String[] s;
    private int currSize = 0;

    private FixedCapacityStackOfStrings(int capacity) {
        s = new String[capacity];

    }

    public static void main(String[] args) {
        System.out.println("Fixed Capacity Stack of Strings");
        FixedCapacityStackOfStrings stackOfStrings = new FixedCapacityStackOfStrings(10);
        stackOfStrings.push("1");
        stackOfStrings.push("2");
        stackOfStrings.push("3");
        stackOfStrings.push("4");

        System.out.println("Element 4 is push : and return : " + stackOfStrings.pop());
    }

    public boolean isEmpty() {
        return currSize == 0;
    }

    public void push(String item) {
        s[currSize++] = item;
    }

    public String pop() {
        String item = s[--currSize];
        // avoid loitering
        s[currSize] = null;
        return item;
    }

}