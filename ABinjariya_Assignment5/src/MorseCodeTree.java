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
import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface<String> {
    private TreeNode<String> root;

    public MorseCodeTree() {
        buildTree();
    }

    @Override
    public void buildTree() {
        root = new TreeNode<>("");
        insert(".", "e");     insert("-", "t");
        insert("..", "i");    insert(".-", "a");    insert("-.", "n");    insert("--", "m");
        insert("...", "s");   insert("..-", "u");   insert(".-.", "r");   insert(".--", "w");
        insert("-..", "d");   insert("-.-", "k");   insert("--.", "g");   insert("---", "o");
        insert("....", "h");  insert("...-", "v");  insert("..-.", "f");
        insert(".-..", "l");  insert(".--.", "p");  insert(".---", "j");
        insert("-...", "b");  insert("-..-", "x");  insert("-.-.", "c");  insert("-.--", "y");
        insert("--..", "z");  insert("--.-", "q");
    }

    @Override
    public void insert(String code, String letter) {
        addNode(root, code, letter);
    }

    @Override
    public void addNode(TreeNode<String> current, String code, String letter) {
        if (code.length() == 1) {
            if (code.equals(".")) current.left = new TreeNode<>(letter);
            else current.right = new TreeNode<>(letter);
            return;
        }

        TreeNode<String> nextNode = code.charAt(0) == '.' ? current.left : current.right;
        if (nextNode == null) {
            nextNode = new TreeNode<>("");
            if (code.charAt(0) == '.') current.left = nextNode;
            else current.right = nextNode;
        }

        addNode(nextNode, code.substring(1), letter);
    }

    @Override
    public String fetch(String code) {
        return fetchNode(root, code);
    }

    @Override
    public String fetchNode(TreeNode<String> current, String code) {
        if (code.length() == 0) return current.data;

        if (code.charAt(0) == '.') return fetchNode(current.left, code.substring(1));
        else return fetchNode(current.right, code.substring(1));
    }

    @Override
    public TreeNode<String> getRoot() {
        return root;
    }

    @Override
    public void setRoot(TreeNode<String> newNode) {
        root = newNode;
    }

    @Override
    public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Delete operation not supported.");
    }

    @Override
    public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Update operation not supported.");
    }

    @Override
    public ArrayList<String> toArrayList() {
        ArrayList<String> list = new ArrayList<>();
        LNRoutputTraversal(root, list);
        return list;
    }

    @Override
    public void LNRoutputTraversal(TreeNode<String> node, ArrayList<String> list) {
        if (node == null) return;
        LNRoutputTraversal(node.left, list);
        list.add(node.data);
        LNRoutputTraversal(node.right, list);
    }
}
