package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    private final By TITLE = By.className("title");
    private final String ADD_TO_CART_PATTERN = "//*[text()='%s']/ancestor::div[@class='inventory_item']" +
            "//button[text()='Add to cart']";
    private final By CART_BUTTON = By.className("shopping_cart_link");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }

    public void open() {
        driver.findElement(CART_BUTTON).click();
    }

    public void addYoCart(String product) {
        driver.findElement(By.xpath("//*[text()='" + product + "']/ancestor" +
                "::div[@class='inventory_item']//button[text()='Add to cart']")).click();
    }

    public void addToCart(String product) {
        driver.findElement(By.xpath(String.format(ADD_TO_CART_PATTERN, product))).click();
    }
}
