package task5.task2;

import java.util.Random;

public class PersonMain {
    private final static int PERSON_ARRAY_SIZE = 10;
    public static void main(String[] args) {
        Person[] persons = new Person[PERSON_ARRAY_SIZE];
        Random random = new Random();

        for (int i = 0; i < persons.length; i++) {
            persons[i] = new Person(Person.Names.values()[random.nextInt(Person.Names.values().length)], Person.Season.values()[random.nextInt(Person.Season.values().length)]);
        }

        for (Person person : persons) {
            System.out.println(person.toString());
        }
    }
}
