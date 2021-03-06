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
    public void Test() {
        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.cssSelector("div.content [name=username]")).sendKeys("admin");
        driver.findElement(By.cssSelector("div.content [name=password]")).sendKeys("admin");
        driver.findElement(By.cssSelector("div.footer [name=login]")).click();

        driver.findElement(By.linkText("Countries")).click();

        // Получаем список стран
        List<WebElement> listCountryName = driver.findElements(By.cssSelector("table.dataTable tr.row td:nth-child(5)"));

        //Проверяем, что каждая следующая страна в списке идет в алфавитном порядке
        for (int i = 0; i < listCountryName.size() - 1; i++) {
            if(listCountryName.get(i+1).getAttribute("innerText").compareTo(listCountryName.get(i).getAttribute("innerText")) > 0) {
                isAlphabet = true;
            }
            assertThat(isAlphabet, is(true));
        }

        //Получаем список количества зон у каждой страны
        List<WebElement> listZones = driver.findElements(By.cssSelector("table.dataTable tr.row td:nth-child(6)"));

        //Список стран, у которых количество зон != 0
        List<Integer> listZonesNotNull = new ArrayList<Integer>();

        //Заполняем listZonesNotNull
        for (int i = 0; i < listZones.size(); i++) {
            if (Integer.parseInt(listZones.get(i).getText())!= 0) {
                listZonesNotNull.add(i+2);
            }
        }

        //Переходим по ссылкам в те страны, где количество зон != 0
        for (int i = 0; i < listZonesNotNull.size(); i++) {
            int numberCountry = listZonesNotNull.get(i);
            driver.findElement(By.cssSelector("table.dataTable tr.row:nth-child("+numberCountry+") a")).click();

           //Получаем список зон
            List<WebElement> listZoneName = driver.findElements(By.cssSelector("table.dataTable tr td:nth-child(3) input[type=hidden]"));

            //Проверяем, что зоны идут по алфавиту
            for (int j = 0; j < listZoneName.size() - 1; j++) {
            if(listZoneName.get(j+1).getAttribute("defaultValue").compareTo(listZoneName.get(j).getAttribute("defaultValue")) > 0) {
                isAlphabet = true;
            }
            assertThat(isAlphabet, is(true));
            }

            //Возвращаемся к списку стран
            driver.findElement(By.cssSelector("ul#box-apps-menu li.selected a")).click();

        }
        //Переходим на страницу http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones
        driver.findElement(By.linkText("Geo Zones")).click();


        //Находим элементы - страны
        listCountryName = driver.findElements(By.cssSelector("tr.row td:nth-child(3) a"));
        List<String> stringListCountryName = new ArrayList<String>();

        //Сохраняем названия стран в список строк
        for (int i = 0; i < listCountryName.size(); i++) {
            stringListCountryName.add(listCountryName.get(i).getAttribute("innerText"));
        }

        //Переходим в страну и создаем список зон
        for (int i = 0; i < stringListCountryName.size(); i++) {
            driver.findElement(By.linkText(stringListCountryName.get(i))).click();
            List<WebElement> countryZone = driver.findElements(By.cssSelector("table.dataTable td:nth-child(3) option[selected=selected]"));

        //проверяем расположение зон в алфавитном порядке
            for (int j = 0; j < countryZone.size() - 1; j++) {
            if(countryZone.get(j+1).getAttribute("innerText").compareTo(countryZone.get(j).getAttribute("innerText")) > 0) {
                isAlphabet = true;
            }
            assertThat(isAlphabet, is(true));
        }
            //Возвращаемся на страницу Гео зоны для нового витка цикла
            driver.findElement(By.linkText("Geo Zones")).click();
        }
    }

    @After
    public void stop() {
        driver.close();
        driver = null;
    }
}
