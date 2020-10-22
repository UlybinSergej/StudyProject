package task4.task2;

import java.util.Random;

public class Pineapple extends Fruit {
    private static int[] heightTailArray = new int[16];
    int heightTail;

    static {
        for (int i = 0; i < 16; i++) {
            heightTailArray[i] = i + 5;
        }
    }

    public Pineapple(int heightTail, int weight) {
        super(weight);
        this.heightTail = heightTail;
    }

    public static Pineapple getRandomPineapple() {
        Random random = new Random();
        return new Pineapple(heightTailArray[random.nextInt(16)], Fruit.getRandomWeight());
    }

    @Override
    public String toString() {
        return "Pineapple: " +
                "heightTail= " + heightTail + ", weight= " + super.weight;
    }
}
