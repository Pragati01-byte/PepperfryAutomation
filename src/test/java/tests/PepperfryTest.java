package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;

public class PepperfryTest {

    @Test
    public void verifyCartFlow() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.pepperfry.com");
        Thread.sleep(5000);

        try {
            driver.findElement(By.xpath("//a[contains(@id,'close')]")).click();
        } catch (Exception e) {
            System.out.println("No popup");
        }

        driver.findElement(By.xpath("//a[@href='/site/cart']")).click();
        Thread.sleep(5000);

        CartPage cart = new CartPage(driver);
        String cartProduct = cart.getCartProductName();

        Assert.assertTrue(
                cartProduct != null && !cartProduct.isEmpty(),
                "Cart is empty"
        );

        System.out.println("Test Passed");

        driver.quit();
    }
}