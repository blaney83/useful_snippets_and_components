
public class QuickFind {

    private int[] id;

    public QuickFind(final int N) {

        id = new int[N];

        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public boolean connected(final int valOne, final int valTwo) {
        return id[valOne] == id[valTwo];
    }
    //O(n^2)- quadratic time; too slow
    public void union(final int valOne, final int valTwo) {

        int valOneId = id[valOne];
        int valTwoId = id[valTwo];

        for (int i = 0; i < id.length; i++) {
            if (id[i] == valOneId) {
                id[i] = valTwoId;
            }
        }
    }
}