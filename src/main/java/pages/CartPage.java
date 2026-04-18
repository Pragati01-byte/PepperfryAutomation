package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class CartPage {

    WebDriver driver;
    WebDriverWait wait;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By cartItemName = By.xpath("//div[contains(@class,'item-name')]");

    public String getCartProductName() {
        String name = wait.until(
                ExpectedConditions.visibilityOfElementLocated(cartItemName)
        ).getText();

        System.out.println("Cart Product: " + name);
        return name;
    }
}