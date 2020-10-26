import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class Task6 {
    private WebDriver fox;

    @Before
    public void start() {
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("C:\\Program Files\\Firefox Nightly\\firefox.exe");
        fox = new FirefoxDriver(options);
    }

    @Test
    public void testEsrFox() {
        fox.get("http://localhost/litecart/admin/");
        fox.findElement(By.name("username")).sendKeys("admin");
        fox.findElement(By.name("password")).sendKeys("admin");
        fox.findElement(By.xpath("//*[@id=\"box-login\"]/form/div[2]/button")).click();
    }

    @After
    public void end() {
        fox.quit();
        fox = null;
    }
}
