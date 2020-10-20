package task2;

import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        int[] array = new int[10];
        Random random = new Random();
        long sum = 0;
        long minNum = Long.MAX_VALUE;
        int minCount = -1;
        
        for (int i = 0; i < 10; i++) {
            array[i] = random.nextInt();
            sum += array[i];
            if (minNum > array[i]) {
                minNum = array[i];
                minCount = i;
            }
            System.out.print(array[i] + " ");
        }
        
        System.out.println("\n" + sum);
        System.out.println(minCount + " " + minNum);
    }
}
