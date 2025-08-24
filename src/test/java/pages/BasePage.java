package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BasePage {

    public final String BASE_URL = "https://www.saucedemo.com/";
    public final String CART_URL = "https://www.saucedemo.com/cart.html";
    public final String CHECK_OUT_URL = "https://www.saucedemo.com/checkout-step-one.html";

    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
}


