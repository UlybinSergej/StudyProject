package task4.task1;

import java.util.Random;

public class Apple extends Fruit {

    private static String[] colorArray = {"Red", "Green", "Yellow"};
    public String color;

    public Apple(String color, int weight) {
        super(weight);
        this.color = color;
    }

    public static Apple getRandomApple() {
        Random random = new Random();
        return new Apple(colorArray[random.nextInt(3)], Fruit.getRandomWeight());
    }

    @Override
    public String toString() {
        return "Apple: " +
                "color= " + color + ", weight= " + super.weight;
    }
}
