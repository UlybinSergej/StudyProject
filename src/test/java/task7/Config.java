package task7;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Config {
    public static WebDriver driver;
    public static WebDriverWait wait;


    @Before
    public void start() {
        if (driver != null) {
            return;
        }
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {driver.quit(); driver = null;}));
    }

    public boolean isEmpty(WebElement element) {
        return element.findElements(By.cssSelector("ul")) == null;
    }
}
