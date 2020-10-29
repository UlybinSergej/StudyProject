package task7;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Task7 extends Config{
    WebElement listOfElements;
    List<WebElement> elements = new ArrayList<>();


    @Test
    public void testOne() {
        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.cssSelector("#box-login > form > div.footer > button")).click();
        wait.until((WebDriver d) -> d.findElement(By.cssSelector("#box-apps-menu")));
        listOfElements = driver.findElement(By.cssSelector("#box-apps-menu"));
        elements = listOfElements.findElements(By.cssSelector("li"));

        for (int i = 1; i <= elements.size(); i ++) {
            driver.findElement(By.cssSelector("#box-apps-menu > li:nth-child(" + i + ")")).click();
            if (!isEmpty(driver.findElement(By.cssSelector("#box-apps-menu > li:nth-child(" + i + ")")))) {
                for (int j = 1; j <= driver.findElement(By.
                        cssSelector("#box-apps-menu > li:nth-child(" + i + ")")).
                        findElements(By.cssSelector("li")).size(); j ++) {
                    driver.findElement(By.cssSelector("#box-apps-menu > li.app.selected > ul > li:nth-child(" + j + ")")).click();
                }
            }
        }
    }
}
