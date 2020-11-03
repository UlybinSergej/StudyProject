package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends PageBase {
    private static final String PAGE_URL = "http://localhost/litecart/admin";
    private static final String LOGIN = "admin";
    private static final String PASSWORD = "admin";
    private static final String LOGIN_INPUT = "//input[@placeholder='Username']";
    private static final String PASSWORD_INPUT = "//input[@placeholder='Password']";
    private static final String LOGIN_BUTTON = "//button[text()='Login']";

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = LOGIN_INPUT)
    public WebElement loginInput;
    @FindBy(xpath = PASSWORD_INPUT)
    public WebElement passwordInput;
    @FindBy(xpath = LOGIN_BUTTON)
    public WebElement loginButton;

    public String getLogin() {
        return LOGIN;
    }

    public String getPassword() {
        return PASSWORD;
    }

    public String getUrl() {
        return PAGE_URL;
    }
}
