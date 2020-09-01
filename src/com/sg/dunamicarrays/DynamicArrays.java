package com.sg.dunamicarrays;

import java.util.Iterator;

public class DynamicArrays<T> implements Iterable<T> {

    private T[] arr;
    private int len = 0; // Length user things the array is
    private int capacity = 0; // Actual Array size

    public DynamicArrays(int capacity) {
        if (capacity < 0)
            throw new IllegalArgumentException("Unacceptable Array Capacity: " + capacity);

        this.capacity = capacity;

        arr = (T[]) new Object[capacity];
    }

    public int size() {
        return len;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T get(int index) {
        return arr[index];
    }

    public void set(int index, T elem) {
        arr[index] = elem;
    }

    public void clear() {
        for (int i = 0; i < capacity; i++)
            arr[i] = null;

        len = 0;
    }

    public void add (T elem) {
        if (len +1 >= capacity){
            if (capacity == 0)
                capacity = 1;
            else
                capacity *= 2; //double array size

            T[] newArr = (T[]) new Object[capacity];

            for (int i = 0; i < len; i++) {
                newArr[i] = arr[i];
            }

            arr = newArr;
        }

        arr[len++] = elem;
    }

    public T removeAt(int rmIndex) {
        if (rmIndex >= len && rmIndex < 0)
            throw new IndexOutOfBoundsException();

        T data = arr[rmIndex];

        T[] newArr = (T[]) new Object[len - 1];

        for (int i = 0, j = 0; i < len; i++, j++) {
            if (i == rmIndex) {
                j--;
            } else {
                newArr[j] = arr[i];
            }
        }

        arr = newArr;

        capacity = --len;

        return data;
    }

    public boolean remove(Object obj) {
        for (int i =0; i < len; i++){
            if (arr[i].equals(obj)){
                remove(i);
                return true;
            }
        }

        return false;
    }

    public int indexOf(Object obj) {
        for(int i = 0; i < len; i++){
            if (arr[i].equals(obj))
                return i;
        }

        return -1;
    }

    public boolean contains(Object obj){
        return indexOf(obj) != -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < len;
            }

            @Override
            public T next() {
                return arr[index++];
            }
        };
    }
}
