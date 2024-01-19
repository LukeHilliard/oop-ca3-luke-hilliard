import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.Stack;

public class Question2 {

    /**
     *
     * In a paint program, a “flood fill” fills all empty pixels of a drawing with a given colour,
     * stopping when it reaches occupied pixels. In this exercise, you will implement a simple
     * variation of this algorithm, flood-filling a 10 × 10 array of integers that are initially 0.
     * Prompt for the starting row and column (the starting cell for the flood fill).
     *
     * • Push the (row, column) pair onto a stack. You will need to provide a simple Pair class
     *   (storing row and column).
     * • Repeat the following operations until the stack is empty.
     *    1) Pop off the (row, column) pair from the top of the stack.
     *    2) If it has not yet been filled, fill the corresponding cell location with a number
     *         1, 2, 3, and so on (this number is incremented at each step to show
     *         the order in which the square is filled).
     *    3) Push the coordinates of any unfilled neighbours in the north, east, south, or
     *         west direction on the stack.
     * • When you are done (i.e stack is empty), print the entire 2D array.
     */
    public static void main(String[] args) {

        // initialize 10x10 2D array
        int[][] pixels = new int[10][10];

        // fill 2D array with 0's to indicate they are not filled
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++ ) {
                pixels[i][j] = 0;
            }
        }

        Scanner kb = new Scanner(System.in);

        System.out.println("\nFlood Fill App\n\n");
        displayPixels(pixels);

        int row, column;
        System.out.println("Please specify the starting point for the flood-fill operation to commence.\n");
        System.out.print("Row: ");
        while(!kb.hasNextInt()) { // Input handling
            System.out.println("Invalid entry. Enter points from the 10x10 grid.");
            kb.next();
        }
        row = kb.nextInt();

        System.out.print("Column: ");
        while(!kb.hasNextInt()) { // Input handling
            System.out.println("Invalid entry. Enter points from the 10x10 grid.");
            kb.next();
        }
        column = kb.nextInt();


        Pair startingPoint = new Pair(row, column);
        Stack<Pair> pointStack = new Stack<>();

    }


    public static void displayPixels(int[][] pixels) {

        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++ ) {
                System.out.print("|" + pixels[i][j] + "|");
            }
            System.out.println("\n"); // skip to next line after full row(i) has been printed
        }
    }

}