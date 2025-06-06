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
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class MorseCodeConverterTestPublic {
	
	@Test
	public void testConvertToEnglishString() {	
		String converter1 = MorseCodeConverter.convertToEnglish(".... . .-.. .-.. --- / .-- --- .-. .-.. -.. ");
		assertEquals("hello world",converter1);
	}
	
	/**
	 * Testing for correct implementation of tree and traversal
	 */
	
	@Test
	public void testPrintTree() {	
		
		assertEquals("h s v i f u e l r a p w j  b d x n c k y t z g q m o", MorseCodeConverter.printTree());
	}
	
	/**
	 * Testing for correct conversion of all characters using key phrase to hit all letters
	 */
	
	@Test
	public void testConvertMorseStringToEnglishString() {	
		
		String converter1 = MorseCodeConverter.convertToEnglish("- .... . / --.- ..- .. -.-. -.- / -... .-. --- .-- -. / ..-. --- -..- / .--- ..- -- .--. ... / --- ...- . .-. / - .... . / .-.. .- --.. -.-- / -.. --- --.");
		assertEquals("the quick brown fox jumps over the lazy dog", converter1);

	}
	@Test
	public void testConvertMorseFileToEnglishString() {	
		
		/*Make sure howDoILoveThee.txt is in the src directory for this 
		  test to pass
		*/
		File file = new File("src/howDoILoveThee.txt"); 
		try {
			assertEquals("how do i love thee let me count the ways", MorseCodeConverter.convertToEnglish(file));
		} catch (FileNotFoundException e) {
			assertTrue("An unwanted exception was caught", false);
		}
	}
	
	/**
	 * STUDENT test for the MorseCodeConverter.convertToEnglish(String)
	 * @param code the morse code
	 */
	
	@Test
    public void testConvertToEnglishFromString() {
        String morse = "... --- ... / .... . .-.. .--.";
        String expected = "sos help";
        String actual = MorseCodeConverter.convertToEnglish(morse);
        assertEquals(expected, actual);
    }

	/**
	 * STUDENT test for the MorseCodeConverter.convertToEnglish(File)
	 * @param codeFile the morse code file
	 */
	@Test
    public void testConvertToEnglishFromFile() throws FileNotFoundException {
        File file = new File("src/LoveLooksNot.txt");
        String expected = "love looks not with the eyes but with the mind";
        String actual = MorseCodeConverter.convertToEnglish(file);
        assertEquals(expected, actual);
    }
	

}
