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
 * Exception class to indicate that a stack operation was attempted on an empty stack.
 */
public class StackUnderflowException extends RuntimeException {

    /**
     * Constructs an exception with a user-defined error message.
     *
     * @param message The custom error message describing the error.
     */
    public StackUnderflowException(String message) {
        super(message);
    }

    /**
     * Constructs an exception with a default error message.
     */
    public StackUnderflowException() {
        super("Stack is currently empty, operation cannot be performed.");
    }
}
