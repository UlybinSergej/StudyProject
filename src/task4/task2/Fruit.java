package task4.task2;

import java.util.Random;

public class Fruit {
    protected int weight;

    public Fruit(int weight) {
        this.weight = weight;
    }

    public static int getRandomWeight() {
        Random random = new Random();
        return random.nextInt(15) + 1;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "weight=" + weight +
                '}';
    }
}
