package day02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    Position position;
    Coordinate coordinate;

    double epsilon;

    @BeforeEach
    void setUp() {
        coordinate = new Coordinate(47.49, 19.03);
        position = new Position(coordinate, 105.0);

        epsilon = Math.pow(10d, -5d);
    }

    @Test
    void getCoordinateTest() {
        assertEquals(coordinate, position.getCoordinate());
    }

    @Test
    void getHeightTest() {
        assertEquals(105.0, position.getHeight(), epsilon);
    }
}