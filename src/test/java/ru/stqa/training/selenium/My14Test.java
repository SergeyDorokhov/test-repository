package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by Doroh on 04.04.2017.
 */
public class My14Test {
    private WebDriver driver;


    @Before
    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void test() {
        List<WebElement> list;
        Set<String> set;

        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.cssSelector("input[name=username]")).sendKeys("admin");
        driver.findElement(By.cssSelector("input[name=password]")).sendKeys("admin" + Keys.ENTER);
        driver.findElement(By.cssSelector("a[href*=countries]")).click();
        driver.findElement(By.linkText("Afghanistan")).click();

        int numberOfExternalLink = driver.findElements(By.cssSelector("i.fa.fa-external-link")).size();

        //Поочерендно кликаем по внешней ссылке, переходим на новую вкладку, закрываем ее, возвращаемся на исходную страницу
        for (int i = 0; i < numberOfExternalLink; i++) {
            list = driver.findElements(By.cssSelector("i.fa.fa-external-link"));
            list.get(i).click();
            set = driver.getWindowHandles();
            for (String s : set) {
                if (!s.equals(driver.getWindowHandle())) {
                    driver.switchTo().window(s);
                    driver.close();
                    set = driver.getWindowHandles();
                    for (String s1 : set) {
                        driver.switchTo().window(s1);
                    }
                }
            }
        }
        //Откроем все внешние ссылки и посчитаем их количество. С учетом исходной страницы число страниц будет равно 8
        list = driver.findElements(By.cssSelector("i.fa.fa-external-link"));
        for (int i = 0; i < numberOfExternalLink; i++) {
            list.get(i).click();
        }
        assertThat(driver.getWindowHandles().size(), is(8));
    }

    @After
    public void finish () {
        driver.quit();
        driver = null;
    }
}