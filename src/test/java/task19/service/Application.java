package task19.service;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import task19.page.MainMenuPage;
import task19.page.ProductPage;
import task19.page.ShopCartPage;
import task19.test.Config;

public class Application extends Config {
    private MainMenuPage mainMenuPage = new MainMenuPage();
    private ProductPage productPage = new ProductPage();
    private ShopCartPage shopCartPage = new ShopCartPage();

    public void addProductsToCart() {
        for (int i = 1; i <= productPage.getQuantityProductsInCart(); i++) {
            mainMenuPage.mainMenuPage();
            wait.until(ExpectedConditions.visibilityOf(mainMenuPage.Product));
            mainMenuPage.getProduct().click();
            wait.until(ExpectedConditions.visibilityOf(productPage.addToCartButton));
            productPage.addToCartButton.click();
            wait.until(ExpectedConditions.attributeContains(productPage.goToCartButton, "innerText", "" + i + ""));
        }
        productPage.goToCartButton.click();
        wait.until(ExpectedConditions.visibilityOf(shopCartPage.removeButton));
    }

    public void removeProductsFromCart() {
        for (int i = 1; i <= shopCartPage.getQuantityDifferentProducts(); i++) {
            if (shopCartPage.getValue() > 1) {
                shopCartPage.firstItemGroup.sendKeys(Keys.DELETE);
                shopCartPage.firstItemGroup.sendKeys(String.valueOf(shopCartPage.getValue() - 1));
                shopCartPage.refreshButton.click();
            } else {
                shopCartPage.removeButton.click();
            }
            wait.until(ExpectedConditions.attributeContains(shopCartPage.subtotal, "innerText",
                    "$" + (shopCartPage.getSubtotal() - shopCartPage.getProductPrice())));
        }
        shopCartPage.removeButton.click();
        wait.until(ExpectedConditions.visibilityOf(shopCartPage.emptyCart));
    }
}
