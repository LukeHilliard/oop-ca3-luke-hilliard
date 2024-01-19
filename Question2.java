public class Question2 {
    public static void main(String[] args) {

        // initialize 10x10 2D array
        int[][] tempName = new int[10][10];

        // fill 2D array with 0's to indicate they are not filled
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++ ) {
                tempName[i][j] = 0;
            }
        }

        for(int l = 0; l < 10; l++) {
            for(int m = 0; m < 10; m++ ) {
                System.out.println(tempName[l][m]);
            }
        }
    }

}