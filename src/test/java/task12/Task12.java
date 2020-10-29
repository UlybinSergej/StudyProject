package task12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import task11.Config;

import java.io.File;

public class Task12 extends Config {

    @Test
    public void testOne() throws InterruptedException {
        String productName = "Phone";
        String productCode = "123321";
        String shortDescription = "Some short Description";
        String description = "Some description";
        String technicalData = "Some Technical Data";
        String headTitle = "Some Head Title";
        String metaDescription = "Some Meta Description";
        String price = "150";
        String pathToPicture = new File("src/test/java/task12/picture.jpg").getAbsolutePath();

        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.cssSelector("#box-login > form > div.footer > button")).click();
        waitElement(By.xpath("//li[@data-code='catalog']"));
        driver.findElement(By.xpath("//li[@data-code='catalog']")).click();
        waitElement(By.xpath("//a[@href='http://localhost/litecart/admin/?category_id=0&app=catalog&doc=edit_product']"));
        driver.findElement(By.xpath("//a[@href='http://localhost/litecart/admin/?category_id=0&app=catalog&doc=edit_product']")).click();
        waitElement(By.xpath("//input[@name='name[en]']"));
        driver.findElement(By.xpath("//input[@name='name[en]']")).sendKeys(productName);
        driver.findElement(By.xpath("//input[@name='code']")).sendKeys(productCode);
        driver.findElement(By.xpath("//input[@name='date_valid_from']")).sendKeys("21102020");
        driver.findElement(By.xpath("//input[@name='date_valid_to']")).sendKeys("31122020");
        waitElement(By.xpath("//input[@name='new_images[]']"));
        driver.findElement(By.xpath("//input[@name='new_images[]']")).sendKeys(pathToPicture);
        waitElement(By.xpath("//a[text()='Information']"));
        driver.findElement(By.xpath("//a[text()='Information']")).click();
        driver.findElement(By.xpath("//input[@name='short_description[en]']")).sendKeys(shortDescription);
        driver.findElement(By.xpath("//div[@dir='ltr']")).sendKeys(description);
        driver.findElement(By.xpath("//textarea[@name='technical_data[en]']")).sendKeys(technicalData);
        driver.findElement(By.xpath("//input[@name='head_title[en]']")).sendKeys(headTitle);
        driver.findElement(By.xpath("//input[@name='meta_description[en]']")).sendKeys(metaDescription);
        driver.findElement(By.xpath("//a[text()='Prices']")).click();
        driver.findElement(By.xpath("//select[@name='purchase_price_currency_code']")).click();
        driver.findElement(By.xpath("//option[@value='USD']")).click();
        driver.findElement(By.xpath("//input[@name='prices[USD]']")).sendKeys(price);
        driver.findElement(By.xpath("//button[@value='Save']")).click();
        for (int i = 1; i <= driver.findElements(By.xpath("//table[@class='table table-striped table-hover data-table']/tbody/tr")).size(); i++) {
            if (!driver.findElements(By.xpath("//table[@class='table table-striped table-hover data-table']/tbody/tr[" + i + "]/td/a[text()='Phone']")).isEmpty()) {
                Assert.assertTrue(driver.findElement(By.xpath("//table[@class='table table-striped table-hover data-table']/tbody/tr["
                        + i + "]/td/a")).getAttribute("innerText").equals(productName));
            }
        }
    }

    public void waitElement(By by) {
        wait.until(webDriver -> webDriver.findElement(by).isDisplayed());
    }
}

