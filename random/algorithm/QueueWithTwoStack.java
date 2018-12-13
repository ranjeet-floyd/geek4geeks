/**
 * @author ranjeet
 * @see Implement a queue with two stacks so that each queue operations takes a
 *      constant amortized number of stack operations.
 */

public class QueueWithTwoStack {
    public static void main(String[] args) {
        System.out.println("Implement Queue with two stacks.");
    }

    private class QueueWithTwoStackImp<T> {
        private Stack<T> addToStack;
        private Stack<T> removeFromStack;

        public QueueWithTwoStack(int _size){
            addToStack = new Stack<>(_size);
            removeFromStack = new Stack<>(_size);
        }
        // add two stack .. add to 1st stack and remove from 2nd stack

        // add item to queue from back
        public void queue(T t) {
            addToStack.push(t);
        }

        // remove item from front queue
        public T dequeue() {
            return removeFromStack.pop();
        }
    }

    /**
     * stack
     * 
     * @param <T>
     */
    private class Stack<T> {
        Node<T> nodes[] = null;
        int size = 0;

        public Stack(int fixedSize) {
            nodes = (Node<T>) (new Object[fixedSize]);
        }

        public void push(T t) {
            if (nodes.length < size - 1) {
                nodes[i++] = t;
            }
            System.err.println("Stack is full");
        }

        public T pop() {
            if (nodes.length == 0) {
                System.err.println("Stack is empty");
            }
            T item = nodes[size];
            nodes[size] = null;
            size -= 1;
            return item;
        }

        public int size() {
            return nodes.length;
        }

        class Node<T> {
            T t;
            Node<T> next;

            public Node(T _t) {
                t = _t;
                next = null;

            }
        }
    }
}