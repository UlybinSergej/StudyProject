package task2;

import java.util.Arrays;
import java.util.Random;

public class Task2 {

    public static void main(String[] args) {
        Random random = new Random();
        int evenCount = 0;
        int oddCount = 0;
        int[] array = new int[5];
        
        for (int i = 0; i < 5; i++) {
            array[i] = random.nextInt(100);
            if (array[i] % 2 == 0) evenCount++;
            else oddCount++;
        }

        System.out.println(Arrays.toString(array));

        int[] evenArray = new int[evenCount];
        int[] oddArray = new int[oddCount];

        for (int i = 0; i < 5; i++) {
            if (array[i] % 2 == 0) {
                evenArray[evenArray.length - evenCount] = array[i];
                evenCount--;
            }
            else {
                oddArray[oddArray.length - oddCount] = array[i];
                oddCount--;
            }
        }

        System.out.println("Среднее значение основного массива - " + (float) Arrays.stream(array).sum() / (float)array.length);
        System.out.println("Среднее значение четного массива - " + (float) Arrays.stream(evenArray).sum() / (float)evenArray.length);
        System.out.println("Среднее значение нечетного массива - " + (float) Arrays.stream(oddArray).sum() / (float)oddArray.length);
    }
}
