package task7;

import org.junit.Test;

public class Task7 extends Config{
    @Test
    public void testOne() {
        app.login();
        app.checkLeftMenu();
    }
}
