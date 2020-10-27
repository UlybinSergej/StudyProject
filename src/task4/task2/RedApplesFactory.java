package task4.task2;

import java.util.Random;

public class RedApplesFactory extends AbstractFabric {
    @Override
    public Fruit makeFruit() {
        Random random = new Random();
        return new Apple("Red", Fruit.getRandomWeight());
    }
}
