package tasks.task3.task2;

public class RandomMain {

    public static void main(String[] args) {
        SequentialRandom num1 = new SequentialRandom();
        System.out.println(SequentialRandom.getRandomValue());
        SequentialRandom num2 = new SequentialRandom();
        System.out.println(SequentialRandom.getRandomValue());
        SequentialRandom num3 = new SequentialRandom();
        System.out.println(SequentialRandom.getRandomValue());
        SequentialRandom.resetRandom();
        SequentialRandom num4 = new SequentialRandom();
        System.out.println(SequentialRandom.getRandomValue());
        SequentialRandom num5 = new SequentialRandom();
        System.out.println(SequentialRandom.getRandomValue());

    }
}
