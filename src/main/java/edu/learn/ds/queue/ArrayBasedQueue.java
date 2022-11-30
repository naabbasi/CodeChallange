package edu.learn.ds.queue;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ArrayBasedQueue {
    private int CAPACITY = 10;
    private Object[] items = new Object[CAPACITY];
    private int size = 0;
    private int dequeueSize = 0;

    public void enqueue(Object item) {
        if(size != 0 && items.length == size){
            CAPACITY = CAPACITY + 10;
            items = Arrays.copyOf(items, CAPACITY);
        }

        items[size++] = item;
        if(dequeueSize != 0){
            dequeueSize--;
        }
    }

    public Object dequeue() {
        if(size == 0){
            throw new RuntimeException("Queue doesn't have any item");
        }

        size--;
        Object item = items[dequeueSize];
        items[dequeueSize++] = null;
        return item;
    }

    public Object peek() {
        if(size == 0){
            throw new RuntimeException("Queue doesn't have any item");
        }

        return items[0];
    }

    public int size() {
        return this.size;
    }

    public static void main(String[] args) {
        ArrayBasedQueue arrayBasedQueue = new ArrayBasedQueue();
        int CAPACITY = 10;

        IntStream.range(0, CAPACITY).forEach(idx -> {
            arrayBasedQueue.enqueue(idx);
        });

        IntStream.range(0, CAPACITY).forEach(idx -> {
            arrayBasedQueue.enqueue(idx);
        });

        System.out.println(arrayBasedQueue.peek());

        while(arrayBasedQueue.size() != 0){
            System.out.println(arrayBasedQueue.dequeue());
        }
    }
}
