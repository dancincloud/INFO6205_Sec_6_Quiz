/**
 * @author: Joseph Li @ Dancincloud
 * Date: 9/29/21 00:09
 **/

public class UnionFind {
    private int[] parent;

    public UnionFind (int N) {
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
    }

    // check parent pointer until reach root
    private int find(int i) {
        while (i != parent[i]) {
            parent[i] = parent[parent[i]]; // path compression
            i = parent[i];
        }

        return i;
    }

    void union (int p, int q) {
        int i = find(p);
        int j = find(q);

        parent[i] = j;
    }

    boolean connected (int p, int q) {
        return find(p) == find(q);
    }

    void print () {
        for (int i = 0; i < parent.length; i++) {
            System.out.printf("%d = %d\n", i, parent[i]);
        }
    }
}
