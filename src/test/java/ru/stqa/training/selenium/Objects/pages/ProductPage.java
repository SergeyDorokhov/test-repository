package ru.stqa.training.selenium.Objects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Doroh on 14.04.2017.
 */
    public class ProductPage {
    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement addProductToCart() {
        return driver.findElement(By.cssSelector("button[name=add_cart_product]"));
    }
    public WebElement findQuantity() {
        return driver.findElement(By.cssSelector("span.quantity"));
    }
    public WebElement selectSize() {
        return driver.findElement(By.cssSelector("select[name*=options]"));
    }
    public void addProductsToCart(WebDriverWait wait, int i) {
        if (isElementPresent("select[name*=options]")) {
            new Select(selectSize()).selectByVisibleText("Small");
        }
        addProductToCart().click();
        wait.until(ExpectedConditions.textToBePresentInElement(findQuantity(), i+1+""));

    }
    public boolean isElementPresent(String locator) {
        return driver.findElements(By.cssSelector(locator)).size() > 0;
    }


}
