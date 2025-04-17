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
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * STUDENT TEST CLASS for MorseCodeTree
 */
class MorseCodeTreeTest {

    MorseCodeTree testTree;
    ArrayList<String> testTreeToArrayList;

    @BeforeEach
    void setUp() throws Exception {
        testTree = new MorseCodeTree();
        testTreeToArrayList = new ArrayList<>();
    }

    @AfterEach
    void tearDown() throws Exception {
        testTree = null;
        testTreeToArrayList = null;
    }

    @Test
    public void testAddNode() {
        assertEquals("a", testTree.getRoot().left.right.getData());
        assertEquals("z", testTree.getRoot().right.right.left.left.getData());
        assertEquals("k", testTree.getRoot().right.left.right.getData());
        assertEquals("r", testTree.getRoot().left.right.left.getData());
        assertEquals("o", testTree.getRoot().right.right.right.getData());
    }

    @Test
    public void testFetchNode() {
        assertEquals("d", testTree.fetchNode(testTree.getRoot(), "-.."));
        assertEquals("w", testTree.fetchNode(testTree.getRoot(), ".--"));
        assertEquals("y", testTree.fetchNode(testTree.getRoot(), "-.--"));
        assertEquals("l", testTree.fetchNode(testTree.getRoot(), ".-.."));
        assertEquals("m", testTree.fetchNode(testTree.getRoot(), "--"));
    }

    @Test
    public void testToArrayList() {
        ArrayList<String> expected = new ArrayList<>();
        expected.add("h");
        expected.add("s");
        expected.add("v");
        expected.add("i");
        expected.add("f");
        expected.add("u");
        expected.add("e");
        expected.add("l");
        expected.add("r");
        expected.add("a");
        expected.add("p");
        expected.add("w");
        expected.add("j");
        expected.add("");
        expected.add("b");
        expected.add("d");
        expected.add("x");
        expected.add("n");
        expected.add("c");
        expected.add("k");
        expected.add("y");
        expected.add("t");
        expected.add("z");
        expected.add("g");
        expected.add("q");
        expected.add("m");
        expected.add("o");

        assertEquals(expected, testTree.toArrayList());
    }

    @Test
    public void testLNRoutputTraversal() {
        testTree.LNRoutputTraversal(testTree.getRoot(), testTreeToArrayList);
        assertEquals("[h, s, v, i, f, u, e, l, r, a, p, w, j, , b, d, x, n, c, k, y, t, z, g, q, m, o]",
                testTreeToArrayList.toString());
    }

    @Test
    public void testMorseCodeConverterConvertToEnglish() {
        String morse = "-.-. --- -- .--. ..- - . .-. / ... -.-. .. . -. -.-. . / .. ... / ..-. ..- -.";
        String expected = "computer science is fun";
        assertEquals(expected, MorseCodeConverter.convertToEnglish(morse));
    }
}
