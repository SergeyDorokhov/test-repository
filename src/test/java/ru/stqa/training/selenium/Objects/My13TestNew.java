package ru.stqa.training.selenium.Objects;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Doroh on 01.04.2017.
 */
public class My13TestNew extends TestBase{

    @Test
    public void addProductsToCartAndDeleteThem() throws InterruptedException {
        app.goToHomePage();
        for (int i = 0; i < app.data.getCountOfProducts() ; i++) {
            app.selectProduct();
            app.addProductToCart(i);
            app.returnToHome();
        }
        app.goToCart();
        app.deleteAllProducts(app.countNumberRowsProductsInCart());
    }
}
