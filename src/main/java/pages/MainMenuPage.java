package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainMenuPage extends PageBase{
    private static final String CORRECT_TITLE = "Dashboard | My Store";
    private static final String ELEMENT_FOR_WAIT = "//img[@alt='My Store']";

    public MainMenuPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ELEMENT_FOR_WAIT)
    public WebElement elementForWait;

    public String getCorrectTitle() {
        return CORRECT_TITLE;
    }
}
