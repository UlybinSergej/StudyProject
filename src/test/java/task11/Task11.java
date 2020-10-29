package task11;

import org.junit.Test;
import org.openqa.selenium.By;

import java.io.*;
import java.util.Random;

public class Task11 extends Config {
    private static final String PATH_TO_USERS_NICKNAME = "src/test/java/task11/usersNickname.txt";
    private static String lastNickname = "";
    private static final int MIN_POSTCODE = 10000;
    private static final int MAX_POSTCODE = 99999;

    @Test
    public void testOne() throws IOException {
        String nickname = generateNickName();
        String email = nickname + "@gmail.com";
        String password = "12345";
        Random random = new Random();
        driver.get("http://localhost/litecart/");
        driver.findElement(By.xpath("//li[@class='account dropdown']")).click();
        driver.findElement(By.xpath("//a[text()='New customers click here']")).click();
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(nickname);
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(nickname);
        driver.findElement(By.xpath("//input[@name='postcode']")).sendKeys(String.valueOf(random.nextInt(MAX_POSTCODE - MIN_POSTCODE) + MIN_POSTCODE));
        driver.findElement(By.xpath("//select[@name='country_code']")).click();
        driver.findElement(By.xpath("//option[text()='United States']")).click();
        driver.findElement(By.xpath("//select[@name='zone_code']")).click();
        driver.findElement(By.xpath("//select[@name='zone_code']/option[" +
                (random.nextInt(driver.findElements(By.xpath("//select[@name='zone_code']/option")).size()) + 1) + "]")).click();
        driver.findElement(By.xpath("//div[@class='form-group col-xs-6 required']/div/input[@name='email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@name='password'and@required]")).sendKeys(password);
        driver.findElement(By.xpath("//input[@name='confirmed_password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@name='terms_agreed']")).click();
        driver.findElement(By.xpath("//button[text()='Create Account']")).click();
        driver.findElement(By.xpath("//li[@class='account dropdown']")).click();
        driver.findElement(By.xpath("//ul[@class='dropdown-menu']/li/a[text()='Logout']")).click();
        driver.findElement(By.xpath("//li[@class='account dropdown']")).click();
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[text()='Sign In']")).click();
        driver.findElement(By.xpath("//li[@class='account dropdown']")).click();
        driver.findElement(By.xpath("//ul[@class='dropdown-menu']/li/a[text()='Logout']")).click();
    }

    public static String generateNickName() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(PATH_TO_USERS_NICKNAME)));
        FileWriter fw = new FileWriter(PATH_TO_USERS_NICKNAME, true);
        String currentLine = "";

        while ((currentLine = br.readLine()) != null) {
            lastNickname = currentLine;
        }

        fw.write("\n" + "user" + (Integer.parseInt(lastNickname.substring(4)) + 1));
        fw.flush();
        fw.close();
        return "user" + (Integer.parseInt(lastNickname.substring(4)) + 1);
    }
}
