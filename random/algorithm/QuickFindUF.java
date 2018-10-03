/**
 * Eager apporoach | Dynamic connectivity using Quick Find.
 */
public class QuickFindUF {
    private int[] nodes;

    public QuickFindUF(int maxSize) {
        nodes = new int[maxSize];
        init();
    }

    /**
     * Init with all nodes are disconnected as each one has different values.
     * 
     */
    public void init() {
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = i;
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello quick find.");
        QuickFindUF quickFindUF = new QuickFindUF(10);
        quickFindUF.union(0, 5);
        quickFindUF.union(5, 6);
        // union
        quickFindUF.union(1, 2);
        quickFindUF.union(2, 7);

        // union
        quickFindUF.union(8, 3);
        quickFindUF.union(3, 4);
        quickFindUF.union(4, 9);

        quickFindUF.printAllNodes();

        System.out.println(" Node 0 and 1 should not connected : " + quickFindUF.isConnected(0, 1));
        System.out.println(" Node 8 and 9 should  connected : " + quickFindUF.isConnected(8, 9));
    }

    public void printAllNodes() {
        for (int i = 0; i < nodes.length; i++) {
            System.out.println("Node at index : " + i + " is  " + nodes[i]);
        }
    }

    /**
     * Connect node a to node b.
     * <p>
     * note : connect(a,b) is not same as connect(b,a)
     * 
     * @param a : first node
     * @param b : node to connect
     * 
     */
    public void union(int firstNode, int anotherNode) {
        int firstNodeVal = nodes[firstNode];
        int anotherNodeVal = nodes[anotherNode];
        for (int i = 0; i < nodes.length; i++) {
            if (firstNodeVal == nodes[i]) {
                nodes[i] = anotherNodeVal;
            }
        }
        System.out.println("Node : " + firstNode + " and : " + anotherNode + " is connected");
    }

    /**
     * Two nodes are connected if they have same values. check if two node are
     * connected or not.
     * 
     * @param firstNode
     * @param anotherNode
     * @return true if connected.
     */
    public boolean isConnected(int firstNode, int anotherNode) {
        int firstNodeVal = nodes[firstNode];
        int anotherNodeVal = nodes[anotherNode];
        return firstNodeVal == anotherNodeVal;
    }

}