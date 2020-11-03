package lesson4.services;

import lesson4.pages.LoginPage;
import lesson4.pages.MainMenuPage;
import lesson4.pages.MainPage;
import lesson4.pages.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.junit.Assert;

public class Application extends PageBase {
    private MainMenuPage mainMenuPage;

    public void login() {
        LoginPage loginPage = new LoginPage();
        mainMenuPage = new MainMenuPage();
        driver.get(loginPage.getUrl());
        loginPage.loginInput.sendKeys(loginPage.getLogin());
        loginPage.passwordInput.sendKeys(loginPage.getPassword());
        loginPage.loginButton.click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(mainMenuPage.getLeftMenu()))));
    }

    public void checkLeftMenu() {
        int countI = driver.findElements(By.xpath(mainMenuPage.getLeftMenu())).size();
        for (int i = 1; i <= countI; i ++) {
            driver.findElement(By.xpath(mainMenuPage.getLeftMenu() + "[" + i + "]")).click();
            int countJ = driver.findElements(By.xpath(mainMenuPage.getLeftMenu() + "[" + i + "]/ul/li")).size();
            for (int j = 1; j <= countJ; j ++) {
                driver.findElement(By.xpath(mainMenuPage.getLeftMenu() + "[" + i + "]/ul/li[" + j + "]")).click();
            }
        }
    }

    public void checkStickers() {
        MainPage mainPage = new MainPage();
        driver.get(mainPage.getUrl());
        int sectionCount = driver.findElements(By.xpath(mainPage.getSection())).size();
        for (int i = 0; i < sectionCount; i ++) {
            int duckCount = driver.findElements(By.xpath(mainPage.getProduct().replace("sectionName", mainPage.getSectionNames()[i]))).size();
            for (int j = 1; j <= duckCount; j ++) {
                Assert.assertEquals(driver.findElements(By.xpath(mainPage.getStickers().replace("sectionName", mainPage.getSectionNames()[i])
                .replace("articleCount", String.valueOf(j)))).size(), 1);
            }

        }

    }

}
