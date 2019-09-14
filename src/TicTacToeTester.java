
public class TicTacToeTester {

    public static void main(String[] args) {

        Coordinates origin= new Coordinates(0,0);
        System.out.println(origin);

        Cell beginning = new Cell(origin,"X");
        System.out.println(beginning);

        Board game = new Board();
        game.playGame();


    }
}
