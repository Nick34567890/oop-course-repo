package oop.Lab3.Task1QueueClasses;

public class CircularQueue<T> implements IQueue<T> {
    // Attributes
    private T[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    // Constructor
    public CircularQueue(int capacity) {
        this.capacity = capacity;
        queue = (T[]) new Object[capacity];  // Create an array of generic type T
        front = 0;
        rear = -1;
        size = 0;
    }

    // Dequeue operation: removes and returns the front element
    public T dequeue() {
        if (size == 0) {
            return null;  // Return null if the queue is empty
        }
        T element = queue[front];
        front = (front + 1) % capacity;  // Move front to the next position (circular)
        size--;
        return element;
    }

    // Enqueue operation: adds an element to the rear of the queue
    public void enqueue(T t) {
        if (size == capacity) {
            throw new IllegalStateException("Queue is full.");  // Throw exception if queue is full
        }
        rear = (rear + 1) % capacity;  // Move rear to the next position (circular)
        queue[rear] = t;
        size++;
    }

    // Peek operation: returns the front element without removing it
    public T peek() {
        if (size == 0) {
            return null;  // Return null if the queue is empty
        }
        return queue[front];
    }

    // Size operation: returns the number of elements in the queue
    public int size() {
        return size;
    }
}
