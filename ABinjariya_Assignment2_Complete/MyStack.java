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

public class MyStack<T> implements StackInterface<T> {
    private T[] stack;
    private int top;
    
    @SuppressWarnings("unchecked")
    public MyStack(int capacity) {
        stack = (T[]) new Object[capacity];
        top = -1;
    }

    public MyStack() {
        this(50);
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public boolean isFull() {
        return top == stack.length - 1;
    }

    @Override
    public T pop() throws StackUnderflowException {
        if (isEmpty()) throw new StackUnderflowException();
        return stack[top--];
    }

    @Override
    public T top() throws StackUnderflowException {
        if (isEmpty()) throw new StackUnderflowException();
        return stack[top];
    }

    @Override
    public int size() {
        return top + 1;
    }

    @Override
    public boolean push(T e) throws StackOverflowException {
        if (isFull()) throw new StackOverflowException();
        stack[++top] = e;
        return true;
    }

    @Override
    public String toString() {
        return toString("");
    }

    @Override
    public String toString(String delimiter) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= top; i++) {
            sb.append(stack[i]);
            if (i < top) sb.append(delimiter);
        }
        return sb.toString();
    }

    @Override
    public void fill(ArrayList<T> list) {
        for (T item : list) {
            try {
                push(item);
            } catch (StackOverflowException e) {
                break;
            }
        }
    }
}
