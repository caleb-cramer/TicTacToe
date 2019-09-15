import java.util.Scanner;
public class Board {
    private int dim;
    private Cell[][] board;
    private Scanner scan =new Scanner(System.in);

    public Board() {
        this.dim = 0;
        this.board = new Cell[0][0];
    }

    public Board(int dim) {
        this.dim = dim;
        this.board = new Cell[dim][dim];
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                this.board[i][j]=new Cell(new Coordinates(i,j), "-");
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

    public boolean isValidMove(Coordinates coordinates){
        return (board[coordinates.getRow()][coordinates.getColumn()].getSymbol()=="-");
    }

    public void makeMove(Coordinates coordinates, String playerSymbol){
        if(isValidMove(coordinates)){
            board[coordinates.getRow()][coordinates.getColumn()].setSymbol(playerSymbol);
        }
    }

    /*public boolean isWinner(String playerSymbol){
        for (int i = 0; i < dim; i++) {
            if (board[i][i].getSymbol()==playerSymbol){
                return true;}
            for (int j = 0; j < dim; j++) {
                if (board[i][j].getSymbol() == playerSymbol) {
                    return true;
                } else if (board[j][i].getSymbol() == playerSymbol) {
                    return true;
                }
            }
        }
        return false;
    }*/

    public void playGame(){
        boolean play = true;
        System.out.println("Player \"X\" is going first \n"+toString());
        while(play){
            System.out.print("Player X, please enter the coordinates of your placement: ");
            int colX = scan.nextInt();
            int rowX = scan.nextInt();
            Coordinates guessX = new Coordinates(rowX, colX);
            makeMove(guessX,"X");
            System.out.println(toString());
            /*if(isWinner("X")){
                break;
                //play=false;
            }*/
            System.out.print("Player O, please enter the coordinates of your placement: ");
            int colO = scan.nextInt();
            int rowO = scan.nextInt();
            Coordinates guess = new Coordinates(rowO, colO);
            makeMove(guess,"O");
            System.out.println(toString());
            //play=false;
        }
    }
}
