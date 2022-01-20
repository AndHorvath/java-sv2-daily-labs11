package day02;

public class Coordinate {

    // --- attributes ---------------------------------------------------------

    private double latitude;
    private double longitude;

    // --- constructors -------------------------------------------------------

    public Coordinate(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // --- getters and setters ------------------------------------------------

    public double getLatitude() { return latitude; }
    public double getLongitude() { return longitude; }
}