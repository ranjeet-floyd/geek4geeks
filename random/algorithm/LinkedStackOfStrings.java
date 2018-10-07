/**
 * @author ranjeet
 */

public class LinkedStackOfStrings {
    public static void main(String[] args) {
        System.out.println("Hello Stack using Linked list .. ");

        LinkedStackOfStrings stackOfStrings = new LinkedStackOfStrings();
        stackOfStrings.push("1");
        stackOfStrings.push("2");
        stackOfStrings.push("3");
        System.out.println(stackOfStrings.pop());

    }

    private Node firstNode = null;

    private class Node {
        String item;
        Node next;

        public Node(String _item) {
            item = _item;
            next = null;
        }
    }

    public boolean isEmpty() {
        return null == firstNode;
    }

    public void push(String item) {
        Node oldFirst = firstNode;
        firstNode = new Node(item);
        firstNode.item = item;
        firstNode.next = oldFirst;
    }

    public String pop() {
        String item = firstNode.item;
        // move node to next.
        firstNode = firstNode.next;
        return item;
    }
}