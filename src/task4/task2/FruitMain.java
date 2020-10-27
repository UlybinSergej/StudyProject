package task4.task2;

import java.util.Random;

public class FruitMain {
    public static void main(String[] args) {
        AbstractFabric[] factory = new AbstractFabric[10];
        AbstractFabric[] allFactory = {};
        Random random = new Random();
        int randomFactory = random.nextInt(4);

        for (int i = 0; i < 10; i++) {
            switch (randomFactory) {
                case 0 -> factory[i] = new ThinOrangeFactory();
                case 1 -> factory[i] = new RedApplesFactory();
                case 2 -> factory[i] = new GreenApplesFactory();
                default -> factory[i] = new LongPineapplesFactory();
            }
        }

        Fruit[] fruits = new Fruit[20];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 2; j++) {
                fruits[i * 2 + j] = factory[i].makeFruit();
                System.out.println(fruits[i * 2 + j].toString());
            }
        }
    }
}
