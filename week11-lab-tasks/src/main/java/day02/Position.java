package day02;

public class Position {

    // --- attributes ---------------------------------------------------------

    private Coordinate coordinate;
    private double height;

    // --- constructors -------------------------------------------------------

    public Position(Coordinate coordinate, double height) {
        this.coordinate = coordinate;
        this.height = height;
    }

    // --- getters and setters ------------------------------------------------

    public Coordinate getCoordinate() { return coordinate; }
    public double getHeight() { return height; }
}