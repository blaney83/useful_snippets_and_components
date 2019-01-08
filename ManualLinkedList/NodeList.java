package com.blaney83;

public interface NodeList {
    ListItem getRoot();
    boolean add(ListItem item);
    boolean remove(String itemValue);
    void traverse();
}
