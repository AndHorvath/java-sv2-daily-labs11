package day02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CoordinateTest {

    Coordinate coordinate;
    double epsilon;

    @BeforeEach
    void setUp() {
        coordinate = new Coordinate(47.49, 19.03);
        epsilon = Math.pow(10d, -5d);
    }

    @Test
    void getLatitudeTest() {
        assertEquals(47.49, coordinate.getLatitude(), epsilon);
    }

    @Test
    void getLongitudeTest() {
        assertEquals(19.03, coordinate.getLongitude(), epsilon);
    }
}