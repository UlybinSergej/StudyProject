package task19.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import task19.test.Config;

import java.util.List;

public class MainMenuPage extends Config {
    private static final String START_PAGE_URL = "http://localhost/litecart/";
    private static final String LIST_OF_PRODUCTS = "//section[@id='box-popular-products']/div[@class='listing products']/article";

    public MainMenuPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = LIST_OF_PRODUCTS)
    private List<WebElement> listOfProducts;

    @FindBy(xpath = LIST_OF_PRODUCTS)
    public WebElement Product;

    public void mainMenuPage() {
        driver.get(START_PAGE_URL);
    }

    public int listOfProducts() {
        return listOfProducts.size();
    }

    public WebElement getProduct() {
        return listOfProducts.get(random.nextInt(listOfProducts()));
    }
}
