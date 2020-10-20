package tasks.task3.task1;

import java.util.Random;

public class PersonMain {
    public static void main(String[] args) {
        String[][] firstNameArray = {{"Михаил", "Мария", "Андрей", "Юлия", "Кристина"}, {"m", "f", "m", "f", "f"}};
        String[] lastNameArray = {"Петров", "Сидоров", "Иванов", "Смирнов", "Кузнецов", "Попов"};
        Person[] persons = new Person[50];

        Random random = new Random();

        for (int i = 0; i < 50; i++) {
            int temp = random.nextInt(5);
            persons[i] = new Person(firstNameArray[0][temp], lastNameArray[random.nextInt(6)], firstNameArray[1][temp]);
            System.out.println("Человек №" + (i + 1) + " " + persons[i].toString());
        }
    }
}
