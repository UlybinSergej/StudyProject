import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task1 {
    public Task1() {
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите первое число:");
        Integer firstNum = Integer.parseInt(reader.readLine());
        System.out.println("Введите второе число:");
        Integer secondNum = Integer.parseInt(reader.readLine());
        if (firstNum > secondNum) {
            System.out.println(String.format("Число %1$d больше %2$d", firstNum, secondNum));
        } else if (secondNum > firstNum) {
            System.out.println(String.format("Число %2$d больше %1$d", firstNum, secondNum));
        }

        System.out.println("Сумма равна " + (firstNum + secondNum));
    }
}