import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import services.Application;


public class Task4 extends TestBase{

    @Test
    public void chromeTest() {
        app = new Application(new ChromeDriver());
        app.login();
    }

    @Test
    public void foxTest() {
        app = new Application(new FirefoxDriver(new FirefoxOptions().setBinary("C:\\Program Files\\Firefox Developer Edition\\firefox.exe")));
        app.login();
    }

    @Test
    public void edgeTest() {
        app = new Application(new EdgeDriver());
        app.login();
    }
}