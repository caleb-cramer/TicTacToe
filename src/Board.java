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
        boolean temp = board[coordinates.getRow()][coordinates.getColumn()].getSymbol()=="-";
        if (!temp){
            System.out.println("That is not a valid move. Try again!");
        }
        return temp;
    }

    public void makeMove(Coordinates coordinates, String playerSymbol){
        if(isValidMove(coordinates)){
            board[coordinates.getRow()][coordinates.getColumn()].setSymbol(playerSymbol);
        }
    }

    public boolean isWinner(Coordinates guess, String playerSymbol){
        for (int i = 0; i < dim; i++) {
            if (board[guess.getRow()][i].getSymbol() != playerSymbol) {
                break;
            }
            if (i == dim - 1) {
                return true;
            }
        }

        for (int j = 0; j < dim; j++) {
            if (board[j][guess.getColumn()].getSymbol() != playerSymbol) {
                break;
            }
            if (j==dim-1) {
                return true;
            }
        }

        if (guess.getColumn()==guess.getRow()){
            for(int k = 0; k < dim; k++){
                if(board[k][k].getSymbol() != playerSymbol)
                    break;
                if(k == dim-1){
                    return true;
                }
            }
        }

        if (guess.getColumn()+guess.getRow()==dim-1){
            for (int l = 0; l < dim; l++) {
                if(board[l][dim-1-l].getSymbol()!= playerSymbol){
                    break;
                }
                if (l==dim-1){
                    return true;
                }
            }
        }

        return false;
    }

    public void playGame(){
        boolean play = true;
        System.out.println("Player \"X\" is going first \n"+toString());
        while(play){
            System.out.print("Player X, please enter the coordinates of your placement: ");
            int colX = scan.nextInt();
            int rowX = scan.nextInt();
            Coordinates guessX = new Coordinates(rowX, colX);
            if (isValidMove(guessX)) {
                makeMove(guessX, "X");
            }
            else{
                makeMove(guessX, "X");
            }
            System.out.println(toString());
            if(isWinner(guessX,"X")){
                System.out.println("Player X won!");
                break;
            }
            System.out.print("Player O, please enter the coordinates of your placement: ");
            int colO = scan.nextInt();
            int rowO = scan.nextInt();
            Coordinates guessO = new Coordinates(rowO, colO);
            if (isValidMove(guessO)) {
                makeMove(guessO, "O");
            }
            else{
                makeMove(guessO, "O");
            }
            System.out.println(toString());
            if(isWinner(guessO,"O")){
                System.out.println("Player O won!");
                play=false;
            }
        }
    }
}
