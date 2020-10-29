package task8;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


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

    public boolean checkSticker(List<WebElement> elements) {
        if (elements.isEmpty()) {
            return false;
        } else return elements.size() <= 1;
    }
}
