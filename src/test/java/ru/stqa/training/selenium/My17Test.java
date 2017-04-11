package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntry;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


/**
 * Created by Doroh on 11.04.2017.
 */
public class My17Test {
    WebDriver driver;

    @Before
    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void my17Test() throws InterruptedException {
        List<WebElement> list;
        List<LogEntry> listLogs;

        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.cssSelector("input[name=username]")).sendKeys("admin");
        driver.findElement(By.cssSelector("input[name=password]")).sendKeys("admin" + Keys.ENTER);
        driver.findElement(By.linkText("Catalog")).click();
        driver.findElement(By.linkText("Rubber Ducks")).click();

        int countProducts = driver.findElements(By.cssSelector("tr.row td:nth-child(3) a[href*=product]")).size();

        for (int i = 0; i < countProducts; i++) {
            list = driver.findElements(By.cssSelector("tr.row td:nth-child(3) a[href*=product]"));
            list.get(i).click();
            //Получаем элементы протокола ввиде списка
            listLogs = driver.manage().logs().get("browser").getAll();
            //Выводит сообщение на консоль
            for (LogEntry l : listLogs) {
                System.out.println(l);
            }
            //Можно уронить тест, если если размер списка != нулю
            //assertThat(listLogs.size(), is(0));

            driver.findElement(By.cssSelector("button[name=cancel]")).click();
        }
    }

    @After
    public void finish() {
        driver.quit();
        driver = null;
    }
}
