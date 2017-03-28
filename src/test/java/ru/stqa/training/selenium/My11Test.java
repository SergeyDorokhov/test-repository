package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by Doroh on 28.03.2017.
 */
public class My11Test {
    private WebDriver driver;

    @Before
    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void test() throws InterruptedException {
        String email = new Date().getTime()+"@mail.ru";
        String phone = "+79131233807";
        String password = "123456";

        //Регистрация нового пользователя
        driver.get("http://localhost/litecart/en/");
        driver.findElement(By.cssSelector("div.left [href*=create_account]")).click();
        driver.findElement(By.cssSelector("input[name=firstname]")).sendKeys("Sergey");
        driver.findElement(By.cssSelector("input[name=lastname]")).sendKeys("Dorokhov");
        driver.findElement(By.cssSelector("input[name=address1]")).sendKeys("Abc street");
        driver.findElement(By.cssSelector("input[name=postcode]")).sendKeys("12345");
        driver.findElement(By.cssSelector("input[name=city]")).sendKeys("City");
        driver.findElement(By.cssSelector("span[role=presentation]")).click();
        driver.findElement(By.cssSelector("input[type=search]")).sendKeys("united state" + Keys.ENTER);
        driver.findElement(By.cssSelector("input[name=email]")).sendKeys(email);
        driver.findElement(By.cssSelector("input[name=phone]")).sendKeys(phone);
        driver.findElement(By.cssSelector("input[name=password]")).sendKeys(password);
        driver.findElement(By.cssSelector("input[name=confirmed_password]")).sendKeys(password);
        driver.findElement(By.cssSelector("button[name=create_account]")).click();
        driver.findElement(By.linkText("Logout")).click();

        //Вход в созданный личный кабинет
        driver.findElement(By.cssSelector("input[name=email]")).sendKeys(email);
        driver.findElement(By.cssSelector("input[name=password]")).sendKeys(password);
        driver.findElement(By.cssSelector("button[name=login]")).click();

        //Выход
        driver.findElement(By.linkText("Logout")).click();
    }

    @After
    public void finish() {
        driver.quit();
        driver = null;
    }
}
