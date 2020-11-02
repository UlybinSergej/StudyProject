package task10;

import net.lightbody.bmp.core.har.Har;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Task17 extends Config {
    private final static String START_PAGE = "http://localhost/litecart/admin/";
    private final static By INPUT_USERNAME = By.xpath("//input[@name='username']");
    private final static By INPUT_PASSWORD = By.xpath("//input[@name='password']");
    private final static By LOG_IN_BUTTON = By.xpath("//button[@name='login']");
    private final static By CATALOG_BUTTON = By.xpath("//li[@data-code='catalog']");
    private final static By SELECTED_CATALOG_BUTTON = By.xpath("//li[@data-code='catalog']/a");
    private final static By RUBBER_DUCKS_CATEGORY = By.xpath("//a[text()='Rubber Ducks']");
    private final static By PRODUCTS_AND_CATEGORIES = By.xpath("//td[@colspan]");
    private final static String CHECK_PRODUCTS = "//tbody/tr[]/td[3]/a";


    private final static String USERNAME = "admin";
    private final static String PASSWORD = "admin";


    @Test
    public void testOne() throws InterruptedException {
        proxy.newHar();
        driver.get(START_PAGE);
        driver.findElement(INPUT_USERNAME).sendKeys(USERNAME);
        driver.findElement(INPUT_PASSWORD).sendKeys(PASSWORD);
        driver.findElement(LOG_IN_BUTTON).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(CATALOG_BUTTON)));
        driver.findElement(CATALOG_BUTTON).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(RUBBER_DUCKS_CATEGORY)));
        driver.findElement(RUBBER_DUCKS_CATEGORY).click();
        Thread.sleep(1000);
        for (int i = getQuantityOfProductsAndCategories() - getQuantityOfProducts() + 1; i <= getQuantityOfProductsAndCategories(); i++) {
            driver.findElement(By.xpath(CHECK_PRODUCTS.substring(0, 11) + i + CHECK_PRODUCTS.substring(11))).click();
            Thread.sleep(500);
            driver.findElement(SELECTED_CATALOG_BUTTON).click();
            Thread.sleep(500);
            driver.findElement(RUBBER_DUCKS_CATEGORY).click();
            Thread.sleep(1000);
        }
        Har har = proxy.endHar();
        har.getLog().getEntries().forEach(log -> System.out.println(log.getResponse().getStatus() + "  " + log.getRequest().getUrl()));
    }

    public int getQuantityOfProducts() {
        String[] quantity = driver.findElement(PRODUCTS_AND_CATEGORIES).getAttribute("innerText").split(",");
        return Integer.parseInt(quantity[1].substring(11));
    }

    public int getQuantityOfProductsAndCategories() {
        String[] quantity = driver.findElement(PRODUCTS_AND_CATEGORIES).getAttribute("innerText").split(",");
        return Integer.parseInt(quantity[1].substring(11)) + Integer.parseInt(quantity[0].substring(12)) + 1;
    }
}
