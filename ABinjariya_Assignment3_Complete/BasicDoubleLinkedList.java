/*
 * Class: CMSC204
 * Instructor: Prof. Khandan Monshi
 * Description: (Give a brief description for each Class)
 * Due: 03/14/2025
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Aditya Raj Binjariya 
*/
import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * A generic doubly linked list implementation that supports iteration.
 * Implements Iterable<T> and provides basic list operations.
 * @param <T> The type of elements stored in the list.
 * @author [Your Name]
 */
public class BasicDoubleLinkedList<T> implements Iterable<T> {

    protected Node head, tail;
    protected int size;

    /**
     * Initializes an empty doubly linked list.
     */
    public BasicDoubleLinkedList() {
        head = tail = null;
        size = 0;
    }

    /**
     * Adds an element to the front of the list.
     * @param data The data to be added.
     */
    public void addToFront(T data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    /**
     * Adds an element to the end of the list.
     * @param data The data to be added.
     */
    public void addToEnd(T data) {
        Node newNode = new Node(data);
        if (tail == null) {
            addToFront(data);
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            size++;
        }
    }

    /**
     * Retrieves, without removing, the first element in the list.
     * @return The first element, or null if the list is empty.
     */
    public T getFirst() {
        return (head != null) ? head.data : null;
    }

    /**
     * Retrieves, without removing, the last element in the list.
     * @return The last element, or null if the list is empty.
     */
    public T getLast() {
        return (tail != null) ? tail.data : null;
    }

    /**
     * Gets the number of elements in the list.
     * @return The current size of the list.
     */
    public int getSize() {
        return size;
    }

    /**
     * Removes a specified node from the list.
     * @param node The node to be removed.
     */
    protected void removeNode(Node node) {
        if (node == head) head = node.next;
        if (node == tail) tail = node.prev;
        if (node.next != null) node.next.prev = node.prev;
        if (node.prev != null) node.prev.next = node.next;
        size--;
    }

    /**
     * Removes the first occurrence of a given element.
     * @param targetData The element to be removed.
     * @param comparator Comparator to determine equality.
     * @return The removed node or null if not found.
     */
    public Node remove(T targetData, Comparator<T> comparator) {
        Node current = head;
        while (current != null) {
            if (comparator.compare(current.data, targetData) == 0) {
                removeNode(current);
                return current;
            }
            current = current.next;
        }
        return null;
    }

    /**
     * Removes and returns the first element in the list.
     * @return The removed first element, or null if the list is empty.
     */
    public T retrieveFirstElement() {
        if (head == null) return null;
        T temp = head.data;
        removeNode(head);
        return temp;
    }

    /**
     * Removes and returns the last element in the list.
     * @return The removed last element, or null if the list is empty.
     */
    public T retrieveLastElement() {
        if (tail == null) return null;
        T temp = tail.data;
        removeNode(tail);
        return temp;
    }

    /**
     * Converts the linked list to an ArrayList.
     * @return An ArrayList containing all elements in order.
     */
    public ArrayList<T> toArrayList() {
        ArrayList<T> list = new ArrayList<>();
        Node current = head;
        while (current != null) {
            list.add(current.data);
            current = current.next;
        }
        return list;
    }

    /**
     * Returns a list iterator for the doubly linked list.
     * @return A ListIterator over elements.
     */
    @Override
    public ListIterator<T> iterator() {
        return new DoubleLinkedListIterator();
    }

    /**
     * Inner class representing a node in the doubly linked list.
     */
    protected class Node {
        T data;
        Node prev, next;

        Node(T item) {
            data = item;
            prev = next = null;
        }
    }

    /**
     * Inner class implementing a list iterator for traversal.
     */
    protected class DoubleLinkedListIterator implements ListIterator<T> {
        private Node current;

        public DoubleLinkedListIterator() {
            current = head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            T value = current.data;
            current = current.next;
            return value;
        }

        @Override
        public boolean hasPrevious() {
            // If current is null (end of list), check if tail exists
            return (current == null && tail != null) || (current != null && current.prev != null);
        }

        @Override
        public T previous() {
            if (!hasPrevious()) throw new NoSuchElementException();
            
            // If current is null, move it back to the last node (tail)
            if (current == null) {
                current = tail;
            } else {
                current = current.prev;
            }

            return current.data;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void set(T e) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void add(T e) {
            throw new UnsupportedOperationException();
        }

        @Override
        public int nextIndex() {
            throw new UnsupportedOperationException();
        }

        @Override
        public int previousIndex() {
            throw new UnsupportedOperationException();
        }
    }

}
