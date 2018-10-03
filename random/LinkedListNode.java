public class LinkedListNode {
    LinkedListNode next = null;
    int data;

    public LinkedListNode(int data) {
        this.data = data;
    }

    public void appendToTail(int data) {
        LinkedListNode end = new LinkedListNode(data);
        LinkedListNode n = this;

        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
        System.out.println("Added Node to end of LinkedList :" + data);
    }

    public static void main(String[] args) {
        LinkedListNode linkedListNode = new LinkedListNode(2);
        linkedListNode.appendToTail(3);
    }

}