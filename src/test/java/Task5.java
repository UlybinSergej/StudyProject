import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import services.Application;


public class Task5 extends TestBase{

    @Test
    public void testEsrFox() {
        FirefoxOptions options = new FirefoxOptions();
        options.setCapability(FirefoxDriver.MARIONETTE, false);
        options.setBinary("C:\\Program Files\\Mozilla Firefox ESR\\firefox.exe");
        app = new Application(new FirefoxDriver(options));
        app.login();
    }
}
