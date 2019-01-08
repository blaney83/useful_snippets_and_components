package com.blaney83;

public class Main {

    public static void main(String[] args) {
	    ManualLinkedList classLinkedList = new ManualLinkedList();
        String seedData = "Phoenix Seattle Dallas Chicago London Paris Boston Miami Istanbul Jakarta Beijing";
        String[] stringArray = seedData.split(" ");
        for(String itemValue: stringArray){
            classLinkedList.add(new Item(itemValue));
        }
        classLinkedList.traverse();
        classLinkedList.remove("Jakarta");
        classLinkedList.traverse();
    }
}
