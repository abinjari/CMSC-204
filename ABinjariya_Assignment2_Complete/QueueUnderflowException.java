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
/**
 * Exception class to indicate that a queue operation was attempted on an empty queue.
 */
public class QueueUnderflowException extends RuntimeException {

    /**
     * Default constructor that provides a predefined error message.
     */
    public QueueUnderflowException() {
        super("Queue is currently empty, operation cannot be performed.");
    }

    /**
     * Constructor that allows a custom error message to be specified.
     *
     * @param message The custom error message.
     */
    public QueueUnderflowException(String message) {
        super(message);
    }
}
