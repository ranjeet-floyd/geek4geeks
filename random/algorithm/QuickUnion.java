
/**
 * @author ranjeet
 */
public class QuickUnion {
    private int[] nodes;

    public QuickUnion(int maxSize) {
        nodes = new int[maxSize];
        for (int i = 0; i < maxSize; i++) {
            // every node root node is itself.
            nodes[i] = i;
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello Quick Union.");

        QuickUnion quickUnion = new QuickUnion(10);
        quickUnion.union(4, 3);
        quickUnion.union(3, 8);
        quickUnion.union(6, 5);
        quickUnion.union(9, 4);
        quickUnion.union(2, 1);
        quickUnion.union(1, 8);
        System.out.println("node : 8 and 9  are connected : " + quickUnion.isConnected(8, 9));
        quickUnion.union(6, 3);
        quickUnion.union(7, 3);
        quickUnion.printNodes();
    }

    /**
     * Connect two nodes (firstNode, secondNode) | connect firstNode to parent of
     * secondNode.
     */
    void union(int firstNode, int secondNode) {
        int secondNodeRoot = getRootNode(secondNode);
        nodes[firstNode] = secondNode;
        System.out.println("firstNode :" + firstNode + " and secondNode : " + secondNode
                + " is connected with  root node : " + secondNodeRoot);
    }

    /**
     * iterate till node is root of itself. node == nodeVal
     * 
     * @param node
     * @return
     */
    int getRootNode(int node) {
        int nodeVal = nodes[node];

        while (node != nodeVal) {
            node = nodeVal;
            nodeVal = nodes[nodeVal];
        }
        System.out.println("Root node of  :" + node + " is :" + node);
        return node;
    }

    /**
     * If both node has same parent, then connected.
     * 
     * @param firstNode
     * @param secondNode
     * @return
     */
    boolean isConnected(int firstNode, int secondNode) {
        return getRootNode(firstNode) == getRootNode(secondNode);
    }

    void printNodes() {
        for (int i = 0; i < nodes.length; i++) {
            System.out.println("Node " + i + " is root  is :" + nodes[i]);
        }
    }

}