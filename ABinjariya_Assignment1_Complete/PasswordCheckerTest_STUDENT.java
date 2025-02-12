/*
 * Class: CMSC204
 * Instructor: Prof. Khandan Monshi
 * Description: (Give a brief description for each Class)
 * Due: 2/11/2025
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Aditya Raj Binjariya 
*/
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class PasswordCheckerTest_STUDENT {
    
    private ArrayList<String> passwords;

    @Before
    public void setUp() throws Exception {
        passwords = new ArrayList<>();
        passwords.add("Valid1@");  // Valid password
        passwords.add("short");    // Too short
        passwords.add("noupper1@");  // No uppercase
        passwords.add("NOLOWER1@");  // No lowercase
        passwords.add("NoDigit@");   // No digit
        passwords.add("NoSpecial1"); // No special character
        passwords.add("AAA111@aaa"); // More than two repeating characters
    }

    @After
    public void tearDown() throws Exception {
        passwords = null;
    }

    @Test
    public void testIsValidPasswordTooShort() {
        try {
            PasswordCheckerUtility.isValidPassword("abc");
            fail("Expected LengthException");
        } catch (LengthException e) {
            assertEquals("The password must be at least 6 characters long", e.getMessage());
        } catch (Exception e) {
            fail("Unexpected exception thrown.");
        }
    }

    @Test
    public void testIsValidPasswordNoUpperAlpha() {
        try {
            PasswordCheckerUtility.isValidPassword("abc123@");
            fail("Expected NoUpperAlphaException");
        } catch (NoUpperAlphaException e) {
            assertEquals("The password must contain at least one uppercase alphabetic character", e.getMessage());
        } catch (Exception e) {
            fail("Unexpected exception thrown.");
        }
    }

    @Test
    public void testIsValidPasswordNoLowerAlpha() {
        try {
            PasswordCheckerUtility.isValidPassword("ABC123@");
            fail("Expected NoLowerAlphaException");
        } catch (NoLowerAlphaException e) {
            assertEquals("The password must contain at least one lowercase alphabetic character", e.getMessage());
        } catch (Exception e) {
            fail("Unexpected exception thrown.");
        }
    }

    @Test
    public void testIsValidPasswordNoDigit() {
        try {
            PasswordCheckerUtility.isValidPassword("AbcDef@");
            fail("Expected NoDigitException");
        } catch (NoDigitException e) {
            assertEquals("The password must contain at least one digit", e.getMessage());
        } catch (Exception e) {
            fail("Unexpected exception thrown.");
        }
    }

    @Test
    public void testIsValidPasswordNoSpecialChar() {
        try {
            PasswordCheckerUtility.isValidPassword("Abc123");
            fail("Expected NoSpecialCharacterException");
        } catch (NoSpecialCharacterException e) {
            assertEquals("The password must contain at least one special character", e.getMessage());
        } catch (Exception e) {
            fail("Unexpected exception thrown.");
        }
    }

    @Test
    public void testIsValidPasswordInvalidSequence() {
        try {
            PasswordCheckerUtility.isValidPassword("AAA111@aaa");
            fail("Expected InvalidSequenceException");
        } catch (InvalidSequenceException e) {
            assertEquals("The password cannot contain more than two of the same character in sequence.", e.getMessage());
        } catch (Exception e) {
            fail("Unexpected exception thrown.");
        }
    }

    @Test
    public void testIsValidPasswordSuccessful() {
        try {
            assertTrue(PasswordCheckerUtility.isValidPassword("Valid1@"));
        } catch (Exception e) {
            fail("Unexpected exception thrown.");
        }
    }

    @Test
    public void testIsWeakPassword() {
        try {
            boolean weakPassword = PasswordCheckerUtility.isWeakPassword("Weak1@");
            fail("Expected WeakPasswordException");
        } catch (WeakPasswordException e) {
            assertEquals("The password is OK but weak - it contains fewer than 10 characters.", e.getMessage());
        } catch (Exception e) {
            fail("Unexpected exception thrown.");
        }
    }

    @Test
    public void testGetInvalidPasswords() {
        ArrayList<String> results = PasswordCheckerUtility.getInvalidPasswords(passwords);
        assertEquals(6, results.size()); // Expecting 6 invalid passwords
        assertTrue(results.get(0).contains("The password must be at least 6 characters long"));
        assertTrue(results.get(1).contains("The password must contain at least one uppercase alphabetic character"));
        assertTrue(results.get(2).contains("The password must contain at least one lowercase alphabetic character"));
        assertTrue(results.get(3).contains("The password must contain at least one digit"));
        assertTrue(results.get(4).contains("The password must contain at least one special character"));
        assertTrue(results.get(5).contains("The password cannot contain more than two of the same character in sequence."));
    }
}


