package edu.learn.ds.stack;

import java.util.Arrays;

public class ArrayBasedStack {
    private int capacity = 10;
    private Object[] items = new Object[capacity];
    private int size = 0;

    public void push(Object item) {
        if(size != 0 && items.length == size){
            capacity = capacity + 10;
            items = Arrays.copyOf(items, capacity);
        }

        items[size++] = item;
    }

    public Object pop(){
        if(size == 0){
            throw new RuntimeException("Stack is empty");
        } else {
            Object item = items[size - 1];
            items[size - 1] = null;
            size--;
            return item;
        }
    }

    public Object peek() {
        if(size == 0){
            throw new RuntimeException("Stack is empty");
        } else {
            Object item = items[size - 1];
            return item;
        }
    }

    public int size(){
        return this.size;
    }

    public static void main(String[] args) {
        ArrayBasedStack arrayBasedStack = new ArrayBasedStack();
        arrayBasedStack.push(1);
        arrayBasedStack.push(2);
        System.out.println(arrayBasedStack.pop());
        System.out.println(arrayBasedStack.peek());
        System.out.println(arrayBasedStack.pop());

        int ARRAY_SIZE = 50;
        for(int i = 0; i < ARRAY_SIZE; i++){
            arrayBasedStack.push(i);
        }

        /*for(int i = 0; i < arrayBasedStackX.size(); i++){
            System.out.println(i + " = " + arrayBasedStackX.pop());
        }*/

        while(arrayBasedStack.size() != 0){
            System.out.println(arrayBasedStack.pop());
        }
    }
}
