/**
 * Provided n ropes with different lengths we are require to join them to form one rope.Joining two ropes with a and b length costs a\*b. We are require to join all ropes with minimum cost possible.
 * @author ranjeet
 */
public class MinCostRopes {
    public static void main(String[] args) {
        System.out.println("Join all ropes with minumum cost possible");
        int[] ropeLens = { 2, 4, 8, 1 };
        MinHeap minHeap = buildMinHeap(ropeLens);
       System.out.println("Min of cost :" +  minCost(minHeap));
    }

    static int minCost(MinHeap minHeap) {
        int cost = 0 ;
        while(!minHeap.isSizeOne()){
        int  minRope1 = minHeap.deleteRoot();
          int  minRope2 = minHeap.deleteRoot();
        cost += minRope1 + minRope2;
        minHeap.insert(minRope1 + minRope2);
    }
        minHeap.printHeap();
        return cost;

    }

    static MinHeap buildMinHeap(int[] ropeLens){
        MinHeap minHeap = new MinHeap(ropeLens.length);
        for (int i = 0; i < ropeLens.length; i++) {
            minHeap.insert(ropeLens[i]);
            minHeap.printHeap();
        }
        return minHeap;
    }
    
    static class MinHeap {
        
        int[] elements;
        int lastIndex = -1;
        // create min heap with n elements
        public MinHeap(int n) {
            elements = new int[n];

        }

        boolean isSizeOne(){
            return lastIndex == 1 ;
        }
        // delete root and put 
        int deleteRoot() {
            int root = elements[0];
            //put last element at root and heapify Down
            elements[0] = elements[lastIndex];
            heapifyDown(0);
            lastIndex--;
            return root;
        }

        void printHeap() {
            for (int i = 0; i <= lastIndex; i++) {
                System.out.print(elements[i] + " ");
            }
            System.out.println("lastIndex :"+lastIndex);
        }
        // insert element in heap and put element at correct position
        void insert(int elem) {
            lastIndex++;
            elements[lastIndex] = elem;
            heapifyUp(lastIndex);
        }
        
        /**
         * put index element at correct position from Down
         */
        void heapifyUp(int childIndex) {
            int parentIndex = getParentIndex(childIndex);
            //if parent > child ..then swap
            while (isSafe(parentIndex) && elements[parentIndex] > elements[childIndex]) {
                swap(parentIndex, childIndex);
                // update child index
                childIndex = parentIndex;
                parentIndex = getParentIndex(childIndex);
            }

        }

        void heapifyDown(int parentIndex) {
            int minChildIndex = getMinOfChilds(parentIndex);
            while (isSafe(minChildIndex) && elements[parentIndex] > elements[minChildIndex]) {
                swap(parentIndex, minChildIndex);
                // update parent index
                parentIndex = minChildIndex;
                minChildIndex = getMinOfChilds(parentIndex);
                
            }

        }

        int getParentIndex(int childIndex) {
            return (childIndex - 1) / 2;
        }

        int getLeftChildIndex(int parentIndex) {
            
            int index =  2*parentIndex + 1 ;
            if(isSafe(index)){
                return index;
            }
            return Integer.MIN;
        }

        int getRightChildIndex(int parentIndex) {
            int index =  2*parentIndex + 2 ;
            if(isSafe(index)){
                return index;
            }
            return Integer.MIN;
        }

        // check index
        int getMinOfChilds(int parentIndex){
            int leftChildIndex = getLeftChildIndex(parentIndex);
            
            int rightChildIndex = getRightChildIndex(parentIndex);
            
            if(elements[leftChildIndex] > elements[rightChildIndex]){
                return rightChildIndex;
            }
            return leftChildIndex;

        }

        void swap(int i, int j) {
            int temp = elements[i];
            elements[i] = elements[j];
            elements[j] = temp;
        }

        boolean isSafe(int index){
            return index < lastIndex;

        }

    }
}