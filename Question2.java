import java.sql.SQLOutput;
import java.util.Scanner;

public class Question2 {
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
        int row, column;
        System.out.println("\nFlood Fill App\n\n");
        displayPixels(pixels);


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