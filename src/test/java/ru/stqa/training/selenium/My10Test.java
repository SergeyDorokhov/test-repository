package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Doroh on 26.03.2017.
 */
public class My10Test {

    private WebDriver driver;

    @Before
    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void Test() {
        driver.get("http://localhost/litecart/en/");

        //1. Проверка названия товара на главной и на странице товара

        String nameOnHead, nameOnGood;
        nameOnHead = driver.findElement(By.cssSelector("div#box-campaigns div.name")).getText();
        driver.findElement(By.cssSelector("div#box-campaigns a.link")).click();
        nameOnGood = driver.findElement(By.cssSelector("h1.title")).getText();
        assertThat(nameOnGood.equals(nameOnHead), is(true));
        driver.findElement(By.cssSelector("a i[title=Home]")).click();


        //2. Проверка регулярной и аукционной цены

        String regularPrice = driver.findElement(By.cssSelector("div#box-campaigns s.regular-price")).getAttribute("innerText");
        String campaignPrice = driver.findElement(By.cssSelector("div#box-campaigns strong.campaign-price")).getAttribute("innerText");
        driver.findElement(By.cssSelector("div#box-campaigns a.link")).click();
        String regularPriceOnGood = driver.findElement(By.cssSelector("div.price-wrapper s.regular-price")).getAttribute("innerText");
        String campaignPriceOnGood = driver.findElement(By.cssSelector("div.price-wrapper strong.campaign-price")).getAttribute("innerText");
        assertThat(regularPrice.equals(regularPriceOnGood), is(true));
        assertThat(campaignPrice.equals(campaignPriceOnGood), is(true));

        driver.findElement(By.cssSelector("a i[title=Home]")).click();

        //3. Проверка цены на главной (зачеркнута + серая)
        //Полагаем, что цена зачеркнута у класса regular-price
        assertThat(driver.findElement(By.cssSelector("div.price-wrapper s")).getAttribute("className"), is("regular-price"));
        //Проверяем, что цена - серая ("серый" цвет это такой, у которого в RGBa представлении одинаковые значения для каналов R, G и B)
        String color = driver.findElement(By.cssSelector("div.price-wrapper s")).getCssValue("color");
        String[] colors = color.split("[(,]");
        int[] x = new int[colors.length];
        for (int i = 1; i < colors.length - 1; i++) {
            x[i] = Integer.parseInt(colors[i].replace(" ",""));
        }
        assertThat(x[1] == x[2], is(true));
        assertThat(x[2] == x[3], is(true));

        //Переходим на страницу товара
        driver.findElement(By.cssSelector("div#box-campaigns a.link")).click();
        //Полагаем, что цена зачеркнута у класса regular-price
        assertThat(driver.findElement(By.cssSelector("div.price-wrapper s")).getAttribute("className"), is("regular-price"));
        //Проверяем, что цена - серая ("серый" цвет это такой, у которого в RGBa представлении одинаковые значения для каналов R, G и B)
        color = driver.findElement(By.cssSelector("div.price-wrapper s")).getCssValue("color");
        colors = color.split("[(,]");
        x = new int[colors.length];
        for (int i = 1; i < colors.length - 1; i++) {
            x[i] = Integer.parseInt(colors[i].replace(" ",""));
        }
        assertThat(x[1] == x[2], is(true));
        assertThat(x[2] == x[3], is(true));

        driver.findElement(By.cssSelector("a i[title=Home]")).click();

        //4. Проверяем аукционную цену
        //Проверяем наличие тега strong
        assertThat(driver.findElement(By.cssSelector("div#box-campaigns .campaign-price")).getTagName(), is("strong"));
        //Проверяем цвет
        color = driver.findElement(By.cssSelector("div#box-campaigns .campaign-price")).getCssValue("color");
        colors = color.split("[(,]");
        x = new int[colors.length];
        for (int i = 1; i < colors.length - 1; i++) {
            x[i] = Integer.parseInt(colors[i].replace(" ",""));
        }

        //Можно считать, что "красный" цвет это такой, у которого в RGBa представлении каналы G и B имеют нулевые значения)
        assertThat(x[2] == 0, is(true));
        assertThat(x[3] == 0, is(true));

        //Переходим на страницу товара
        driver.findElement(By.cssSelector("div#box-campaigns a.link")).click();

        //Проверяем наличие тега strong
        assertThat(driver.findElement(By.cssSelector("div.price-wrapper .campaign-price")).getTagName(), is("strong"));

        //Проверяем цвет
        color = driver.findElement(By.cssSelector("div.price-wrapper .campaign-price")).getCssValue("color");
        colors = color.split("[(,]");
        x = new int[colors.length];
        for (int i = 1; i < colors.length - 1; i++) {
            x[i] = Integer.parseInt(colors[i].replace(" ",""));
        }

        //Можно считать, что "красный" цвет это такой, у которого в RGBa представлении каналы G и B имеют нулевые значения)
        assertThat(x[2] == 0, is(true));
        assertThat(x[3] == 0, is(true));
        driver.findElement(By.cssSelector("a i[title=Home]")).click();

        //5. Проверяем, что аукционная цена крупнее (на главной странице)
        campaignPrice = driver.findElement(By.cssSelector("div#box-campaigns .campaign-price")).getSize().toString();
        regularPrice = driver.findElement(By.cssSelector("div#box-campaigns .regular-price")).getSize().toString();

        String[] dimentionCampaignPrice = campaignPrice.split("[(,)]");
        x = new int[dimentionCampaignPrice.length];
        int sumCampaignPrice = 0;
        for (int i = 1; i < dimentionCampaignPrice.length ; i++) {
            x[i] = Integer.parseInt(dimentionCampaignPrice[i].replace(" ",""));
            sumCampaignPrice += x[i];
        }

        String[] dimentionRegularPrice = regularPrice.split("[(,)]");
        x = new int[dimentionRegularPrice.length];
        int sumRegularPrice = 0;
        for (int i = 1; i < dimentionRegularPrice.length ; i++) {
            x[i] = Integer.parseInt(dimentionRegularPrice[i].replace(" ",""));
            sumRegularPrice += x[i];
        }
        assertThat(sumCampaignPrice > sumRegularPrice, is(true));

        // Проверяем, что аукционная цена крупнее (на странице товара)
        driver.findElement(By.cssSelector("div#box-campaigns a.link")).click();
        campaignPrice = driver.findElement(By.cssSelector("div.price-wrapper .campaign-price")).getSize().toString();
        regularPrice = driver.findElement(By.cssSelector("div.price-wrapper .regular-price")).getSize().toString();

        dimentionCampaignPrice = campaignPrice.split("[(,)]");
        x = new int[dimentionCampaignPrice.length];
        sumCampaignPrice = 0;
        for (int i = 1; i < dimentionCampaignPrice.length ; i++) {
            x[i] = Integer.parseInt(dimentionCampaignPrice[i].replace(" ",""));
            sumCampaignPrice += x[i];
        }

        dimentionRegularPrice = regularPrice.split("[(,)]");
        x = new int[dimentionRegularPrice.length];
        sumRegularPrice = 0;
        for (int i = 1; i < dimentionRegularPrice.length ; i++) {
            x[i] = Integer.parseInt(dimentionRegularPrice[i].replace(" ",""));
            sumRegularPrice += x[i];
        }
        assertThat(sumCampaignPrice > sumRegularPrice, is(true));
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
