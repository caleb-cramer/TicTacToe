//This is one square in the board
public class Cell {
    private Coordinates coordinates = new Coordinates();
    private String symbol;

    public Cell(){
        this.symbol="-";
    }

    public Cell(Coordinates coordinates, String symbol) {
        this.coordinates = coordinates;
        this.symbol = symbol;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

}
