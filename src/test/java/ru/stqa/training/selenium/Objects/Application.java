package ru.stqa.training.selenium.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Doroh on 14.04.2017.
 */
    public class Application {
    public WebDriver driver;
    public WebDriverWait wait;
    Data data;
    HomePage homePage;

    public Application() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,3);
        data = new Data();
        homePage = new HomePage(driver);
    }

    public void quit() {
        driver.quit();
        driver = null;
    }

    public void goToHomePage() {
        homePage.open();
    }

    public void deleteAllProducts(int count) throws InterruptedException {
        while (!isElementPresent("div#checkout-cart-wrapper em")) {
            driver.findElement(By.cssSelector("button[value=Remove]")).click();
            wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("table.dataTable.rounded-corners td.item"), count-1));
            count--;
            Thread.sleep(2000);
        }
    }

    public int countNumberRowsProductsInCart() {
        return driver.findElements(By.cssSelector("table.dataTable.rounded-corners td.item")).size();
    }

    public void goToCart() {
        driver.findElement(By.linkText("Checkout »")).click();
    }

    public void returnToHome() {
        driver.findElement(By.cssSelector("i[title=Home]")).click();
    }

    public void addProductToCart(int i) {
        if (isElementPresent("select[name*=options]")) {

            Select size = new Select(driver.findElement(By.cssSelector("select[name*=options]")));
            size.selectByVisibleText("Small");
        }
        driver.findElement(By.cssSelector("button[name=add_cart_product]")).click();

        WebElement quantity = driver.findElement(By.cssSelector("span.quantity"));
        wait.until(ExpectedConditions.textToBePresentInElement(quantity, i+1+""));
    }

    public void selectProduct() {

        driver.findElement(By.cssSelector("div#box-most-popular li:nth-child(1)")).click();
    }

    public boolean isElementPresent(String locator) {
        return driver.findElements(By.cssSelector(locator)).size() > 0;
    }
}
