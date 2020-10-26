import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class Task5 {
    private WebDriver esrFox;

    @Before
    public void start() {
        FirefoxOptions options = new FirefoxOptions();
        options.setCapability(FirefoxDriver.MARIONETTE, false);
        options.setBinary("C:\\Program Files\\Mozilla Firefox ESR\\firefox.exe");
        esrFox = new FirefoxDriver(options);
    }

    @Test
    public void testEsrFox() {
        esrFox.get("http://localhost/litecart/admin/");
        esrFox.findElement(By.name("username")).sendKeys("admin");
        esrFox.findElement(By.name("password")).sendKeys("admin");
        esrFox.findElement(By.xpath("//*[@id=\"box-login\"]/form/div[2]/button")).click();
    }

    @After
    public void end() {
        esrFox.quit();
        esrFox = null;
    }
}
