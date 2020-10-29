package task10;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import task9.Config;

public class Task10 extends Config {

    private final By POPULAR_PRODUCTS = By.xpath("//section[@id='box-popular-products']");
    private final String PRODUCT_NAME_MAIN_MENU = "//*[@id='box-popular-products']/div/article[]/a";
    private final String PRODUCT_PRICE_MINE_MENU = "//*[@id='box-popular-products']/div/article[]/a/div[2]/div[2]/";
    private final String PRODUCT_OBJECT = "//*[@id='box-popular-products']/div/article[]";
    private final By PRODUCT_NAME_PAGE = By.xpath("//h1");
    private final String PRODUCT_PRICE_PAGE = "//form/div[@class='price-wrapper']/";
    private final By PRODUCT_CAMPAIGN_PRICE_PAGE = By.xpath("//strong[@class='campaign-price']");

    @Test
    public void testOne() {
        driver.get("http://localhost/litecart/");
        int count = driver.findElement(POPULAR_PRODUCTS).findElements(By.cssSelector("div > article")).size();
        for (int i = 1; i <= count; i++) {
            String mainMenuName = driver.findElement(By.xpath(PRODUCT_NAME_MAIN_MENU.substring(0, 44) + i + PRODUCT_NAME_MAIN_MENU.substring(44)))
                    .getAttribute("title");
            String mainMenuCampaignPrice = null;
            if (!driver.findElements(By.xpath(PRODUCT_PRICE_MINE_MENU.substring(0, 44) + i + PRODUCT_PRICE_MINE_MENU.substring(44) + "del")).isEmpty()) {
                mainMenuCampaignPrice = driver.findElement(By.xpath(PRODUCT_PRICE_MINE_MENU.substring(0, 44) + i +
                        PRODUCT_PRICE_MINE_MENU.substring(44) + "strong")).getAttribute("innerText");
                String mainMenuRegularPrice = driver.findElement(By.xpath(PRODUCT_PRICE_MINE_MENU.substring(0, 44) + i +
                        PRODUCT_PRICE_MINE_MENU.substring(44) + "del")).getAttribute("innerText");
                Assert.assertTrue(checkName(driver.findElement(By.xpath(PRODUCT_OBJECT.substring(0, 44) + i + PRODUCT_OBJECT.substring(44))), mainMenuName,
                        mainMenuRegularPrice, mainMenuCampaignPrice));
            } else {
                String mainMenuRegularPrice = driver.findElement(By.xpath(PRODUCT_PRICE_MINE_MENU.substring(0, 44) + i +
                        PRODUCT_PRICE_MINE_MENU.substring(44) + "span")).getAttribute("innerText");
                Assert.assertTrue(checkName(driver.findElement(By.xpath(PRODUCT_OBJECT.substring(0, 44) + i + PRODUCT_OBJECT.substring(44))), mainMenuName, mainMenuRegularPrice));
            }
            driver.findElement(By.xpath("//*[@id='header']/a")).click();
        }
    }

    public boolean checkName(WebElement element, String mainMenuName, String mainMenuRegularPrice) {
        element.click();
        return driver.findElement(PRODUCT_NAME_PAGE).getAttribute("innerText").equals(mainMenuName) &&
                driver.findElement(By.xpath(PRODUCT_PRICE_PAGE + "span")).getAttribute("innerText").equals(mainMenuRegularPrice);
    }

    public boolean checkName(WebElement element, String mainMenuName, String mainMenuRegularPrice, String mainMenuCampaignPrice) {
        element.click();
        return driver.findElement(PRODUCT_NAME_PAGE).getAttribute("innerText").equals(mainMenuName) &&
                driver.findElement(By.xpath(PRODUCT_PRICE_PAGE + "del")).getAttribute("innerText").equals(mainMenuRegularPrice) &&
                driver.findElement(PRODUCT_CAMPAIGN_PRICE_PAGE).getAttribute("innerText").equals(mainMenuCampaignPrice) &&
                checkFont(driver.findElement(By.xpath(PRODUCT_PRICE_PAGE + "del")).getCssValue("text-decoration")) &&
                checkGrayColor(driver.findElement(By.xpath(PRODUCT_PRICE_PAGE + "del")).getCssValue("color")) &&
                checkRedColor(driver.findElement(PRODUCT_CAMPAIGN_PRICE_PAGE).getCssValue("color")) &&
                checkFontsSize(driver.findElement(By.xpath(PRODUCT_PRICE_PAGE + "del")).getCssValue("font-size"),
                        driver.findElement(PRODUCT_CAMPAIGN_PRICE_PAGE).getCssValue("font-size"));
    }

    public boolean checkFont(String font) {
        return font.contains("line-through");
    }

    public boolean checkGrayColor(String str) {
        String[] color = str.substring(5, str.length() - 3).replaceAll("\\s+", "").split(",");
        return color[0].equals(color[1]) && color[0].equals(color[2]);
    }

    public boolean checkRedColor(String str) {
        String[] color = str.substring(5, str.length() - 3).replaceAll("\\s+", "").split(",");
        return color[1].equals(color[2]) && !color[0].equals(color[2]);
    }

    public boolean checkFontsSize(String fontOne, String fontTwo) {
        return Double.parseDouble(fontOne.substring(0, fontOne.length() - 2)) <
                Double.parseDouble(fontTwo.substring(0, fontTwo.length() - 2));
    }
}
