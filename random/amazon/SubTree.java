
public class SubTree {
    public static void main(String[] args) {

        Node root1 = new Node(26);
        root1.right = new Node(3);
        root1.right.right = new Node(3);
        root1.left = new Node(10);
        root1.left.left = new Node(4);
        root1.left.left.right = new Node(30);
        root1.left.right = new Node(6);

        //
        Node root2 = new Node(10); 
        root2.right = new Node(6); 
        root2.left = new Node(4); 
        root2.left.right = new Node(30);

        System.out.println(isSubTree(root1, root2));

    }

  static  boolean isSubTree(Node t, Node s) {
        // base condition
        if (s == null) {
            return true;
        }
        if (t == null) {
            return false;
        }
        if (areIdentical(t, s)) {
            return true;
        }
        return isSubTree(t.left, s) || isSubTree(t.right, s);
    }

    static  boolean areIdentical(Node t1, Node t2) {
        // base case
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        // check if data is also same
        if (t1.val == t2.val) {
            return areIdentical(t1.left, t2.left) && areIdentical(t1.right, t2.right);
        }

        return false;

    }

    static class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
        }
    }
}