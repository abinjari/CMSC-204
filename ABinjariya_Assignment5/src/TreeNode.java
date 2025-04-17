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
public class TreeNode<T> {
    protected T data;
    protected TreeNode<T> left;
    protected TreeNode<T> right;

    public TreeNode(T dataNode) {
        data = dataNode;
        left = null;
        right = null;
    }

    public TreeNode(TreeNode<T> node) {
        data = node.data;
        left = node.left;
        right = node.right;
    }

    public T getData() {
        return data;
    }
}
