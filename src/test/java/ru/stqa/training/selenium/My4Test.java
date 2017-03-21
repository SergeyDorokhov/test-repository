package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class My4Test{
    private WebDriver driver;

    @Before
    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void my4Test() throws InterruptedException {
        driver.navigate().to("http://localhost/litecart/admin/");

        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        driver.findElement(By.cssSelector("ul#box-apps-menu >li:nth-child(1)")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("li#doc-template")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("li#doc-logotype")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("ul#box-apps-menu >li:nth-child(2)")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("li#doc-catalog")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("li#doc-product_groups")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("li#doc-option_groups")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("li#doc-manufacturers")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("li#doc-suppliers")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("li#doc-delivery_statuses")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("li#doc-sold_out_statuses")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("li#doc-quantity_units")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("li#doc-csv")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("ul#box-apps-menu >li:nth-child(3)")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("ul#box-apps-menu >li:nth-child(4)")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("ul#box-apps-menu >li:nth-child(5)")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("li#doc-customers")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("li#doc-csv")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("li#doc-newsletter")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("ul#box-apps-menu >li:nth-child(6)")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("ul#box-apps-menu >li:nth-child(7)")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("li#doc-languages")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("li#doc-storage_encoding")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("ul#box-apps-menu >li:nth-child(8)")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("li#doc-jobs")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("li#doc-customer")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("li#doc-shipping")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("li#doc-payment")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("li#doc-order_total")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("li#doc-order_success")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("li#doc-order_action")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("ul#box-apps-menu >li:nth-child(9)")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("li#doc-orders")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("li#doc-order_statuses")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("ul#box-apps-menu >li:nth-child(10)")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("ul#box-apps-menu >li:nth-child(11)")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("li#doc-monthly_sales")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("li#doc-most_sold_products")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("li#doc-most_shopping_customers")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("ul#box-apps-menu >li:nth-child(12)")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("li#doc-store_info")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("li#doc-defaults")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("li#doc-general")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("li#doc-listings")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("li#doc-images")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("li#doc-checkout")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("li#doc-advanced")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("li#doc-security")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("ul#box-apps-menu >li:nth-child(13)")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("ul#box-apps-menu >li:nth-child(14)")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("li#doc-tax_classes")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("li#doc-tax_rates")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("ul#box-apps-menu >li:nth-child(15)")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("li#doc-search")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("li#doc-scan")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("li#doc-csv")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("ul#box-apps-menu >li:nth-child(16)")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("ul#box-apps-menu >li:nth-child(17)")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("li#doc-vqmods")).click();
        driver.findElement(By.cssSelector("h1"));
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
