package task4.task1;

import java.util.Random;

public class Orange extends Fruit {
    private static int[] deepSkinArray = new int[21];
    int deepSkin;

    static {
        for (int i = 0; i < 21; i++) {
            deepSkinArray[i] = i;
        }
    }

    public Orange(int deepSkin, int weight) {
        super(weight);
        this.deepSkin = deepSkin;
    }

    public static Orange getRandomOrange() {
        Random random = new Random();
        return new Orange(deepSkinArray[random.nextInt(21)], Fruit.getRandomWeight());
    }

    @Override
    public String toString() {
        return "Orange: " +
                "deepSkin = " + deepSkin + ", weight = " + super.weight;
    }
}
