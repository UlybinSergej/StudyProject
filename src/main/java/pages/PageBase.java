package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class PageBase {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public PageBase() {
    }

    public PageBase(WebDriver driver) {
        PageBase.driver = driver;
        wait = new WebDriverWait(driver, 10);
        PageBase.driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        PageBase.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
}
