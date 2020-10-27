package task4.task1;

import java.util.Random;

public class FruitMain {
    public static void main(String[] args) {
        Fruit[] fruits = new Fruit[4];
        for (int i = 0; i < 4; i++) {
            fruits[i] = getRandomFruit();
            System.out.println(fruits[i]);
        }
    }

    public static Fruit getRandomFruit() {
        Random random = new Random();
        int randomFruit = random.nextInt(3);
        return switch (randomFruit) {
            case 0 -> Apple.getRandomApple();
            case 1 -> Orange.getRandomOrange();
            case 2 -> Pineapple.getRandomPineapple();
            default -> null;
        };
    }
}
