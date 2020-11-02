package task10;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Config {
    public EventFiringWebDriver driver;
    public WebDriverWait wait;
    public BrowserMobProxy proxy;
    public Proxy sendProxy;

    @Before
    public void start() {
        proxy = new BrowserMobProxyServer();
        proxy.start(0);
        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);
        driver = new EventFiringWebDriver(new ChromeDriver(capabilities));
        driver.register(new MyListener());
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        sendProxy = new Proxy();
        sendProxy.setHttpProxy("http://localhost:8866");
    }

    @After
    public void end() {
        driver.quit();
        driver = null;
    }
}


class MyListener extends AbstractWebDriverEventListener {
    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        driver.manage().logs().get("browser").forEach(System.out::println);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        driver.manage().logs().get("browser").forEach(System.out::println);
    }
}