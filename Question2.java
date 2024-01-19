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

        displayPixels(pixels);

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