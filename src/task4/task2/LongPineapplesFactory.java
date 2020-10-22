package task4.task2;

import java.util.Random;

public class LongPineapplesFactory extends AbstractFabric {
    @Override
    public Fruit makeFruit() {
        Random random = new Random();
        return new Pineapple(random.nextInt(6) + 10, Fruit.getRandomWeight());
    }
}
