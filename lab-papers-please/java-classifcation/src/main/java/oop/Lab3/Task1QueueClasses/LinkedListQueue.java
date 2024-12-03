package oop.Lab3.Task1QueueClasses;

public class LinkedListQueue<T> implements IQueue<T> {
    // Nested class Node, represents a single element in the list
    private class Node {
        T data;
        Node next;

        public Node(T newData) {
            data = newData;
            next = null;
        }
    }

    // Attributes
    private Node front;  // Start of the queue
    private Node rear;   // End of the queue
    private int size;

    // Constructor
    public LinkedListQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    // Dequeue operation: removes and returns the front element
    public T dequeue() {
        // The queue is empty
        if (front == null) {
            return null;  // Return null if the queue is empty
        }

        T data = front.data;
        front = front.next;

        // If the queue is now empty, set rear to null
        if (front == null) {
            rear = null;
        }
        size--;
        return data;
    }

    // Enqueue operation: adds an element to the rear of the queue
    public void enqueue(T t) {
        Node newNode = new Node(t);
        if (rear == null) {
            front = newNode;  // The queue was empty, so front points to the new node
            rear = newNode;   // The rear also points to the new node
        } else {
            rear.next = newNode;  // Linking the last node to the newly added one
            rear = newNode;       // Updating the rear to point to the new last node
        }
        size++;
    }

    // Peek operation: returns the front element without removing it
    public T peek() {
        if (front == null) {
            return null;  // Return null if the queue is empty
        }
        return front.data;
    }

    // Size operation: returns the number of elements in the queue
    public int size() {
        return size;
    }
}

