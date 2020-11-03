package task7;

import lesson4.services.Application;
import org.junit.After;
import org.junit.Before;


public class Config {
    public static Application app;

    @Before
    public void start() {
        if (app == null) {
            app = new Application();
        }
    }

    @After
    public void end() {
        Application.driver.quit();
        Application.driver = null;
    }
}