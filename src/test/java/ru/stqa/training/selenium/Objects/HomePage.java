package ru.stqa.training.selenium.Objects;

import org.openqa.selenium.WebDriver;

/**
 * Created by Doroh on 14.04.2017.
 */
public class HomePage {
    WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
        }

    public void open(){
        driver.get("http://localhost/litecart/en/");
    }
}
