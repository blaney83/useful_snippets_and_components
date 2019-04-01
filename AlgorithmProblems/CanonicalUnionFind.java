//Union-find with specific canonical element. Add a method 
//find() to the union-find data type so that find(i) returns 
//the largest element in the connected component containing i. 
//The operations, union(), connected(), and find() should all 
//take logarithmic time or better.

//For example, if one of the connected components is 
//\{1, 2, 6, 9\}{1,2,6,9}, then the find() method should 
//return 99 for each of the four elements in the connected 
//components.

public class QuickUnion {

    private int[] id;
    private int[] sz;
    //contains the value of the largest member of the connected tree
    private int[] max;

    public QuickUnion(final int N) {

        id = new int[N];

        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
            max[i] = i;
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
        if(max[valOne] > max[valTwo]){
            max[valTwo] = max[valOne];
        }else{
            max[valOne] = max[valTwo];
        }
    }

    public int findTreeMax(final int val){
        return max[val];
    }
}
