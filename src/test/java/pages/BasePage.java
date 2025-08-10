package pages;

import org.openqa.selenium.WebDriver;

public class BasePage {

    public final String BASE_URL = "https://www.saucedemo.com/";
    public final String CART_URL = "https://www.saucedemo.com/cart.html";
    public final String CHECK_OUT_URL = "https://www.saucedemo.com/checkout-step-one.html";
    WebDriver driver;
    WebDriver wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
