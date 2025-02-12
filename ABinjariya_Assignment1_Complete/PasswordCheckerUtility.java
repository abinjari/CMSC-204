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
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordCheckerUtility {

    public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException {
        if (!password.equals(passwordConfirm)) {
            throw new UnmatchedException("Passwords do not match");
        }
    }

    public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
        return password.equals(passwordConfirm);
    }

    public static boolean isValidLength(String password) throws LengthException {
        if (password.length() < 6) {
            throw new LengthException("The password must be at least 6 characters long");
        }
        return true;
    }

    public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException {
        if (!password.matches(".*[A-Z].*")) {
            throw new NoUpperAlphaException("The password must contain at least one uppercase alphabetic character");
        }
        return true;
    }

    public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException {
        if (!password.matches(".*[a-z].*")) {
            throw new NoLowerAlphaException("The password must contain at least one lowercase alphabetic character");
        }
        return true;
    }

    public static boolean hasDigit(String password) throws NoDigitException {
        if (!password.matches(".*\\d.*")) {
            throw new NoDigitException("The password must contain at least one digit");
        }
        return true;
    }

    public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
        Matcher matcher = pattern.matcher(password);
        if (!matcher.matches()) {
            return true;
        }
        throw new NoSpecialCharacterException("The password must contain at least one special character");
    }

    public static boolean NoSameCharInSequence(String password) throws InvalidSequenceException {
        for (int i = 0; i < password.length() - 2; i++) {
            if (password.charAt(i) == password.charAt(i + 1) && password.charAt(i) == password.charAt(i + 2)) {
                throw new InvalidSequenceException("The password cannot contain more than two of the same character in sequence.");
            }
        }
        return true;
    }

    public static boolean isValidPassword(String password) throws LengthException, NoUpperAlphaException, NoLowerAlphaException,
            NoDigitException, NoSpecialCharacterException, InvalidSequenceException {
        return isValidLength(password) && hasUpperAlpha(password) && hasLowerAlpha(password) &&
               hasDigit(password) && hasSpecialChar(password) && NoSameCharInSequence(password);
    }

    public static boolean hasBetweenSixAndNineChars(String password) {
        return password.length() >= 6 && password.length() <= 9;
    }

    public static boolean isWeakPassword(String password) throws WeakPasswordException {
        try {
            if (isValidPassword(password) && hasBetweenSixAndNineChars(password)) {
                throw new WeakPasswordException("The password is OK but weak - it contains fewer than 10 characters.");
            }
        } catch (LengthException | NoUpperAlphaException | NoLowerAlphaException | 
                 NoDigitException | NoSpecialCharacterException | InvalidSequenceException e) {
            return false;  // If it's invalid, it's not weak, just invalid
        }
        return false;
    }


    public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {
        ArrayList<String> invalidPasswords = new ArrayList<>();
        for (String password : passwords) {
            try {
                isValidPassword(password);
            } catch (Exception e) {
                invalidPasswords.add(password + " " + e.getMessage());
            }
        }
        return invalidPasswords;
    }
}
