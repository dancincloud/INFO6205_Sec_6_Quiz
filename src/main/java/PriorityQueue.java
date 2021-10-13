/**
 * @author: Joseph Li @ Dancincloud
 * Date: 10/5/21 17:12
 **/

public class PriorityQueue {
    private int[] pq;
    private int N = 0;

    public PriorityQueue(int n){
        pq = new int[n + 1];
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    public void insert(int v){
        N++;
        pq[N] = v;
        swim(N);
    }

    public int delMax(){
        int max = pq[1];

        swap(1, N);
        N--;
        pq[N + 1] = 0;
        sink(1);
        return max;
    }

    // fixing the violation by exchanging the node with its parent.
    private void swim(int k){
        while (k > 1 && less(k / 2, k)){
            swap(k / 2, k);
            k /= 2;
        }
    }

    private void sink(int k){
        while (k * 2 <= N){
            int j = k * 2;
            if(j < N && less(j, j + 1)) j++;
            if(!less(k, j)) break;;
            swap(k, j);
            k = j;
        }
    }

    private boolean less(int i, int j){
        return pq[i] < pq[j];
    }

    private void swap(int i, int j){
        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }



    /* Used for debugging and testing */
    public void print(){
        int k = 2, index = 2;
        for(int i = 1; i < pq.length; i++){
            System.out.print(pq[i] + " ");
            if(i == index){
                System.out.println();
                k *= 2;
                index += k;
            }
        }
        System.out.println("\n");
    }

    public int[] getPq(){
        return pq;
    }
}
