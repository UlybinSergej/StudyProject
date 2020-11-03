package services;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.LoginPage;
import pages.PageBase;

public class Application extends PageBase {

    public Application(WebDriver driver) {
        super(driver);
    }

    public void login() {
        LoginPage loginPage = new LoginPage();
        driver.get(loginPage.getUrl());
        loginPage.loginInput.sendKeys(loginPage.getLogin());
        loginPage.passwordInput.sendKeys(loginPage.getPassword());
        loginPage.loginButton.click();
    }


}
