package services;

import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.LoginPage;
import pages.MainMenuPage;
import pages.PageBase;

public class Application extends PageBase {
    private LoginPage loginPage;
    private MainMenuPage mainMenuPage;

    public void login() {
        loginPage = new LoginPage();
        mainMenuPage = new MainMenuPage();
        driver.get(loginPage.getUrl());
        loginPage.loginInput.sendKeys(loginPage.getLogin());
        loginPage.passwordInput.sendKeys(loginPage.getPassword());
        loginPage.loginButton.click();
        wait.until(ExpectedConditions.visibilityOf(mainMenuPage.elementForWait));
    }

    public void checkPage() {
        Assert.assertEquals(mainMenuPage.getCorrectTitle(), driver.getTitle());
    }
}
