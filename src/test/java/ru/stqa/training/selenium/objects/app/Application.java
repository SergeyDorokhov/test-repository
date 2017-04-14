package ru.stqa.training.selenium.objects.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.stqa.training.selenium.objects.data.Data;
import ru.stqa.training.selenium.objects.pages.CartPage;
import ru.stqa.training.selenium.objects.pages.HomePage;
import ru.stqa.training.selenium.objects.pages.ProductPage;

/**
 * Created by Doroh on 14.04.2017.
 */
    public class Application {
        public WebDriver driver;
        private WebDriverWait wait;
        public Data data;
        private HomePage homePage;
        private CartPage cartPage;
        private ProductPage productPage;

    public Application() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,3);
        data = new Data();
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);
        productPage = new ProductPage(driver);
    }

    public void goToHomePage() {
        homePage.open();
    }

    public void selectProduct() {
        homePage.selectProduct().click();
    }

    public void goToCartPage() {
        homePage.goToCartPage().click();
    }

    public void returnToHome() {
        cartPage.returnToHome().click();
    }

    public void deleteAllProducts() throws InterruptedException {
        cartPage.deleteAllProducts(wait, countNumberRowsProductsInCart());
    }

    public int countNumberRowsProductsInCart() {
        return cartPage.numbersRow();
    }

    public void addProductToCart(int i) {
        productPage.addProductsToCart(wait, i);
    }

    public void quit() {
        driver.quit();
        driver = null;
    }
}
