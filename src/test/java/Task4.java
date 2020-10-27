import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class Task4 {
    private WebDriver driver;

    @Test
    public void chromeTest() {
        driver = new ChromeDriver();
        driver.get("http://localhost/litecart/");
        System.out.println(driver.getTitle() + "\ntesting Chrome");
    }

    @Test
    public void foxTest() {
        driver = new FirefoxDriver(new FirefoxOptions().setBinary("C:\\Program Files\\Firefox Developer Edition\\firefox.exe"));
        driver.get("http://localhost/litecart/");
        System.out.println(driver.getTitle() + "\ntesting FireFox");
    }

    @Test
    public void edgeTest() {
        driver = new EdgeDriver();
        driver.get("http://localhost/litecart/");
        System.out.println(driver.getTitle() + "\ntesting Edge");
    }

    @After
    public void end() {
        driver.quit();
        driver = null;
    }

}