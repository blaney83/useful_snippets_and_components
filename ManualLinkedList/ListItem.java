package com.blaney83;

public abstract class ListItem {
    protected ListItem previousItem = null;
    protected ListItem nextItem = null;
    protected String listValue;

    public ListItem(String listValue){
        this.listValue = listValue;
    }

    public ListItem getPreviousItem(){
        return this.previousItem;
    }
    public ListItem getNextItem(){
        return this.nextItem;
    }
    public String getListValue(){
        return this.listValue;
    }

    public void setPreviousItem(ListItem previousItem) {
        this.previousItem = previousItem;
    }

    public void setNextItem(ListItem nextItem) {
        this.nextItem = nextItem;
    }

    public int compareItem(ListItem comparedItem){
        if(comparedItem != null) {
            return getListValue().compareTo(comparedItem.getListValue());
        } else {
            return -1;
        }
    }
}
