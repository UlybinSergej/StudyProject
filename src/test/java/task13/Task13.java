package task13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class Task13 extends Config {
    private static final String START_PAGE_URL = "http://localhost/litecart/";
    private static final String LIST_OF_PRODUCTS = "//section[@id='box-popular-products']/div[@class='listing products']/article";
    private static final By ADD_TO_CART = By.xpath("//button[@name='add_cart_product']");
    private static final int QUANTITY_PRODUCTS_IN_CART = 3;
    private static final By GO_TO_CART = By.xpath("//a[@href='http://localhost/litecart/checkout']");
    private static final By QUANTITY_DIFFERENT_PRODUCTS = By.xpath("//table[@class='items table table-striped table-hover data-table']/tbody/tr");
    private static final By FIRST_ITEM_GROUP = By.xpath("//input[@step]");
    private static final By SUBTOTAL = By.xpath("//strong[@class]");
    private static final By REFRESH_BUTTON = By.xpath("//button[@class='btn btn-default']");
    private static final By REMOVE_BUTTON = By.xpath("//button[@title='Remove']");
    private static final By EMPTY_CART = By.xpath("//p[text()='There are no items in your cart.']");


    @Test
    public void testOne() {
        for (int i = 1; i <= QUANTITY_PRODUCTS_IN_CART; i++) {
            driver.get(START_PAGE_URL);
            driver.findElement(By.xpath(LIST_OF_PRODUCTS + "[" + (random.nextInt(
                    driver.findElements(By.xpath(LIST_OF_PRODUCTS)).size()) + 1) + "]")).click();
            driver.findElement(ADD_TO_CART).click();
            wait.until(ExpectedConditions.attributeContains(GO_TO_CART, "innerText", "" + i + ""));
        }

        driver.findElement(GO_TO_CART).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(QUANTITY_DIFFERENT_PRODUCTS)));
        int quantityProducts = driver.findElements(QUANTITY_DIFFERENT_PRODUCTS).size();

        for (int i = 1; i < quantityProducts; i++) {
            wait.until(WebDriver -> WebDriver.findElement(REMOVE_BUTTON));
            String dollar = "$";
            int subtotal = Integer.parseInt(driver.findElement(SUBTOTAL).getAttribute("innerText").substring(1));
            int productPrice = Integer.parseInt(driver.findElement(QUANTITY_DIFFERENT_PRODUCTS)
                    .getAttribute("data-price").substring(0, 2));

            if (Integer.parseInt(driver.findElement(FIRST_ITEM_GROUP).getAttribute("value")) > 1) {
                int value = Integer.parseInt(driver.findElement(FIRST_ITEM_GROUP).getAttribute("value"));
                driver.findElement(FIRST_ITEM_GROUP).sendKeys(Keys.DELETE);
                driver.findElement(FIRST_ITEM_GROUP).sendKeys(String.valueOf(value - 1));
                driver.findElement(REFRESH_BUTTON).click();
            } else {
                driver.findElement(REMOVE_BUTTON).click();
            }
            wait.until(ExpectedConditions.attributeContains(SUBTOTAL, "innerText", dollar + (subtotal - productPrice)));
        }

        driver.findElement(REMOVE_BUTTON).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(EMPTY_CART)));
    }
}
