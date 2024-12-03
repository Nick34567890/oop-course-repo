package oop.Lab3.Task1QueueClasses;

import java.util.LinkedList;
import java.util.Queue;


public class SimpleQueue<T> implements IQueue<T> {
    private LinkedList<T> queue = new LinkedList<>();

    // Dequeue operation: removes and returns the front element
    public T dequeue() {
        if (queue.isEmpty()) {
            return null;  // Return null if the queue is empty
        }
        return queue.removeFirst();  // Removes and returns the first element
    }

    // Enqueue operation: adds an element to the rear of the queue
    public void enqueue(T t) {
        queue.addLast(t);
    }

    // Peek operation: returns the front element without removing it
    public T peek() {
        return queue.isEmpty() ? null : queue.getFirst();
    }

    // Size operation: returns the number of elements in the queue
    public int size() {
        return queue.size();
    }
}
