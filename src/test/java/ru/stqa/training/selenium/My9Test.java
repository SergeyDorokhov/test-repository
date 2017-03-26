package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Doroh on 26.03.2017.
 */
public class My9Test {
    private WebDriver driver;
    private boolean isAlphabet = false;

    @Before
    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void Test() throws InterruptedException {
        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.cssSelector("div.content [name=username]")).sendKeys("admin");
        driver.findElement(By.cssSelector("div.content [name=password]")).sendKeys("admin");
        driver.findElement(By.cssSelector("div.footer [name=login]")).click();

        driver.findElement(By.linkText("Countries")).click();

        // Получаем список стран
        List<WebElement> listCountryName = driver.findElements(By.cssSelector("table.dataTable tr.row td:nth-child(5)"));

        //Проверяем, что каждая следующая страна списке идет в алфавитном порядке
        for (int i = 0; i < listCountryName.size() - 1; i++) {
            if(listCountryName.get(i+1).getText().compareTo(listCountryName.get(i).getText()) > 0) {
                isAlphabet = true;
            }
            assertThat(isAlphabet, is(true));
        }

        //Получаем список количества зон у каждой страны
        List<WebElement> listZones = driver.findElements(By.cssSelector("table.dataTable tr.row td:nth-child(6)"));

        //Список стран, у которых количество зон != 0
        List<Integer> listZonesNotNull = new LinkedList<Integer>();

        //Заполняем listZonesNotNull
        for (int i = 0; i < listZones.size(); i++) {
            if (Integer.parseInt(listZones.get(i).getText())!= 0) {
                listZonesNotNull.add(i+2);
            }
        }

        //Переходим по ссылкам в те страны, где количество зон != 0
        for (int i = 0; i < listZonesNotNull.size(); i++) {
            int x = listZonesNotNull.get(i);
            driver.findElement(By.cssSelector("table.dataTable tr.row:nth-child("+x+") a")).click();
            Thread.sleep(4000);
            driver.findElement(By.cssSelector("ul#box-apps-menu li.selected a")).click();
            Thread.sleep(4000);
        }
    }

    @After
    public void stop() {
        driver.close();
        driver = null;
    }
}
