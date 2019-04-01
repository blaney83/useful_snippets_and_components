//array represents a set of trees "forest"
//value x for index i points to its parent in the tree
//if (x == i) => i is the root element
//root i == id[id[..id[i]..]]
//**** for addn'l flattening see Ackermann Function
//weighted union with path compression is close to the most 
//linear algorithm possible
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
    //log_2(N)
    private int findRoot(final int val) {
        int parent = val;
        while (parent != id[parent]) {
            //IMPORTANT vvvv LINE
            id[parent] = id[id[parent]];
            //IMPORTANT ^^^^ LINE- flattens tree by setting 
            //moving the parents of all children on the path
            //up the tree during each search
            parent = id[parent];
        }
        return parent;
    }

    public boolean isConnected(int valOne, int valTwo){
        return findRoot(valOne) == findRoot(valTwo);
    }
    //connects smaller tree to root of bigger tree to prevent
    //non-performant deep, skinny trees
    //Any sequence of M union operations for N objects
    //always <= c(N+Mlg*N) or the number of times lg_2(N) must
    //be run in order to == 1 (iterative logarithm)
    //NOTE: implementation is union-by-size, not union by height
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
