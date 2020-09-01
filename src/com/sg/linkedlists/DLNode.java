package com.sg.linkedlists;


public class DLNode<T> {
    
    T data;
    DLNode<T> prev, next;

    public DLNode(T data, DLNode<T> prev, DLNode<T> next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

    @Override
    public String toString() {
        return "DLNode{" +
                "data=" + data +
                '}';
    }
}
