package task19.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import task19.test.Config;

import java.util.List;

public class ShopCartPage extends Config {
    private static final String QUANTITY_DIFFERENT_PRODUCTS = "//table[@class='items table table-striped table-hover data-table']/tbody/tr";
    private static final String FIRST_ITEM_GROUP = "//input[@step]";
    private static final String SUBTOTAL = "//strong[@class]";
    private static final String REFRESH_BUTTON = "//button[@class='btn btn-default']";
    private static final String REMOVE_BUTTON = "//button[@title='Remove']";
    private static final String EMPTY_CART = "//p[text()='There are no items in your cart.']";

    public ShopCartPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = QUANTITY_DIFFERENT_PRODUCTS)
    private List<WebElement> quantityDifferentProducts;
    @FindBy(xpath = QUANTITY_DIFFERENT_PRODUCTS)
    public WebElement quantityDifferentProduct;
    @FindBy(xpath = FIRST_ITEM_GROUP)
    public WebElement firstItemGroup;
    @FindBy(xpath = SUBTOTAL)
    public WebElement subtotal;
    @FindBy(xpath = REFRESH_BUTTON)
    public WebElement refreshButton;
    @FindBy(xpath = REMOVE_BUTTON)
    public WebElement removeButton;
    @FindBy(xpath = EMPTY_CART)
    public WebElement emptyCart;

    public int getQuantityDifferentProducts() {
        return quantityDifferentProducts.size();
    }

    public int getSubtotal() {
        return Integer.parseInt(subtotal.getAttribute("innerText").substring(1));
    }

    public int getProductPrice() {
        return Integer.parseInt(quantityDifferentProduct.getAttribute("data-price").substring(0, 2));
    }

    public int getValue() {
        return Integer.parseInt(firstItemGroup.getAttribute("value"));
    }
}
