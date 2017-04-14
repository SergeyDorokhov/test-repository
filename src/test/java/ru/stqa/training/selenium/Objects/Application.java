package ru.stqa.training.selenium.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Doroh on 14.04.2017.
 */
    public class Application {
        public WebDriver driver;
        private WebDriverWait wait;
        Data data;
        private HomePage homePage;
        private CartPage cartPage;
        private ProductPage productPage;

    Application() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,3);
        data = new Data();
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);
        productPage = new ProductPage(driver);
    }

    void goToHomePage() {
        homePage.open();
    }

    void selectProduct() {
        homePage.selectProduct().click();
    }

    void goToProductPage() {
        homePage.goToProductPage().click();
    }

    void returnToHome() {
        cartPage.returnToHome().click();
    }

    void deleteAllProducts(int count) throws InterruptedException {
        while (!isElementPresent("div#checkout-cart-wrapper em")) {
            cartPage.buttonRemove().click();
            wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("table.dataTable.rounded-corners td.item"), count-1));
            count--;
            Thread.sleep(1000);
        }
    }

    int countNumberRowsProductsInCart() {
        return cartPage.numbersRow();
    }

    void addProductToCart(int i) {
        if (isElementPresent("select[name*=options]")) {
            new Select(productPage.selectSize()).selectByVisibleText("Small");
        }
        productPage.addProductToCart().click();
        wait.until(ExpectedConditions.textToBePresentInElement(productPage.findQuantity(), i+1+""));
    }

    public boolean isElementPresent(String locator) {
        return driver.findElements(By.cssSelector(locator)).size() > 0;
    }

    public void quit() {
        driver.quit();
        driver = null;
    }
}
