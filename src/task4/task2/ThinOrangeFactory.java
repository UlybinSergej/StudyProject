package task4.task2;

import java.util.Random;

public class ThinOrangeFactory extends AbstractFabric {
    @Override
    public Fruit makeFruit() {
        Random random = new Random();
        return new Orange(random.nextInt(5) + 1, Fruit.getRandomWeight());
    }
}
