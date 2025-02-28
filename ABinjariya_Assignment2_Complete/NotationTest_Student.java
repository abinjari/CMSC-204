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
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NotationTest_Student {
    
    private String infixExpression;
    private String postfixExpression;
    private String invalidInfixExpression;
    private String invalidPostfixExpression;
    
    @BeforeEach
    void setUp() {
        // Valid expressions
        infixExpression = "(3+(((5*7)-(((8/2)-1)*4))*6))";
        postfixExpression = "357*82/1-4*-6*+";

        // Invalid expressions
        invalidInfixExpression = "(3+5)*4)-2";  // Missing opening parenthesis
        invalidPostfixExpression = "354+*-";     // Incorrect operator usage
    }

    @Test
    void testConvertInfixToPostfix() {
        try {
            assertEquals(postfixExpression, Notation.convertInfixToPostfix(infixExpression));
        } catch (InvalidNotationFormatException e) {
            fail("Exception should not have been thrown for valid infix expression.");
        }
    }

    @Test
    void testConvertPostfixToInfix() {
        try {
            assertEquals(infixExpression, Notation.convertPostfixToInfix(postfixExpression));
        } catch (InvalidNotationFormatException e) {
            fail("Exception should not have been thrown for valid postfix expression.");
        }
    }

    @Test
    void testEvaluatePostfixExpression() {
        try {
            assertEquals(141.0, Notation.evaluatePostfixExpression(postfixExpression), 0.001);
        } catch (InvalidNotationFormatException e) {
            fail("Exception should not have been thrown for valid postfix expression.");
        }
    }

    @Test
    void testInvalidInfixExpression() {
        assertThrows(InvalidNotationFormatException.class, () -> Notation.convertInfixToPostfix(invalidInfixExpression));
    }

    @Test
    void testInvalidPostfixExpression() {
        assertThrows(InvalidNotationFormatException.class, () -> Notation.convertPostfixToInfix(invalidPostfixExpression));
    }

    @Test
    void testInvalidPostfixEvaluation() {
        assertThrows(InvalidNotationFormatException.class, () -> Notation.evaluatePostfixExpression(invalidPostfixExpression));
    }
}
