package ru.stqa.training.selenium.objects.tests;

import org.junit.After;
import org.junit.Before;
import ru.stqa.training.selenium.objects.app.Application;

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
