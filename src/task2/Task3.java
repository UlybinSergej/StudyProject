package task2;

import java.util.Arrays;
import java.util.Random;

public class Task3 {
    private static final int ARRAYS_SIZE = 7;
    private static int positiveCount = 7;
    private static int negativeCount = 7;

    public static void main(String[] args) {
        Random random = new Random();
        int[] positiveArray = new int[ARRAYS_SIZE];
        int[] negativeArray = new int[ARRAYS_SIZE];
        int[] array = new int[ARRAYS_SIZE];

        while (positiveArray[ARRAYS_SIZE - 1] == 0 || negativeArray[ARRAYS_SIZE - 1] == 0) {
            int temp = random.nextInt();
            if (temp > 0 && positiveArray[ARRAYS_SIZE - 1] == 0) {
                positiveArray[positiveArray.length - positiveCount] = temp;
                positiveCount--;
            } else if (temp < 0 && negativeArray[ARRAYS_SIZE - 1] == 0) {
                negativeArray[negativeArray.length - negativeCount] = temp;
                negativeCount--;
            }
        }

        for (int i = 0; i < 7; i++) {
            array[i] = positiveArray[i] + negativeArray[i];
        }

        System.out.println("Массив с положительными числами - " + Arrays.toString(positiveArray));
        System.out.println("Массив с отрицательными числами - " + Arrays.toString(negativeArray));
        System.out.println("Массив с суммами значений массивов - " + Arrays.toString(array));
    }
}
