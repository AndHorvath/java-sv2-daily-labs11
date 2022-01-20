package day05;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lottery {

    private int numbers;
    private int drawings;
    private Random random;

    public Lottery(int numbers, int drawings) {
        this.numbers = numbers;
        this.drawings = drawings;
        this.random = new Random();
    }

    public int getNumbers() { return numbers; }
    public int getDrawings() {return drawings; }

    public List<Integer> startLotteryWhile() {
        List<Integer> drawnNumbers = new ArrayList<>();
        int newNumber;

        while (drawnNumbers.size() < drawings) {
            newNumber = random.nextInt(1, numbers + 1);
            if (!drawnNumbers.contains(newNumber)) {
                drawnNumbers.add(newNumber);
            }
        }
        return drawnNumbers;
    }

    public List<Integer> startLotteryForI() {
        List<Integer> drawnNumbers = new ArrayList<>();
        int newNumber;

        for (int i = 0; i < drawings; i++) {
            newNumber = random.nextInt(1, numbers + 1);
            if (drawnNumbers.contains(newNumber)) {
                i--;
            } else {
                drawnNumbers.add(newNumber);
            }
        }
        return drawnNumbers;
    }
}