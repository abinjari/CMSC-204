/*
 * Class: CMSC204
 * Instructor: Prof. Khandan Monshi
 * Description: (Give a brief description for each Class)
 * Due: 04/17/2025
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Aditya Raj Binjariya 
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MorseCodeConverter {
    private static MorseCodeTree tree = new MorseCodeTree();

    public static String convertToEnglish(String code) {
        StringBuilder result = new StringBuilder();
        String[] words = code.trim().split(" / ");
        for (String word : words) {
            String[] letters = word.split(" ");
            for (String letter : letters) {
                result.append(tree.fetch(letter));
            }
            result.append(" ");
        }
        return result.toString().trim();
    }

    public static String convertToEnglish(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        StringBuilder morse = new StringBuilder();
        while (scanner.hasNextLine()) {
            morse.append(scanner.nextLine()).append(" ");
        }
        scanner.close();
        return convertToEnglish(morse.toString().trim());
    }

    public static String printTree() {
        StringBuilder output = new StringBuilder();
        for (String letter : tree.toArrayList()) {
            output.append(letter).append(" ");
        }
        return output.toString().trim();
    }
}
