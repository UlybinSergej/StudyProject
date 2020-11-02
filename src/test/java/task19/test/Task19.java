package task19.test;

import org.junit.Test;

public class Task19 extends Config {

    @Test
    public void testOne() {
        app.addProductsToCart();
        app.removeProductsFromCart();
    }
}
