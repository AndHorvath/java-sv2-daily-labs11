package day05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LotteryTest {

    Lottery lottery;
    List<Integer> drawnNumbers;

    @BeforeEach
    void setUp() {
        lottery = new Lottery(10, 5);
    }

    @Test
    void getNumbersTest() {
        assertEquals(10, lottery.getNumbers());
    }

    @Test
    void getDrawingsTest() {
        assertEquals(5, lottery.getDrawings());
    }

    @Test
    void startLotteryWhileTest() {
        drawnNumbers = lottery.startLotteryWhile();
        assertEquals(5, drawnNumbers.size());
        proveNotEqualityCondition(drawnNumbers);
    }

    @Test
    void startLotteryForITest() {
        drawnNumbers = lottery.startLotteryForI();
        assertEquals(5, drawnNumbers.size());
        proveNotEqualityCondition(drawnNumbers);
    }

    // --- private methods ----------------------------------------------------

    private void proveNotEqualityCondition(List<Integer> drawnNumbers) {
        for (int i = 0; i < lottery.getDrawings(); i++) {
            for (int j = i + 1; j < lottery.getDrawings(); j++) {
                assertNotEquals(drawnNumbers.get(i), drawnNumbers.get(j));
            }
        }
    }
}