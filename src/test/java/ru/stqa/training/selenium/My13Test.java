package ru.stqa.training.selenium;

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
public class My13Test {
    private WebDriver driver;

    @Before
    public void start() {
        driver = new ChromeDriver();
    }

    @Test
    public void test() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,3);
        driver.get("http://localhost/litecart/en/");

        //Цикл по заполнению корзины тремя товарами
        for (int i = 1; i < 4; i++) {
            driver.findElement(By.cssSelector("div#box-most-popular li:nth-child(1)")).click();

            if (isElementPresent("select[name*=options]")) {

                Select size = new Select(driver.findElement(By.cssSelector("select[name*=options]")));
                size.selectByVisibleText("Small");
            }
            driver.findElement(By.cssSelector("button[name=add_cart_product]")).click();

            WebElement quantity = driver.findElement(By.cssSelector("span.quantity"));
            wait.until(ExpectedConditions.textToBePresentInElement(quantity, i+""));
            driver.findElement(By.cssSelector("i[title=Home]")).click();

        }

        //Переход в корзину товаров
        driver.findElement(By.linkText("Checkout »")).click();

        //Посчитаем количество строк с товарами
        int count = driver.findElements(By.cssSelector("table.dataTable.rounded-corners td.item")).size();

        //Запускаем цикл до появления на странице элемента с текстом "There are no items in your cart." - div#checkout-cart-wrapper em
        while (!isElementPresent("div#checkout-cart-wrapper em")) {
            driver.findElement(By.cssSelector("button[value=Remove]")).click();
            wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("table.dataTable.rounded-corners td.item"), count-1));
            count--;
        }
    }

    private boolean isElementPresent(String locator) {
        return driver.findElements(By.cssSelector(locator)).size() > 0;
    }

    @After
    public void finish() {
        driver.quit();
        driver = null;
    }

}
