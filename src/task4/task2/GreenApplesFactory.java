package task4.task2;

import java.util.Random;

public class GreenApplesFactory extends AbstractFabric {

    @Override
    public Fruit makeFruit() {
        Random random = new Random();
        return new Apple("Green", Fruit.getRandomWeight());
    }
}
