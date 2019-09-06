import java.util.Arrays;

public class Board {
    private int dim = 0;
    private Cell [][] board = new Cell[dim][dim];

    public Board(int dim) {
        this.dim = dim;
    }

    public int getDim() {
        return dim;
    }

    public void setDim(int dim) {
        this.dim = dim;
    }

    public Cell[][] getBoard() {
        return board;
    }

    public void setBoard(Cell[][] board) {
        this.board = board;
    }
}
