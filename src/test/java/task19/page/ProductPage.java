package task19.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import task19.test.Config;

public class ProductPage extends Config {
    private static final String ADD_TO_CART = "//button[@name='add_cart_product']";
    private static final int QUANTITY_PRODUCTS_IN_CART = 3;
    private static final String GO_TO_CART = "//a[@href='http://localhost/litecart/checkout']";

    public ProductPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ADD_TO_CART)
    public WebElement addToCartButton;

    @FindBy(xpath = GO_TO_CART)
    public WebElement goToCartButton;

    public int getQuantityProductsInCart() {
        return QUANTITY_PRODUCTS_IN_CART;
    }
}
