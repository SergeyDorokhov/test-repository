package ru.stqa.training.selenium.Objects;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Doroh on 14.04.2017.
 */
public class TestBase {
    public Application app;

    @Before
    public void start() {
        app = new Application();
    }

    @After
    public void finish() {
        app.quit();
    }
}
