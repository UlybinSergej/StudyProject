package tasks.task4;

import java.util.Random;

public class Fruit {
    protected int weight;

    public Fruit(int weight) {
        this.weight = weight;
    }

    public int getRandomWeight() {
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
