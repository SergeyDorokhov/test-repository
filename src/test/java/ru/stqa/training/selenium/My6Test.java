package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class My6Test {
    private WebDriver driver;

    @Before
    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void my5Test() throws InterruptedException {
        driver.navigate().to("http://localhost/litecart/en/");

        //Находим количество товаров в блоке Most Popular
        int countGoods = driver.findElements(By.cssSelector("div#box-most-popular li")).size();
        System.out.println("Количество товаров в блоке Most Popular: " + countGoods);

        //Проверяем, что у каждого товара есть стикер и стикер только один
        for (int i = 1; i <= countGoods; i++) {
            int countSticker = driver.findElements(By.cssSelector("div#box-most-popular li:nth-child("+i+") div.sticker")).size();
            System.out.println("Число стикеров у " + i +"-го товара: " + countSticker);
            assertThat(countSticker, is(1));
        }

        //Находим количество товаров в блоке Campaigns
        countGoods = driver.findElements(By.cssSelector("div#box-campaigns li")).size();
        System.out.println("\nКоличество товаров в блоке Campaigns: " + countGoods);

        //Проверяем, что у каждого товара есть стикер и стикер только один
        for (int i = 1; i <= countGoods; i++) {
            int countSticker = driver.findElements(By.cssSelector("div#box-campaigns li:nth-child("+i+") div.sticker")).size();
            System.out.println("Число стикеров у " + i +"-го товара: " + countSticker);
            assertThat(countSticker, is(1));
        }

        //Находим количество товаров в блоке Latest Products
        countGoods = driver.findElements(By.cssSelector("div#box-latest-products li")).size();
        System.out.println("\nКоличество товаров в блоке Latest Products: " + countGoods);

        //Проверяем, что у каждого товара есть стикер и стикер только один
        for (int i = 1; i <= countGoods; i++) {
            int countSticker = driver.findElements(By.cssSelector("div#box-latest-products li:nth-child("+i+") div.sticker")).size();
            System.out.println("Число стикеров у " + i +"-го товара: " + countSticker);
            assertThat(countSticker, is(1));
        }

    }
    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}