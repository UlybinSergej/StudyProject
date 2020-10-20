package task3.task2;

import java.util.Random;

public class SequentialRandom {
    private static Integer randomValue;

    public static Integer getRandomValue() {
        return randomValue;
    }

    public SequentialRandom() {
        if (randomValue == null) {
            Random random = new Random();
            randomValue = random.nextInt(100);
        }
        else {
            randomValue++;
        }
    }

    public static void resetRandom() {
        randomValue = null;
    }
}
