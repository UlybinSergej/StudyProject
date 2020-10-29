package task9;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task9 extends Config {

    @Test
    public void testOne() {
        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.cssSelector("#box-login > form > div.footer > button")).click();
        wait.until((WebDriver d) -> d.findElement(By.cssSelector("li[data-code=countries]")));
        driver.findElement(By.cssSelector("li[data-code=countries]")).click();
        for (int i = 1; i <= driver.findElement(By.cssSelector(".table.table-striped.table-hover.data-table")).
                findElements(By.cssSelector("tbody > tr")).size(); i++) {
            Assert.assertTrue(isAlphabeticallyCounty(driver.findElement(By.cssSelector(".table.table-striped.table-hover.data-table"))
                    .findElement(By.cssSelector("tbody > tr:nth-child(" + i + ") > td:nth-child(5)"))
                    .getAttribute("innerText"), true));
            if (Integer.parseInt(driver.findElement(By.cssSelector(".table.table-striped.table-hover.data-table"))
                    .findElement(By.cssSelector("tbody > tr:nth-child(" + i + ") > td:nth-child(6)"))
                    .getAttribute("innerText")) > 0) {
                int count = Integer.parseInt(driver.findElement(By.cssSelector(".table.table-striped.table-hover.data-table"))
                        .findElement(By.cssSelector("tbody > tr:nth-child(" + i + ") > td:nth-child(6)")).getAttribute("innerText"));
                driver.get(driver.findElement(By.cssSelector(".table.table-striped.table-hover.data-table"))
                        .findElement(By.cssSelector("tbody > tr:nth-child(" + i + ") > td:nth-child(5) > a"))
                        .getAttribute("href"));
                WebElement zone = driver.findElement(By.cssSelector(".table.table-striped.table-hover.data-table"));
                for (int j = 1; j <= count; j++) {
                    zone.findElement(By.cssSelector("tbody > tr:nth-child(" + j + ") > td:nth-child(3) > input")).getAttribute("value");
                    Assert.assertTrue(isAlphabeticallyCounty(zone.findElement(By
                            .cssSelector("tbody > tr:nth-child(" + j + ") > td:nth-child(3) > input"))
                            .getAttribute("value"), false));
                }
                driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
            }
        }
    }

    @Test
    public void testTwo() {
        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.cssSelector("#box-login > form > div.footer > button")).click();
        wait.until((WebDriver d) -> d.findElement(By.cssSelector("li[data-code=geo_zones]")));
        driver.findElement(By.cssSelector("li[data-code=geo_zones]")).click();
        driver.findElement(By.cssSelector(".table")).findElement(By.cssSelector("tbody > tr > td:nth-child(3) > a")).click();
        for (int i = 1; i <= driver.findElement(By.cssSelector("tbody")).findElements(By.cssSelector("tr")).size(); i++) {
            String country = driver.findElement(By.cssSelector("tbody")).findElement(By.cssSelector("tr:nth-child(" + i + ") > td:nth-child(2)")).getAttribute("innerText");
            Assert.assertTrue(isAlphabeticallyCounty(country, true));
        }
    }
}
