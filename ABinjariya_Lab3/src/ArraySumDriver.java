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
public class ArraySumDriver {
    private final static int ARRAY_SIZE = 6;

    public static void main(String[] args) {
        int index = 0;

        Integer[] myArray = new Integer[ARRAY_SIZE];
        ArraySum arraySum = new ArraySum();

        myArray[index++] = 3;
        myArray[index++] = 5;
        myArray[index++] = 2;
        myArray[index++] = 6;

        int sum = arraySum.sumOfArray(myArray, 3);
        System.out.println(sum); // Expected output: 16

        myArray[index++] = 7;
        myArray[index++] = 1;

        sum = arraySum.sumOfArray(myArray, 5);
        System.out.println(sum); // Expected output: 24
    }
}
