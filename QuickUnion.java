//array represents a set of trees "forrest"
//value x for index i points to its parent in the tree
//if (x == i) => i is the root element
//root i == id[id[..id[i]..]]
public class QuickUnion {

    private int[] id;

    public QuickUnion(final int N) {

        id = new int[N];

        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    private int findRoot(final int val) {
        int parent = val;
        while (parent != id[parent]) {
            parent = id[parent];
        }
        return parent;
    }

    public boolean isConnected(int valOne, int valTwo){
        return findRoot(valOne) == findRoot(valTwo);
    }

    public void union(final int valOne, final int valTwo) {
        int i = findRoot(valOne);
        int j = findRoot(valTwo);
        id[i] = j;
    }

}
