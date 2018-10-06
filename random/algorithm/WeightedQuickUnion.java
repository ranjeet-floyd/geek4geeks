/**
 * @author ranjeet
 */

public class WeightedQuickUnion {

    private int[] nodes;

    private int[] nodeSize;

    private WeightedQuickUnion(int size) {
        nodes = new int[size];
        nodeSize = new int[size];
    }

    /**
     * Init all nodes with root itself and size 1.
     */
    private void intNodes() {
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = i;
            nodeSize[i] = 1;
        }
    }

    /**
     * Parent node if node value is equal to itself.
     * 
     * @param node
     * @return
     */
    private int getRootNode(int node) {
        while (node != nodes[node]) {
            node = nodes[node];
        }

        return node;
    }

    /**
     * Connected firstNode to root node of secondNode
     * 
     * @param firstNode
     * @param secondNode
     */
    private void union(int firstNode, int secondNode) {
        int secondNodeRoot = getRootNode(secondNode);
        nodes[firstNode] = 

    }

    private boolean isConnected(int firstNode, int secondNode) {
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Hello Weight Union  .. Keep control on tree level.");
    }

}