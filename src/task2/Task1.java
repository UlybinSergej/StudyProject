package task2;

import java.util.Random;

public class Task1 {
    private final static int ARRAY_SIZE = 10;

    public static void main(String[] args) {
        int[] array = new int[ARRAY_SIZE];
        Random random = new Random();
        long sum = 0;
        long minNum = Long.MAX_VALUE;

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt();
            sum += array[i];
            minNum = (minNum > array[i]) ? array[i] : minNum;
            System.out.print(array[i] + " ");
        }

        System.out.println("\n" + "Сумма всех элементов - " + sum);
        System.out.println("Минимальное значение - " + minNum);
    }
}
