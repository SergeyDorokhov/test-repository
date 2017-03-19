package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class MyThirdTest {
    private WebDriver driver;

    @Before
    public void start() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(FirefoxDriver.MARIONETTE, false);
        driver = new FirefoxDriver(caps);
    }

    @Test
    public void myFirstTest()  {
        driver.navigate().to("http://lenta.ru");
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}