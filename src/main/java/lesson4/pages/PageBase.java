package lesson4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class PageBase {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public PageBase() {
        if (driver == null) {
            driver = new ChromeDriver();
            wait = new WebDriverWait(driver, 10);
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.SECONDS);
        }
    }
}
