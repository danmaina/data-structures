package com.sg.linkedlists;

import java.util.Iterator;

public class DoublyLinkedLists<T> implements Iterable<T> {

    private int size = 0;
    private DLNode<T> head = null;
    private DLNode<T> tail = null;

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    public void clear() {
        DLNode<T> trav = head;

        while (trav != null) {
            DLNode<T> next = trav.next;
            trav.prev = trav.next = null;
            trav.data = null;
            trav = next;
        }

        head = tail = trav = null;

        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    // Add an element to the tail of the liked list, O(1)
    public void add(T elem) {
        addLast(elem);
    }

    // Add an element to the beginning of this linked list, O(1)
    public void addFirst(T elem) {
        // The linked list is empty
        if (isEmpty()) {
            head = tail = new DLNode<>(elem, null, null);
        } else {
            head.prev = new DLNode<>(elem, null, head);
            head = head.prev;
        }

        size++;
    }

    // Add a node to the tail  of the linked list O(1)
    public void addLast(T elem) {
        // The linked list is empty
        if (isEmpty()) {
            head = tail = new DLNode<>(elem, null, null);
        } else {
            tail.next = new DLNode<>(elem, tail, null);
            tail = tail.next;
        }

        size++;
    }

    // Check the value of the first node if it exists, O(1)
    public T peekFirst() {
        if (isEmpty())
            throw new RuntimeException("Empty List");

        return head.data;
    }

    // Check the value of the last node if it exists, O(1)
    public T peekLast() {
        if (isEmpty())
            throw new RuntimeException("Empty List");

        return tail.data;
    }

    // Remove the first value at the head of the linked list
    public T removeFirst() {

        // Can't remove data from an empty list -_-
        if (isEmpty()) throw new RuntimeException("Empty List");

        T data = head.data;

        // Extract the data at the head and move the head pointer forwards one node
        head = head.next;
        --size;

        // If the list is empty after moving the head set the tail to null as well
        if (isEmpty()) tail = null;

            // Do a memory clean of the previous node
        else head.prev = null;

        // Return the head data that was removed
        return data;
    }

    // Remove the last value at the tail of the linked list
    public T removeLast() {
        // Can't remove data from an empty list
        if (isEmpty()) throw new RuntimeException("Empty List");

        T data = tail.data;

        tail = tail.prev;
        --size;

        // If list is empty after moving tail set the tail to null as well
        if (isEmpty()) head = null;

            // Do a memory clean of the node that was just removed
        else tail.next = null;

        return data;
    }

    // Remove a node from the doubly linked list
    public T remove(DLNode<T> node) {
        // If the node is either at the head or the tail, handle those independently
        if (node.prev == null) removeFirst();
        if (node.next == null) removeLast();

        // Make the pointers of adjacent nodes skip over 'node'
        node.next.prev = node.prev;
        node.prev.next = node.next;

        T data = node.data;

        node.data = null;
        node = node.prev = node.next = null;

        --size;

        return data;
    }

    // Remove a node at a specific index
    public T removeAt(int index) {
        // Make sure that the index provided is valid
        if (index < 0 || index >= size) throw new IllegalArgumentException();

        int i;
        DLNode<T> trav;

        // Search from the front of the list
        if (index < size / 2) {
            for (i = 0, trav = head; i != index; i++)
                trav = trav.next;
            // Search from the back of the list
        } else
            for (i = size - 1, trav = tail; i != index; i--)
                trav = trav.prev;

        return remove(trav);
    }

}