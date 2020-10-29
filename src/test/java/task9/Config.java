package task9;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;


public class Config {
    public static WebDriver driver;
    public static WebDriverWait wait;
    private Character isAlphabeticallyCountry = 0;
    private Character isAlphabeticallyZone = 0;


    @Before
    public void start() {
        if (driver != null) {
            return;
        }
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {driver.quit(); driver = null;}));
    }

    @After
    public void end() {
        driver.quit();
        driver = null;
    }

    public boolean isAlphabeticallyCounty(String place, boolean isCountry) {
        if (isCountry) {
            if (isAlphabeticallyCountry == 0) {
                isAlphabeticallyCountry = place.charAt(0);
                System.out.println(place);
                return true;
            } else {
                isAlphabeticallyZone = 0;
                System.out.println(place);
                return place.charAt(0) >= isAlphabeticallyCountry;
            }
        } else {
            if (isAlphabeticallyZone == 0) {
                isAlphabeticallyZone = place.charAt(0);
                System.out.println(place);
                return true;
            } else {
                System.out.println(place);
                return place.charAt(0) >= isAlphabeticallyZone;
            }
        }
    }
}
