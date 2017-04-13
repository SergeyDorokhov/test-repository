package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Doroh on 13.04.2017.
 */
public class My7Test {
    private WebDriver driver;


    @Before
    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        List<WebElement> list;
    }

    @Test
    public void my4Test() throws InterruptedException {
        int countBottomMenuItems;
        int countMenuItems;
        List<WebElement> list;

        driver.navigate().to("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin" + Keys.ENTER);

        countMenuItems = driver.findElements(By.cssSelector("li#app-> a")).size();
        for (int i = 0; i < countMenuItems; i++) {
            list = driver.findElements(By.cssSelector("li#app-> a"));
            list.get(i).click();
            driver.findElement(By.cssSelector("h1"));
            countBottomMenuItems = driver.findElements(By.cssSelector("ul.docs span.name")).size();

            for (int j = 0; j < countBottomMenuItems; j++) {
                list = driver.findElements(By.cssSelector("ul.docs span.name"));
                list.get(j).click();
                driver.findElement(By.cssSelector("h1"));
            }
        }
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
