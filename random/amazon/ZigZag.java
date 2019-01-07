import java.util.Stack;

public class ZigZag {
    public static void main(String[] args) {

        Node rootNode = new Node(1);
        rootNode.left = new Node(2);
        rootNode.right = new Node(3);
        rootNode.left.left = new Node(7);
        rootNode.left.right = new Node(6);
        rootNode.right.left = new Node(5);
        rootNode.right.right = new Node(4);
        printZigZag(rootNode);

    }

    static void printZigZag(Node rootNode) {
        if (rootNode == null) {
            return;
        }

        Stack<Node> currLevelStack = new Stack<>();
        Stack<Node> nextLevelStack = new Stack<>();

        boolean leftToRight = true;

        currLevelStack.push(rootNode);

        while (!currLevelStack.isEmpty()) {
            
            Node node = currLevelStack.pop();

            System.out.println(node.data + " ");

            if (leftToRight) {
                if (node.left != null) {
                    nextLevelStack.push(node.left);
                }

                if (node.right != null) {
                    nextLevelStack.push(node.right);
                }
            } else {
                if (node.right != null) {
                    nextLevelStack.push(node.right);
                }

                if (node.left != null) {
                    nextLevelStack.push(node.left);
                }
            }

            if (currLevelStack.isEmpty()) {
                // if current stack empty got to next level
                // swap stack
                leftToRight = !leftToRight;
                Stack<Node> temp = currLevelStack;
                currLevelStack = nextLevelStack;
                nextLevelStack = temp;
                System.out.println("current Level stack empty");
            }
        }

    }

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

}