public class Coordinates {
    private int column=0;
    private int row=0;

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    @Override
    public String toString() {
        return "("+ column + " , " + row + ")";
    }

    public Coordinates(int column, int row) {
        this.column = column;
        this.row = row;
    }
    public Coordinates() {
        this.column = 0;
        this.row = 0;
    }

}
