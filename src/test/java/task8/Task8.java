package task8;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Task8 extends Config {
    private List<WebElement> ducks = new ArrayList<>();

    @Test
    public void testTwo() {
        driver.get("http://localhost/litecart/");
        ducks.addAll(driver.findElement(By.id("box-campaign-products")).findElements(By.cssSelector("article")));
        ducks.addAll(driver.findElement(By.id("box-popular-products")).findElements(By.cssSelector("article")));
        ducks.addAll(driver.findElement(By.id("box-latest-products")).findElements(By.cssSelector("article")));
        for (WebElement element : ducks) {
            Assert.assertTrue(checkSticker(element.findElements(By.cssSelector("a > div.image-wrapper > div"))));
        }
    }
}