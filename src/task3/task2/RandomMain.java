package task3.task2;

public class RandomMain {
    public static void main(String[] args) {
        new SequentialRandom();
        System.out.println(SequentialRandom.getRandomValue());
        new SequentialRandom();
        System.out.println(SequentialRandom.getRandomValue());
        new SequentialRandom();
        System.out.println(SequentialRandom.getRandomValue());
        SequentialRandom.resetRandom();
        new SequentialRandom();
        System.out.println(SequentialRandom.getRandomValue());
        new SequentialRandom();
        System.out.println(SequentialRandom.getRandomValue());
    }
}
