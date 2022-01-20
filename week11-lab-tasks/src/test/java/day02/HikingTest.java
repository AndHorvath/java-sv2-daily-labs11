package day02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class HikingTest {

    Hiking hiking;
    List<Position> positions;
    Coordinate coordinate;
    double epsilon;

    @BeforeEach
    void setUp() {
        hiking = new Hiking();
        coordinate = new Coordinate(47.49, 19.03);
        positions = new ArrayList<>(Arrays.asList(
            new Position(coordinate, 110.0), new Position(coordinate, 120.0),
            new Position(coordinate, 115.0), new Position(coordinate, 118.0)));
        epsilon = Math.pow(10d, -5d);
    }

    @Test
    void getPositionsTest() {
        assertEquals(0, hiking.getPositions().size());
    }

    @Test
    void addPositionTest() {
        hiking.addPosition(new Position(coordinate, 110.0));
        assertEquals(1, hiking.getPositions().size());
        assertEquals(coordinate, hiking.getPositions().get(0).getCoordinate());
        assertEquals(110.0, hiking.getPositions().get(0).getHeight(), epsilon);
    }

    @Test
    void addPositionsTest() {
        hiking.addPositions(positions);
        assertEquals(positions, hiking.getPositions());
    }

    @Test
    void getPlusElevationTest() {
        hiking.addPositions(positions);
        assertEquals(13.0, hiking.getPlusElevation(), epsilon);
    }
}