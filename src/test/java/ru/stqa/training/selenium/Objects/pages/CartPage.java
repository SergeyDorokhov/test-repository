package ru.stqa.training.selenium.Objects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Doroh on 14.04.2017.
 */
public class CartPage {
    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement buttonRemove() {
        return driver.findElement(By.cssSelector("button[value=Remove]"));
    }
    public int numbersRow() {
        return driver.findElements(By.cssSelector("table.dataTable.rounded-corners td.item")).size();
    }
    public WebElement returnToHome() {
        return driver.findElement(By.cssSelector("i[title=Home]"));
    }

    public void deleteAllProducts(WebDriverWait wait, int count) throws InterruptedException {
    while (!isElementPresent("div#checkout-cart-wrapper em")) {
        buttonRemove().click();
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("table.dataTable.rounded-corners td.item"), count - 1));
        count--;
        Thread.sleep(1000);
    }
    }
    public boolean isElementPresent(String locator) {
        return driver.findElements(By.cssSelector(locator)).size() > 0;
    }
}
