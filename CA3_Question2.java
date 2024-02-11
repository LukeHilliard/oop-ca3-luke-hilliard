import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.Stack;

/**
 *  Name:
 *  Class Group:
 */
public class CA3_Question2
{
    /*
        Starter function to create the 2D array and populate it with 0

     */
    public static int[][]  floodFillStart() {
        int[][] arr = new int[10][10];
        for (int x = 0; x < 10; x++)
        {
            for (int y = 0; y < 10; y++)
            {
                arr[x][y] = 0;
            }
        }
        return arr;
    }

    /*
        Helper function to display the image
     */
    public static void display(int[][] arr)
    {
        for (int x = 0; x < 10; x++)
        {
            for (int y = 0; y < 10; y++)
            {
                System.out.printf("%4d", arr[x][y]);
            }
            System.out.println();
        }
    }
    private static void fill(int r, int c, int[][] arr)
    {
        Stack<Pair> stack = new Stack<>();
        Pair startingPair = new Pair(r, c);
        boolean[][] filled = new boolean[10][10]; // keep track of which ones are filled
        int order = 0;
        stack.push(startingPair);
        while(!stack.isEmpty()){
            Pair currentPoint = stack.pop();
            int row = currentPoint.row;
            int col = currentPoint.column;

            if (row >= 0 && row < 10 && col >= 0 && col < 10 && !filled[row][col]) {
                arr[row][col] = order++;
                filled[row][col] = true;

                // Push unfilled neighbors onto the stack
                stack.push(new Pair(row - 1, col)); // North
                stack.push(new Pair(row + 1, col)); // South
                stack.push(new Pair(row, col - 1)); // West
                stack.push(new Pair(row, col + 1)); // East
            }
        }
        display(arr);

    }

    public static void start()
    {
        int[][] arr = floodFillStart();
        Scanner kb = new Scanner(System.in);
        int row, column;
        display(arr);

        System.out.print("Enter starting row: ");
        while(!kb.hasNextInt()){ // validate input
            System.out.println("Invalid input enter a number from 1 -> 10");
            kb.next();
        }
        row = kb.nextInt();
        System.out.print("Enter starting column: ");
        while(!kb.hasNextInt()){ // validate input
            System.out.println("Invalid input enter a number from 1 -> 10");
            kb.next();
        }
        column = kb.nextInt();

        fill(row, column, arr);
    }
    public static void main(String[] args) {
        start();
    }

}
