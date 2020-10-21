package task5.task2;

import java.util.Random;

public class PersonMain {
    public static void main(String[] args) {

        Person[] persons = new Person[10];
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            persons[i] = new Person(Names.values()[random.nextInt(10)], Season.values()[random.nextInt(4)]);
        }

        for (Person person : persons) {
            System.out.println(person.toString());
        }
    }
}
