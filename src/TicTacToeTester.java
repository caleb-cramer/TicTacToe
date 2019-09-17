/**
 * This program is a Tic Tac Toe Game
 * CPSC 224, Fall 2019
 * Programming Assignment #2
 * Used a source on stackoverflow for idea on how to test for 'forward slash'
 *
 * @author Caleb
 * @version v1.3 9/16/19
 */

import java.util.Scanner;
public class TicTacToeTester {
    public static void main(String[] args) {
        Scanner scans =new Scanner(System.in);
        boolean playAgain = true;
        //This loop is unnecessary but I was trying out do-while loops for the bonus
        // because I hadn't used them in a while
        do {
            //print out some words
            System.out.println("Welcome to Tic Tac Toe! There are two players, player 'X' and player 'O'... \n");
            System.out.println("Please enter the dimension, N, of the NxN Tic Tac Toe board (an integer in [3, 9]): ");
            //get the dimension from the user
            int userDim = scans.nextInt();
            Board game = new Board(userDim);
            //run the game method
            game.playGame();
            playAgain=false;

            /*System.out.print("Game over! Would you like to play again? [y/n] ");
            if (scans.nextLine()=="y"){
                playAgain=true;
            }*/
        }while (playAgain);
    }
}
