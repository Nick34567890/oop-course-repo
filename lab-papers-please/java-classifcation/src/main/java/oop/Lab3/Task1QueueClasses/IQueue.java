package oop.Lab3.Task1QueueClasses;

public interface IQueue<T> {
    void enqueue(T t);   // Adds an element to the queue
    T dequeue();         // Removes and returns the front element from the queue
    T peek();            // Returns the front element without removing it
    int size();          // Returns the number of elements in the queue
}

