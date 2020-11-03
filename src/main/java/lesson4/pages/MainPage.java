package lesson4.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage extends PageBase{
    private static final String PAGE_URL = "http://localhost/litecart/";
    private static final String PRODUCTS = "//section[@id='sectionName']/div/article";
    private static final String STICKER = "//section[@id='sectionName']/div/article[articleCount]/a/div[1]/div";
    private static final String SECTION = "//section[@class='box']";
    private static final String[] SECTION_NAMES = {"box-campaign-products", "box-popular-products", "box-latest-products"};

    public MainPage() {
        PageFactory.initElements(driver, this);
    }

    public String getUrl() {
        return PAGE_URL;
    }

    public String getStickers() {
        return STICKER;
    }

    public String getSection() {
        return SECTION;
    }

    public String[] getSectionNames() {
        return SECTION_NAMES;
    }

    public String getProduct() {
        return PRODUCTS;
    }
}
