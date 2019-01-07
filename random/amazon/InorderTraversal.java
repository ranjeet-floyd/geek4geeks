/**
 * Tranverse binary tree in Inorder
 * @author ranjeet
 */

public class InorderTraversal {
    public static void main(String[] args) {
        System.out.println("Traverse tree InOrder");
        //root
        Node root = new Node(1);
        //level 1
        root.left = new Node(2);
        root.right = new Node(3);
        // level 2
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        

        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(11);

        root.right.left.left = new Node(12);
        root.right.left.right = new Node(13);
        root.right.right.left = new Node(14);
        root.right.right.right = new Node(15);

        // traverse node
        traverse(root);
    }
     
    static void traverse(Node root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        System.out.println(root.data);
        traverse(root.right);
    }
    
    /**
     * Tree Node Bean
     */
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
 }
