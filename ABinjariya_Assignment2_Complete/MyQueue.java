/*
 * Class: CMSC204
 * Instructor: Prof. Khandan Monshi
 * Description: (Give a brief description for each Class)
 * Due: 2/27/2025
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Aditya Raj Binjariya 
*/
import java.util.ArrayList;

public class MyQueue<T> implements QueueInterface<T> {
    private T[] queue;
    private int size, front, rear;
    
    @SuppressWarnings("unchecked")
    public MyQueue(int capacity) {
        queue = (T[]) new Object[capacity];
        size = 0;
        front = 0;
        rear = 0;
    }

    public MyQueue() {
        this(50);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == queue.length;
    }

    @Override
    public T dequeue() throws QueueUnderflowException {
        if (isEmpty()) throw new QueueUnderflowException();
        T element = queue[front];
        front = (front + 1) % queue.length;
        size--;
        return element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean enqueue(T e) throws QueueOverflowException {
        if (isFull()) throw new QueueOverflowException();
        queue[rear] = e;
        rear = (rear + 1) % queue.length;
        size++;
        return true;
    }

    @Override
    public String toString() {
        return toString("");
    }

    @Override
    public String toString(String delimiter) {
        StringBuilder sb = new StringBuilder();
        int index = front;
        for (int i = 0; i < size; i++) {
            sb.append(queue[index]);
            if (i < size - 1) sb.append(delimiter);
            index = (index + 1) % queue.length;
        }
        return sb.toString();
    }

    @Override
    public void fill(ArrayList<T> list) {
        for (T item : list) {
            try {
                enqueue(item);
            } catch (QueueOverflowException e) {
                break;
            }
        }
    }
}
