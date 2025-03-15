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
import java.util.Comparator;

/**
 * A sorted doubly linked list that extends BasicDoubleLinkedList.
 * Elements are inserted in sorted order based on the provided Comparator.
 * @param <T> The type of data stored in the list.
 * @author [Your Name]
 */
public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {

    private Comparator<T> sortingComparator;

    /**
     * Constructs an empty sorted doubly linked list with the specified comparator.
     * @param comparator Comparator used to maintain sorted order.
     */
    public SortedDoubleLinkedList(Comparator<T> comparator) {
        this.sortingComparator = comparator;
    }

    /**
     * Inserts an element while maintaining the sorted order of the list.
     * @param element The data to be added.
     */
    public void add(T element) {
        Node newNode = new Node(element);
        size++;

        if (head == null) { 
            head = tail = newNode;
            return;
        }

        Node current = head;
        while (current != null) {
            if (sortingComparator.compare(current.data, element) >= 0) {
                if (current.prev == null) { 
                    head = newNode;
                    newNode.next = current;
                    current.prev = newNode;
                } else { 
                    newNode.prev = current.prev;
                    current.prev.next = newNode;
                    current.prev = newNode;
                    newNode.next = current;
                }
                return;
            }
            current = current.next;
        }

        // If no position found, add to the end
        if (current == null) {
            current = tail;
        }
        current.next = newNode;
        newNode.prev = current;
        tail = newNode;
    }

    /**
     * Removes the first occurrence of a specified element using the provided comparator.
     * @param targetData The element to be removed.
     * @param comparator Comparator to determine equality.
     * @return The removed node or null if not found.
     */
    @Override
    public Node remove(T targetData, Comparator<T> comparator) {
        if (head == null) {
            return null;
        }

        Node current = head;
        while (current != null) {
            int comparison = comparator.compare(current.data, targetData);
            if (comparison == 0) {
                removeNode(current);
                return current;
            } else if (comparison > 0) {
                return null; // If the list is sorted and we encounter a larger value, the item is not in the list.
            }
            current = current.next;
        }
        return null;
    }

    /**
     * This operation is not supported in a sorted list.
     * @param data The element to add.
     * @throws UnsupportedOperationException Always thrown.
     */
    @Override
    public void addToFront(T data) {
        throw new UnsupportedOperationException("Invalid operation for sorted list");
    }
    /**
     * This operation is not supported in a sorted list.
     * @param data The element to add.
     * @throws UnsupportedOperationException Always thrown.
     */
    @Override
    public void addToEnd(T data) {
        throw new UnsupportedOperationException("Invalid operation for sorted list");
    }
}
