public class Pair {

    public int row;
    public int column;

    public Pair(int row, int column) {
        this.row = row;
        this.column = column;
    }

    @Override
    public String toString() {
        return "|Row: " + this.row + "||Column: " + this.column + "|";
    }
}
