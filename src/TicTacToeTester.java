import java.util.Scanner;
public class TicTacToeTester {

    public static void main(String[] args) {
        Scanner scans =new Scanner(System.in);
        Coordinates origin= new Coordinates(0,0);
        System.out.println(origin);

        Cell beginning = new Cell(origin,"X");
        System.out.println(beginning);

        System.out.println("Welcome to Tic Tac Toe! There are two players, player 'X' and player 'O'... \n");
        System.out.println("Please enter the dimension, N, of the NxN Tic Tac Toe board (an integer in [3, 9]): ");
        int userDim = scans.nextInt();
        Board game = new Board(userDim);
        game.playGame();


    }
}
