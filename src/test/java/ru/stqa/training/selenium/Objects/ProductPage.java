package ru.stqa.training.selenium.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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


}
