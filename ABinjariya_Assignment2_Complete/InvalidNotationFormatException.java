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
 * Exception class for handling invalid notation format errors.
 */
public class InvalidNotationFormatException extends RuntimeException {

    /**
     * Constructs an exception with a custom error message.
     *
     * @param message The custom message explaining the error.
     */
    public InvalidNotationFormatException(String message) {
        super(message);
    }

    /**
     * Constructs an exception with a default error message.
     */
    public InvalidNotationFormatException() {
        super("Invalid notation format detected.");
    }
}
