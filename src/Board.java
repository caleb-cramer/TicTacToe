import java.util.Scanner;
//this is the board for the game
public class Board {
    private int dim;
    private Cell[][] board;
    private Scanner scan =new Scanner(System.in);
    //not necessary
    public Board() {
        this.dim = 0;
        this.board = new Cell[0][0];
    }

    //main constructor
    public Board(int dim) {
        this.dim = dim;
        this.board = new Cell[dim][dim];
        //fill the board with "-"
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

    //prints out the current
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

    //checks to see if the spot is filled by another guess
    public boolean isValidMove(Coordinates coordinates){
        boolean temp = board[coordinates.getRow()][coordinates.getColumn()].getSymbol()=="-";
        if (!temp){
            System.out.println("That is not a valid move. Try again!");
        }
        return temp;
    }
    //checks if move is okay and then fills the spot with the correct symbol
    public void makeMove(Coordinates coordinates, String playerSymbol){
        if(isValidMove(coordinates)){
            board[coordinates.getRow()][coordinates.getColumn()].setSymbol(playerSymbol);
        }
    }
    //checks to see if playerSymbol is a winner
    //checks row win, column win, diag win, anti diag win
    public boolean isWinner(Coordinates guess, String playerSymbol){
        //idea from https://stackoverflow.com/questions/1056316/algorithm-for-determining-tic-tac-toe-game-over
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
    //method to control the player turn
    public boolean playerTurn(String playerSymbol){
        System.out.print("Player "+playerSymbol+", please enter the coordinates of your placement: ");
        int col = scan.nextInt();
        int row = scan.nextInt();
        Coordinates guess = new Coordinates(row, col);
        if (isValidMove(guess)) {
            makeMove(guess, playerSymbol);
        }
        else{
            playerTurn(playerSymbol);
        }
        System.out.println(toString());
        if(isWinner(guess,playerSymbol)){
            System.out.println("Player " +playerSymbol+ " won!");
            return true;
        }
        return false;
    }
    //main loop that calls other methods
    public void playGame(){
        boolean play = true;
        int totalMoves=0;
        System.out.println("Player \"X\" is going first \n"+toString());
        while(play){
            if (totalMoves==dim*dim){
                System.out.println("Scratch game!");
                break;
            }
            if(totalMoves%2==0){
                if(playerTurn("X")) {
                    play=false;
                }
            }
            else{
                if(playerTurn("O")) {
                    play=false;
                }
            }
            totalMoves+=1;
        }
    }
}
