package day02;

import java.util.ArrayList;
import java.util.List;

public class Hiking {

    // --- attributes ---------------------------------------------------------

    private List<Position> positions;

    // --- constructors -------------------------------------------------------

    public Hiking() {
        positions = new ArrayList<>();
    }

    // --- getters and setters ------------------------------------------------

    public List<Position> getPositions() { return positions; }


    // --- public methods -----------------------------------------------------

    public void addPosition(Position position) {
        positions.add(position);
    }

    public void addPositions(List<Position> positions) {
        this.positions.addAll(positions);
    }

    public double getPlusElevation() {
        double plusElevation = 0d;
        List<Double> heightList = getHeightList();
        for (int i = 1; i < heightList.size(); i++) {
            plusElevation += positivePart(heightList.get(i) - heightList.get(i - 1));
        }
        return plusElevation;
    }

    // --- private methods ----------------------------------------------------

    private List<Double> getHeightList() {
        List<Double> heightList = new ArrayList<>();
        for (Position position : positions) {
            heightList.add(position.getHeight());
        }
        return heightList;
    }

    private double positivePart(double value) {
        return Math.max(value, 0d);
    }
}