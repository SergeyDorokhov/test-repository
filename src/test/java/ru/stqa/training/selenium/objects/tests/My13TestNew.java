package ru.stqa.training.selenium.objects.tests;

import org.junit.Test;

/**
 * Created by Doroh on 01.04.2017.
 */
public class My13TestNew extends TestBase {

    @Test
    public void addProductsToCartAndDeleteThem() throws InterruptedException {
        app.goToHomePage();
        for (int i = 0; i < app.data.getCountOfProducts() ; i++) {
            app.selectProduct();
            app.addProductToCart(i);
            app.returnToHome();
        }
        app.goToCartPage();
        app.deleteAllProducts();
    }
}
