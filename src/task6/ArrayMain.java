package task6;

import java.util.Random;

public class ArrayMain {
    private final static int BICYCLE_ARRAY_SIZE = 10;
    private final static int MIN_SPEED = 5;
    private final static int MAX_SPEED = 50;
    private final static int NUMBER_ARRAY_SIZE = 10;

    public static void main(String[] args) throws MaxSpeedException {
        MyArrayList<Bicycle> bicycles = new MyArrayList<>();
        bicycles = createBicycles(BICYCLE_ARRAY_SIZE);
        for (int i = 0; i < bicycles.size(); i++) {
            System.out.println(bicycles.get(i).toString());
        }
        removeBicyclesByMaxSpeed(bicycles);

        for (int i = 0; i < bicycles.size(); i++) {
            System.out.println(bicycles.get(i).toString());
        }

        MyArrayList<Integer> nums = new MyArrayList<>();
        createArrayWithNums(nums, 1, NUMBER_ARRAY_SIZE);

        for (int i = 0; i < nums.size(); i++) {
            System.out.println(nums.get(i));
        }

        removeAllEvenNum(nums);
        for (int i = 0; i < nums.size(); i++) {
            System.out.println(nums.get(i));
        }
    }

    public static MyArrayList<Bicycle> createBicycles(int count) throws MaxSpeedException {
        MyArrayList<Bicycle> bicycles = new MyArrayList<>();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            bicycles.add(new Bicycle(BicyclesModel.values()[random.nextInt(Bicycle.getBicycleModelSize())], getRandom(MIN_SPEED, MAX_SPEED)));
        }
        return bicycles;
    }

    public static void removeBicyclesByMaxSpeed(MyArrayList<Bicycle> bicycles) {
        int randomMaxSpeed = getRandom(MIN_SPEED, MAX_SPEED);
        for (int i = 0; i < bicycles.size(); i++) {
            if (bicycles.get(i).maxSpeed < randomMaxSpeed) {
                bicycles.remove(bicycles.get(i));
                i--;
            }
        }
        System.out.println("Случайная скорость - " + randomMaxSpeed);
    }

    public static void removeAllEvenNum(MyArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                list.remove(list.get(i));
            }
        }
    }

    public static void createArrayWithNums(MyArrayList<Integer> list, int start, int end) {
        for (int i = start; i <= end; i++) {
            list.add(i);
        }
    }

    private static int getRandom(int min, int max) {
        Random random = new Random();
        return min + random.nextInt(max - min);
    }
}
