//array represents a set of trees "forest"
//value x for index i points to its parent in the tree
//if (x == i) => i is the root element
//root i == id[id[..id[i]..]]
public class QuickUnion {

    private int[] id;
    private int[] sz;
    //O(N)
    public QuickUnion(final int N) {

        id = new int[N];

        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }
    //O(N)
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
    //connects smaller tree to root of bigger tree to prevent
    //non-performant deep, skinny trees
    public void union(final int valOne, final int valTwo) {
        int i = findRoot(valOne);
        int j = findRoot(valTwo);
        if(i == j){
            return;
        }
        if(sz[i] < sz[j]){
            id[i] = j;
            sz[j] += sz[i];
        }else{
            id[j] = i;
            sz[i] += sz[j];
        }
        id[i] = j;
    }
}
