package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

/**
 * Created by Doroh on 29.03.2017.
 */
public class My12Test {
    private WebDriver driver;

    @Before
    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void test() throws InterruptedException {
        Select sel;

        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.cssSelector("input[name=username]")).sendKeys("admin");
        driver.findElement(By.cssSelector("input[name=password]")).sendKeys("admin");
        driver.findElement(By.cssSelector("button[name=login]")).click();
        driver.findElement(By.cssSelector("[href*=catalog]")).click();

        driver.findElement(By.cssSelector("td#content [href*=product]")).click();

        //Заполняем вкладку General
        driver.findElement(By.cssSelector("input[name=status]")).click();
        driver.findElement(By.cssSelector("span.input-wrapper input[name*=name]")).sendKeys("New product");
        driver.findElement(By.cssSelector("input[name=code]")).sendKeys("New product code");
        driver.findElement(By.cssSelector("input[data-name*=Rubber]")).click();

        sel = new Select(driver.findElement(By.cssSelector("select[name=default_category_id]")));
        sel.selectByVisibleText("Rubber Ducks");
        driver.findElement(By.cssSelector("div.input-wrapper tr:nth-child(4) [name*=product]")).click();

        new Actions(driver).moveToElement(driver.findElement(By.cssSelector("input[name=quantity]"))).
                moveByOffset(45,0).click().click().click().click().click().perform();

        //Устанавливаем Date Valid From (DD)
        new Actions(driver).moveToElement(driver.findElement(By.cssSelector("input[name=date_valid_from]"))).
        moveByOffset(-65,0).click().perform();
        new Actions(driver).moveToElement(driver.findElement(By.cssSelector("input[name=date_valid_from]"))).
                moveByOffset(55,0).click().perform();

        //Устанавливаем Date Valid From (MM)
        new Actions(driver).moveToElement(driver.findElement(By.cssSelector("input[name=date_valid_from]"))).
                moveByOffset(-55,0).click().perform();
        new Actions(driver).moveToElement(driver.findElement(By.cssSelector("input[name=date_valid_from]"))).
                moveByOffset(55,0).click().click().click().click().perform();

        //Устанавливаем Date Valid From (YYYY)
        new Actions(driver).moveToElement(driver.findElement(By.cssSelector("input[name=date_valid_from]"))).
                moveByOffset(-35,0).click().perform();
        new Actions(driver).moveToElement(driver.findElement(By.cssSelector("input[name=date_valid_from]"))).
                moveByOffset(55,0).click().perform();

        //Переходим на вкладку Information
        driver.findElement(By.cssSelector("[href*=information]")).click();

        sel = new Select(driver.findElement(By.cssSelector("select[name=manufacturer_id]")));
        sel.selectByVisibleText("ACME Corp.");

        driver.findElement(By.cssSelector("[name=keywords]")).sendKeys("New product");
        driver.findElement(By.cssSelector("[name*=short_description]")).sendKeys("Short_description");
        driver.findElement(By.cssSelector("div.trumbowyg-editor")).sendKeys("Description");
        driver.findElement(By.cssSelector("input[name*=head_title]")).sendKeys("Head_title");
        driver.findElement(By.cssSelector("input[name*=meta_description]")).sendKeys("Meta_description");


        //Переходим на закладку Prices
        driver.findElement(By.cssSelector("[href*=prices]")).click();

        //Устанавливаем цену на товар

        new Actions(driver).moveToElement(driver.findElement(By.cssSelector("input[name=purchase_price]"))).
                moveByOffset(45,0).click().click().click().click().click().perform();
        sel = new Select(driver.findElement(By.cssSelector("select[name=purchase_price_currency_code]")));
        sel.selectByVisibleText("US Dollars");

        driver.findElement(By.cssSelector("td:nth-child(1) input[name*=USD]")).sendKeys("10");
        driver.findElement(By.cssSelector("td:nth-child(1) input[name*=EUR]")).sendKeys("8");
        driver.findElement(By.cssSelector("button[name=save]")).click();

        //Проверяем наличие товара в каталоге
        driver.findElement(By.linkText("New product"));
    }

    @After
    public void finish() {
        driver.quit();
        driver = null;
    }
}
