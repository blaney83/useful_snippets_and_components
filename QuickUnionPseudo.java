import java.util.Map;

//array represents a set of trees "forest"
//value x for index i points to its parent in the tree
//if (x == i) => i is the root element
//root i == id[id[..id[i]..]]
// rudementary union-by-height implemenation
public class QuickUnionPseudo {

    private int[] id;

    // O(N)
    public QuickUnionPseudo(final int N) {

        id = new int[N];

        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    // O(N)
    private int findRoot(final int val) {
        int parent = val;
        while (parent != id[parent]) {
            parent = id[parent];
        }
        return parent;
    }

    // weighted implementation
    private int[] smartRoot(final int val) {
        int parent = val;
        int iter = 0;
        while (parent != id[parent]) {
            parent = id[parent];
            iter++;
        }
        return new int[] { parent, iter };
    }

    public boolean isConnected(int valOne, int valTwo) {
        return findRoot(valOne) == findRoot(valTwo);
    }

    // O(N), if passing roots, isRoot = true
    public void union(final int valOne, final int valTwo, final boolean isRoots) {
        int i = findRoot(valOne);
        int j = findRoot(valTwo);
        id[i] = j;
    }

    // joins small tree to root of larger tree to prevent tall, skinny,
    // non-performant trees
    public void weightedUnion(final int valOne, final int valTwo) {
        int[] smRt1 = smartRoot(valOne);
        int[] smRt2 = smartRoot(valTwo);
        if (smRt2[1] < smRt1[1]) {
            union(smRt1[0], smRt2[0], true);
        } else {
            union(smRt2[0], smRt1[0], true);
        }
    }

}

