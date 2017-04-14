package ru.stqa.training.selenium.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
}
