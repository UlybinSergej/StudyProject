package task3.task1;

import java.util.Random;

public class PersonMain {
    private final static int QUANTITY_PEOPLE = 50;
    public static void main(String[] args) {
        String[][] firstNameArray = {{"Михаил", "Мария", "Андрей", "Юлия", "Кристина"}, {"m", "f", "m", "f", "f"}};
        String[] lastNameArray = {"Петров", "Сидоров", "Иванов", "Смирнов", "Кузнецов", "Попов"};
        Person[] persons = new Person[QUANTITY_PEOPLE];

        Random random = new Random();

        for (int i = 0; i < QUANTITY_PEOPLE; i++) {
            int temp = random.nextInt(firstNameArray.length);
            persons[i] = new Person(firstNameArray[0][temp], lastNameArray[random.nextInt(lastNameArray.length)], firstNameArray[1][temp]);
            System.out.println("Человек №" + (i + 1) + " " + persons[i].toString());
        }
    }
}
