package task13;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.ArrayList;
import java.util.List;


public class Task13 extends Config {
    private static final By COUNTRIES = By.xpath("//span[text()='Countries']");
    private static final String LIST_OF_COUNTRIES = "//tbody/tr/td[5]/a";
    private static final By QUANTITY_REFERENCES = By.xpath("//i[@class='fa fa-external-link']/../../a[@target='_blank']");

    @Test
    public void testOne() throws InterruptedException {
        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.cssSelector("#box-login > form > div.footer > button")).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(COUNTRIES)));
        driver.findElement(COUNTRIES).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(LIST_OF_COUNTRIES))));
        int quantityCountries = driver.findElements(By.xpath(LIST_OF_COUNTRIES)).size();
        List<WebElement> elements = driver.findElements(By.xpath(LIST_OF_COUNTRIES));
        elements.get(random.nextInt(quantityCountries)).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(QUANTITY_REFERENCES)));
        ArrayList<String> windows = new ArrayList<>();
        String thisWindow = driver.getWindowHandle();

        for (WebElement href : driver.findElements(QUANTITY_REFERENCES)) {
            href.click();
            windows.addAll(driver.getWindowHandles());
            windows.remove(thisWindow);
            driver.switchTo().window(windows.get(0));
            windows.remove(driver.getWindowHandle());
            driver.close();
            driver.switchTo().window(thisWindow);
        }
    }
}
