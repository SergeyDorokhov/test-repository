package ru.stqa.training.selenium.Objects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Doroh on 14.04.2017.
 */
public class HomePage {
    WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
        }

    public void open(){
        driver.get("http://localhost/litecart/en/");
    }
    public WebElement goToProductPage() {
        return driver.findElement(By.linkText("Checkout »"));
    }
    public WebElement selectProduct() {
        return driver.findElement(By.cssSelector("div#box-most-popular li:nth-child(1)"));
    }
}
