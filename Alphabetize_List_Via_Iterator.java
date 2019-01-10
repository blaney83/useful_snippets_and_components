package io.github.blaney83;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Demo {
    public static void main(String[] args) {
        LinkedList<String> myList = new LinkedList<>();
        alphabetize("Sigma", myList);
        alphabetize("Beta", myList);
        alphabetize("Pi", myList);
        alphabetize("Kappa", myList);
        alphabetize("Alpha", myList);
        alphabetize("Delta", myList);
        printList(myList);
    }

    private static void printList(LinkedList<String> myList){
        Iterator<String> i = myList.iterator();
        while(i.hasNext()){
            System.out.println("Now visiting " + i.next());
        }
        System.out.println("********************");
    }

    private static boolean alphabetize(String newSting, LinkedList<String> oldList){
        //NOTE: currently directly modifies the original value of list, should be abstracted
        //and passed out as a return value in production. Recommended to use .toLowerCase as
        //well to eliminate unicode case variance.
        ListIterator<String> stringListIterator = oldList.listIterator();
        while(stringListIterator.hasNext()){
            int comparison = stringListIterator.next().compareTo(newSting);
            if(comparison == 0){
                System.out.println(newSting + " is already on the list.");
                return false;
            }else if(comparison > 0){
                stringListIterator.previous();
                stringListIterator.add(newSting);
                return true;
            }else if(comparison < 0){
                //move on
            }
        }
        stringListIterator.add(newSting);
        return true;
    }
}
