package com.blaney83;

public class ManualLinkedList implements NodeList {
    private ListItem root;

    public ManualLinkedList() {
        this.root = null;
    }

    @Override
    public ListItem getRoot() {
        return null;
    }

    public boolean add(ListItem item) {
        if (this.root == null) {
            item.setPreviousItem(null);
            item.setNextItem(null);
            this.root = item;
            return true;
        }
        ListItem currentItem = this.root;
        while (currentItem != null) {
            int comparison = item.compareItem(currentItem);
            if (comparison < 0) {
                if (currentItem.getNextItem() != null) {
                    currentItem = currentItem.getNextItem();
                } else {
                    currentItem.setNextItem(item);
                    item.setPreviousItem(currentItem);
                    return true;
                }
            } else if (comparison > 0) {
                ListItem previousItem = currentItem.getPreviousItem();
                if (previousItem == null) {
                    currentItem.setPreviousItem(item);
                    item.setNextItem(currentItem);
                    item.setPreviousItem(null);
                    this.root = item;
                } else {
                    previousItem.setNextItem(item);
                    item.setPreviousItem(previousItem);
                    item.setNextItem(currentItem);
                    currentItem.setPreviousItem(item);
                }
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean remove(String itemValue) {
        ListItem currentItem = this.root;
        while(currentItem != null){
            int comparison = currentItem.getListValue().compareTo(itemValue);
            System.out.println(comparison);
            System.out.println(itemValue);
            System.out.println(currentItem.getListValue());
            if(comparison == 0){
                if(currentItem == this.root){
                    this.root = currentItem.getNextItem();
                }else{
                    currentItem.getPreviousItem().setNextItem(currentItem.getNextItem());
                    if(currentItem.getNextItem() != null){
                        currentItem.getNextItem().setPreviousItem(currentItem.getPreviousItem());
                    }
                }
                return true;
            }else if(comparison < 0){
                currentItem = currentItem.getNextItem();
            }else{
                return false;
            }
        }
        return false;
    }

    public void traverse() {
        ListItem anchorValue = this.root;
        while(this.root != null){
            System.out.println(this.root.getListValue());
            this.root = this.root.getNextItem();
        }
        this.root = anchorValue;
    }
}
