import org.junit.After;
import org.junit.Before;
import services.Application;

public class TestBase {

    public static Application app;

    @After
    public void end() {
        Application.driver.quit();
        Application.driver = null;
    }
}
