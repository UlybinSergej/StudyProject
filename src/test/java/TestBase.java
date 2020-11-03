import org.junit.Before;
import services.Application;


public class TestBase {
    public Application app;

    @Before
    public void start() {
        if (app == null) {
            app = new Application();
        }
    }
}
