/*
 * Class: CMSC204
 * Instructor: Prof. Khandan Monshi
 * Description: (Give a brief description for each Class)
 * Due: 03/04/2025
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Aditya Raj Binjariya 
*/
public class ArraySum {
    public int sumOfArray(Integer[] a, int index) {
        // Base case: if index is less than 0, return 0
        if (index < 0) {
            return 0;
        }
        // Recursive case: add current element to the sum of previous elements
        return a[index] + sumOfArray(a, index - 1);
    }
}
