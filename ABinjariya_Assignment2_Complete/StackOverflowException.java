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
 * Exception class to indicate that a stack has reached its maximum capacity.
 */
public class StackOverflowException extends RuntimeException {

    /**
     * Constructs an exception with a user-defined error message.
     *
     * @param message The custom error message describing the error.
     */
    public StackOverflowException(String message) {
        super(message);
    }

    /**
     * Constructs an exception with a default error message.
     */
    public StackOverflowException() {
        super("The stack has reached its capacity limit.");
    }
}
