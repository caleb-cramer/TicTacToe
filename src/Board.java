import java.util.Scanner;
public class Board {
    private int dim;
    private Cell[][] board;
    Scanner scan =new Scanner(System.in);

    public Board() {
        this.dim = 0;
        this.board = new Cell[0][0];
    }

    public Board(int dim) {
        this.dim = dim;
        this.board = new Cell[dim][dim];
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                board[i][j]=new Cell(new Coordinates(dim,dim), "-");
            }
        }
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

    @Override
    public String toString() {
        String returnBoard = " ";

        for (int i = 0; i < dim; i++) {
            returnBoard=returnBoard+" " +Integer.toString(i);
        }
        returnBoard+="\n";
        for (int i = 0; i < dim; i++) {
            returnBoard+= Integer.toString(i);
            for (int j = 1; j < dim+1; j++) {
                returnBoard = returnBoard + " " + board[i][j-1].toString();
            }
            returnBoard+="\n";
        }
        return returnBoard;
    }

    public void playGame(){
        System.out.println("Welcome to Tic Tac Toe! There are two players, player 'X' and player 'O'... \n");
        System.out.println("Please enter the dimension, N, of the NxN Tic Tac Toe board (an integer in [3, 9]): ");
        String userDim = scan.nextLine();
        Board game = new Board((Integer.parseInt(userDim)));
        System.out.println("Player \"X\" is going first \n"+game);
    }
}
