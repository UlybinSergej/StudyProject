package task2;

import java.util.Arrays;
import java.util.Random;

public class Task3 {
    public static void main(String[] args) {
        Random random = new Random();
        int[] positiveArray = new int[7];
        int[] negativeArray = new int[7];
        int[] array = new int[7];
        int positiveCount = 7;
        int negativeCount = 7;

        while (positiveArray[6] == 0 || negativeArray[6] == 0) {
            int temp = random.nextInt();
            if (temp > 0 && positiveArray[6] == 0) {
                positiveArray[positiveArray.length - positiveCount] = temp;
                positiveCount--;
            }
            else if (temp < 0 && negativeArray[6] == 0) {
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
