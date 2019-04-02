import java.util.Collection;

//Successor with delete. Given a set of nn integers 
//S={0,1,...,n−1} and a sequence of requests of the
//following form:

//Remove x from S

//Find the successor of x: the smallest y in S such that y≥x.
//design a data type so that all operations (except 
//construction) take logarithmic time or better in the worst
//case.
//Hint: use the modification of the union−find data discussed in the previous question.
public class OrderedList {
    private ListItem root;

    public OrderedList(final int value){
        root = new ListItem(value);
    }

    public boolean addItem(int value){
        if(root.getValue < value){

        }
    }
}